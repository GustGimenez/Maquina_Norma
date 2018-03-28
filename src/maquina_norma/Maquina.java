/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_norma;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Maquina {

    //Cada elemento do arraylist representa um registrador
    //3 arraylists para manter a ligação de cada registador
    public ArrayList<Integer> regs; //Valor no registrador
    public ArrayList<Integer> sinais;   //0: positivo, 1: negativo
    public ArrayList<Integer> divs;     //Número pelo qual o valor no registrador será divido para representar um real

    public Maquina() {
        this.regs = new ArrayList();
        this.sinais = new ArrayList();
        this.divs = new ArrayList();
        //Adiçõ de 4 registradores default, A, B, C, e D
        addReg();
        addReg();
        addReg();
        addReg();
    }

    public void addReg() {
        this.regs.add(0);
        this.sinais.add(0);
        this.divs.add(1);
    }

    private int zera(int aux) {
        while (true) {
            if (aux == 0) {
                return aux;
            }
            aux--;
        }
    }

    public void zerar(int reg) {
        int aux = this.regs.get(reg); // Pega o valor do registrador do conjunto de registadores
        // Processamento no registrador
        aux = zera(aux);
        this.regs.set(reg, aux);

        // Normaliza o divisor
        aux = this.divs.get(reg);
        aux = zera(aux);
        aux++; //Deixando com o valor '1'
        this.divs.set(reg, aux);

        //Verifica o sinal.
        if (this.sinais.get(reg) == 1) {
            aux = this.sinais.get(reg);
            aux--;
            this.sinais.set(reg, aux);
        }

    }

    public void atribuir(int reg, int num, int div, int sinal) {
        this.regs.set(reg, atribui(this.regs.get(reg), num));
        this.divs.set(reg, atribui(this.divs.get(reg), div));
        this.sinais.set(reg, atribui(this.sinais.get(reg), sinal));
    }

    //Itera o valor do registrador zerado até que ele chegue no valor desejado
    private int atribui(int valorReg, int valor) {
        valorReg = zera(valorReg);
        for (int i = valor; i >= 0; i--) {
            valorReg++;
        }
        return valor;
    }

    public void somaAB(int reg1, int reg2) {
        int aux1, aux2;
        aux1 = this.regs.get(reg1);
        aux2 = this.regs.get(reg2);
        if (this.sinais.get(reg1) == 0) {
            if (this.sinais.get(reg2) == 0) {
                //SOMA DE DOIS NUMEROS POSITIVOS
                while (true) {  //Apenas decrementa o B e incrementa o A até que B seja 0
                    if (aux2 == 0) {
                        this.regs.set(reg1, aux1);
                        this.regs.set(reg2, aux2);
                        return;
                    }
                    aux1++;
                    aux2--;
                }
            } else// A positivo e B negativo
            //|A| < |B|
            {
                if (this.AmenorB(aux1, aux2)) {
                    while (true) { //Subtrai de A até que ele seja 0
                        if (aux1 == 0) {
                            while (true) {  //Soma em A no lado negativo da reta
                                if (aux2 == 0) {
                                    this.sinais.set(reg1, 1); // Mesma coisa que incrementar 1
                                    this.sinais.set(reg2, 0); // Mesma coisa que decrementar 1
                                    this.regs.set(reg1, aux1);
                                    this.regs.set(reg2, aux2);
                                    return;
                                }
                                aux1++;
                                aux2--;
                            }
                        }
                        aux1--;
                        aux2--;
                    }
                    //|A| >= |B|
                } else {
                    while (true) { //Mesmo pensamento dos dois serem positivos
                        if (aux2 == 0) {
                            this.sinais.set(reg2, 0); // Mesma coisa que decrementar 1
                            this.regs.set(reg1, aux1);
                            this.regs.set(reg2, aux2);
                            return;
                        }
                        aux1--;
                        aux2--;
                    }
                }
            }

        } else if (this.sinais.get(reg2) == 0) { // A é negativo e B Positivo
            if (this.AmenorIgualB(aux1, aux2)) { //|A| <= |B|
                while (true) {
                    if (aux1 == 0) {
                        while (true) {
                            if (aux2 == 0) {
                                this.sinais.set(reg1, 0); // Mesma coisa que decrementar 1
                                this.regs.set(reg1, aux1);
                                this.regs.set(reg2, aux2);
                                return;
                            }
                            aux1++;
                            aux2--;
                        }
                    }
                    aux1--;
                    aux2--;
                }
            } else {//|A| > |B|
                while (true) {
                    if (aux2 == 0) {
                        this.regs.set(reg1, aux1);
                        this.regs.set(reg2, aux2);
                        return;
                    }
                    aux1--;
                    aux2--;
                }

            }

        } else {
            //SOMA DE DOIS NUMEROS NEGATIVOS
            while (true) {
                if (aux2 == 0) {
                    this.regs.set(reg1, aux1);
                    this.regs.set(reg2, aux2);
                    this.sinais.set(reg2, 0); // mesmca coisa que decrementar
                    return;
                }
                aux1++;
                aux2--;
            }
        }
    }

    public void somaABC(int reg1, int reg2, int reg3) {
        int aux1, aux2, aux3;
        zerar(reg3);
        aux1 = this.regs.get(reg1);
        aux2 = this.regs.get(reg2);
        aux3 = this.regs.get(reg3);

        //Setar o mesmo valor do reg2 para o reg3, para ser usado no somaAB com reg2 e reg3
        if (this.sinais.get(reg2) == 0) {
            this.sinais.set(reg3, 0);
        } else {
            this.sinais.set(reg3, 1);
        }

        if (this.sinais.get(reg1) == 0) {
            if (this.sinais.get(reg2) == 0) {
                //A e B são positivos
                while (true) {
                    if (aux2 == 0) {
                        this.regs.set(reg1, aux1);
                        this.regs.set(reg2, aux2);
                        somaAB(reg2, reg3);
                        return;
                    }
                    aux3++;
                    aux1++;
                    aux2--;
                }
            } else { //A é positivo e B é negativo
                if (AmenorB(aux1, aux2)) { //|A| < |B|
                    while (true) {
                        if (aux1 == 0) {
                            while (true) {
                                if (aux2 == 0) {
                                    this.regs.set(reg1, aux1);
                                    this.regs.set(reg2, aux2);
                                    this.regs.set(reg3, aux3);
                                    this.sinais.set(reg1, 1);
                                    this.sinais.set(reg2, 0);
                                    somaAB(reg2, reg3); //Volta o valor de reg2 ao original
                                    return;
                                }
                                aux1++;
                                aux2--;
                                aux3++;
                            }
                        }
                        aux1--;
                        aux2--;
                        aux3++;
                    }
                } else {   //|A| > |B|
                    while (true) {
                        if (aux2 == 0) {
                            this.regs.set(reg1, aux1);
                            this.regs.set(reg2, aux2);
                            this.regs.set(reg3, aux3);
                            this.sinais.set(reg2, 0);
                            somaAB(reg2, reg3);
                            return;
                        }
                        aux1--;
                        aux2--;
                        aux3++;
                    }
                }
            }
        } else {
            if (this.sinais.get(reg2) == 0) { //A é negativo e B é positivo
                if (AmenorIgualB(aux1, aux2)) { //|A| <= |B|
                    while (true) {
                        if (aux1 == 0) {
                            while (true) {
                                if (aux2 == 0) {
                                    this.regs.set(reg1, aux1);
                                    this.regs.set(reg2, aux2);
                                    this.regs.set(reg3, aux3);
                                    this.sinais.set(reg1, 0);
                                    somaAB(reg2, reg3); //Volta o valor de reg2 ao original
                                    return;
                                }
                                aux1++;
                                aux2--;
                                aux3++;
                            }
                        }
                        aux1--;
                        aux2--;
                        aux3++;
                    }
                } else {    //|A| > |B|
                    while (true) {
                        if (aux2 == 0) {
                            this.regs.set(reg1, aux1);
                            this.regs.set(reg2, aux2);
                            this.regs.set(reg3, aux3);
                            somaAB(reg2, reg3); //Volta o valor de reg2 ao original
                            return;
                        }
                        aux1--;
                        aux2--;
                        aux3++;
                    }
                }
            } else {   //A e B são negativos
                while (true) {
                    if (aux2 == 0) {
                        this.regs.set(reg1, aux1);
                        this.regs.set(reg2, aux2);
                        this.regs.set(reg3, aux3);
                        this.sinais.set(reg2, 0);
                        somaAB(reg2, reg3); //Volta o valor de reg2 ao original
                        return;
                    }
                    aux1++;
                    aux2--;
                    aux3++;
                }
            }
        }
    }

    public void atribuirABC(int reg1, int reg2, int reg3) {
        zerar(reg1);
        this.somaABC(reg1, reg2, reg3);
        if (this.sinais.get(reg2) == 0) {
            return;
        }
        int aux = this.sinais.get(reg1);
        aux--;
        this.sinais.set(reg1, aux);
    }

//    public void multiplicaAB_CD(int reg1, int reg2, int reg3, int reg4) {
//        zerar(reg3);
//        int aux1, aux2, aux3, aux4;
//        aux1 = this.regs.get(reg1);
//        aux2 = this.regs.get(reg2);
//        aux3 = this.regs.get(reg3);
//        aux4 = this.regs.get(reg4);
//        while (true) {
//            if () {
//
//            }
//        }
//    }
    //Decrementa ambos os valores, aquele que chegar em 0 primeiro é o menor
    //Ou, se chegarem juntos, nenhum é menor
    public boolean AmenorB(int valorA, int valorB) {
        while (true) {
            if (valorA == 0) {
                if (valorB == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            if (valorB == 0) {
                return false;
            }
            valorA--;
            valorB--;
        }
    }

    //Praticamente o memso pensamento
    public boolean AmenorIgualB(int valorA, int valorB) {
        while (true) {
            if (valorA == 0) {
                return true;
            }
            if (valorB == 0) {
                return false;
            }
            valorA--;
            valorB--;
        }
    }
}
