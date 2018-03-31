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
    public ArrayList<Registrador> regs; //Valor no registrador
    public ArrayList<Registrador> sinais;   //0: positivo, 1: negativo
    public ArrayList<Registrador> divs;     //Número pelo qual o valor no registrador será divido para representar um real

    public Maquina() {
        this.regs = new ArrayList();
        this.sinais = new ArrayList();
        this.divs = new ArrayList();
        //Adiçõ de 4 registradores default, A, B, C, e D
        addNum();
        addNum();
        addNum();
        addNum();
    }

    // Numeros são formados por 3 Registradores: Numerador, Divisor e Sinal.
    public void addNum() {
        this.regs.add(new Registrador());
        this.sinais.add(new Registrador());
        Registrador r = new Registrador();
        r.incrementa();
        this.divs.add(r);
    }

    // Operações com registradores 
    private void zeraReg(Registrador reg) {
        while (true) {
            if (reg.isZero()) {
                return;
            }
            reg.decrementa();
        }
    }

    private void atribuiReg(Registrador reg, int num) {
        zeraReg(reg);
        for (int i = 0; i < num; i++) {
            reg.incrementa();
        }
    }

    private void somaRegAB(Registrador regA, Registrador regB) {
        while (true) {
            if (regB.isZero()) {
                return;
            }

            regA.incrementa();
            regB.decrementa();
        }
    }

    private void somaRegABC(Registrador regA, Registrador regB, Registrador regC) {
        zeraReg(regC);
        while (true) {
            if (regB.isZero()) {
                break;
            }
            regB.decrementa();
            regC.incrementa();
        }

        while (true) {
            if (regC.isZero()) {
                return;
            }

            regA.incrementa();
            regB.incrementa();
            regC.decrementa();
        }
    }

    private void difRegAB(Registrador regA, Registrador regB) {
        //Armazena em A a diferença (absoluta) entre A e B (perde o valor de B)

        while (true) {
            if (regB.isZero()) {
                return;
            }
            if (regA.isZero()) {
                while (true) {
                    if (regB.isZero()) {
                        return;
                    }
                    regA.incrementa();
                    regB.decrementa();
                }
            }
            regA.decrementa();
            regB.decrementa();
        }
    }

    private void difRegABC(Registrador regA, Registrador regB, Registrador regC) {
        //Armazena a diferença absoluta entre A e B em A e utiliza C para recuperar o valor de B

        zeraReg(regC);
        while (true) {
            if (regB.isZero()) {
                while (true) {
                    if (regC.isZero()) {
                        return;
                    }

                    regB.incrementa();
                    regC.decrementa();
                }
            }
            if (regA.isZero()) {
                while (true) {
                    if (regB.isZero()) {
                        while (true) {
                            if (regC.isZero()) {
                                return;
                            }
                            regB.incrementa();
                            regC.decrementa();
                        }
                    }
                    regB.decrementa();
                    regA.incrementa();
                    regC.incrementa();
                }
            }
            regA.decrementa();
            regB.decrementa();
            regC.incrementa();
        }
    }

    private boolean AMenorIgualB(Registrador regA, Registrador regB) {
        Registrador aux = new Registrador();
        zeraReg(aux);
        /* 
        Variavel aux serve para recuperar o valor de A e B
        Como a maquina tem "infinitos" registradores, simula um reg aleatorio
         */
        while (true) {
            if (regA.isZero()) {
                while (true) {
                    if (aux.isZero()) {
                        return true;
                    }
                    regA.incrementa();
                    regB.incrementa();
                    aux.decrementa();
                }
            }
            if (regB.isZero()) {
                while (true) {
                    if (aux.isZero()) {
                        return false;
                    }
                    regA.incrementa();
                    regB.incrementa();
                    aux.decrementa();
                }
            }
            regA.decrementa();
            regB.decrementa();
            aux.incrementa();
        }
    }

    private boolean AMenorB(Registrador regA, Registrador regB) {
        Registrador aux = new Registrador();
        zeraReg(aux);
        /* 
        A diferença entre Menor e Menor igual é que o B é verificado primeiro.
        Se o B for verificado como zero, mesmo que A seja 0 ele já da falso, pois se os dois
        chegaram a zero ao mesmo tempo, não é menor.
         */
        while (true) {
            if (regB.isZero()) {
                while (true) {
                    if (aux.isZero()) {
                        return false;
                    }
                    regA.incrementa();
                    regB.incrementa();
                    aux.decrementa();
                }
            }
            if (regA.isZero()) {
                while (true) {
                    if (aux.isZero()) {
                        return true;
                    }
                    regA.incrementa();
                    regB.incrementa();
                    aux.decrementa();
                }
            }

            regA.decrementa();
            regB.decrementa();
            aux.incrementa();
        }
    }

    private void atribuirRegABC(Registrador reg1, Registrador reg2, Registrador reg3) {
        this.zeraReg(reg1);
        this.somaRegABC(reg1, reg2, reg3);
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
    
    public void zerarNum(int pos) {
        Registrador aux = this.regs.get(pos); // Pega o valor do registrador do conjunto de registadores
        // Processamento no registrador
        zeraReg(aux);
        // Normaliza o divisor
        aux = this.divs.get(pos);
        zeraReg(aux);
        aux.incrementa();

        //Verifica o sinal.
        aux = this.sinais.get(pos);
        if (aux.isZero()) {
            return;
        }
        aux.decrementa();
    }

    public void atribuir(int pos, int num, int div, int sinal) {//Testado e funcionando
        Registrador regDiv, regNum, regSin;

        regNum = this.regs.get(pos);
        regSin = this.sinais.get(pos);
        regDiv = this.divs.get(pos);

        this.atribuiReg(regNum, num);
        this.atribuiReg(regSin, sinal);
        this.atribuiReg(regDiv, div);
    }

    public void somaNumAB(int pos1, int pos2) {
        //Soma A e B e armazena resultado em A
        Registrador regA, regB, sinalA, sinalB;
        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        if (sinalA.isZero()) {
            if (sinalB.isZero()) {
                //SOMA DE DOIS NUMEROS POSITIVOS
                this.somaRegAB(regA, regB);
            } else {
                // A positivo e B negativo
                this.difRegAB(regA, regB);
                sinalB.decrementa(); // B fica zero depois dessa operação
                if (this.AMenorB(regA, regB)) {
                    //Se |A| < |B|, então A fica negativo
                    sinalA.incrementa();
                }
            }
        } else if (sinalB.isZero()) {
            // A é negativo e B Positivo
            this.difRegAB(regA, regB);
            if (this.AMenorIgualB(regA, regB)) {
                //|A| <= |B|
                sinalA.decrementa();
            }

        } else {
            //SOMA DE DOIS NUMEROS NEGATIVOS, sinais ficam iguais
            this.somaRegAB(regA, regB);

        }
    }

    public void somaNumABC(int pos1, int pos2, int pos3) {
        //Soma A e B e armazena resultado em A
        Registrador regA, regB, regC, sinalA, sinalB;
        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        regC = this.regs.get(pos3);
        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        if (sinalA.isZero()) {
            if (sinalB.isZero()) {
                //SOMA DE DOIS NUMEROS POSITIVOS
                this.somaRegABC(regA, regB, regC);
            } else {
                // A positivo e B negativo
                this.difRegABC(regA, regB, regC);
                if (this.AMenorB(regA, regB)) {
                    //Se |A| < |B|, então A fica negativo
                    sinalA.incrementa();
                }
            }
        } else if (sinalB.isZero()) {
            // A é negativo e B Positivo
            this.difRegABC(regA, regB, regC);
            if (this.AMenorIgualB(regA, regB)) {
                //|A| <= |B|
                sinalA.decrementa();
            }

        } else {
            //SOMA DE DOIS NUMEROS NEGATIVOS, sinais ficam iguais
            this.somaRegABC(regA, regB, regC);

        }
    }

    public void atribuirNumABC(int pos1, int pos2, int pos3) {
        Registrador regA, regB, regC;
        Registrador sinalA, sinalB;

        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        regC = this.regs.get(pos3);

        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        this.atribuirRegABC(regA, regB, regC);
        
        this.zeraReg(sinalA);
        if (sinalB.isZero()) {
            return;
        }
        sinalA.incrementa();
    }
}
