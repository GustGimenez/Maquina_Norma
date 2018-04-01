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

    private void atribuirRegABC(Registrador regA, Registrador regB, Registrador regC) {
        this.zeraReg(regA);
        this.somaRegABC(regA, regB, regC);
    }

    public void multiplicaRegACBD(Registrador regA, Registrador regB, Registrador regC, Registrador regD) {
        this.zeraReg(regC);
        while (true) {
            if (regA.isZero()) {
                break;
            }
            regA.decrementa();
            regC.incrementa();
        }

        while (true) {
            if (regC.isZero()) {
                return;
            }
            this.somaRegABC(regA, regB, regD);
            regC.decrementa();
        }

    }

    private void divideRegIntABCD(Registrador regA, Registrador regB, Registrador regC, Registrador regD) {
        this.zeraReg(regC);
        this.zeraReg(regD);
        Registrador regAux = new Registrador();
        while (true) {
            //A divisão inteira para quando quando o dividendo for menor que o divisor
            if (this.AMenorB(regA, regB)) {
                break;
            } else {   
                //RegD é usado como auxiliar para decrementar o dividendo
                this.atribuirRegABC(regD, regB, regAux);
                while (true) {
                    if (regD.isZero()) {
                        break;
                    }
                    regA.decrementa();
                    regD.decrementa();
                }
                //RegC é àquele que guarda o resultado da divisão
                regC.incrementa();
            }
        }
        //Da pra fazer um método de resto e chamar aqui...
    }

    // Operação com NUMEROS
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
        Registrador regA, regB, divA, divB, sinalA, sinalB;
        Registrador auxC, auxD; // Auxxiliar na multiplicação
        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        divA = this.divs.get(pos1);
        divB = this.divs.get(pos2);
        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);

        auxC = new Registrador();
        auxD = new Registrador();
        // Regra de multiplicação de fração
        this.multiplicaRegACBD(regA, divB, auxC, auxD);
        this.multiplicaRegACBD(regB, divA, auxC, auxD);
        this.multiplicaRegACBD(divA, divB, auxC, auxD);

        //Soma dos resultados e ajuste de sinal
        if (sinalA.isZero()) {
            if (sinalB.isZero()) {
                //SOMA DE DOIS NUMEROS POSITIVOS
                this.somaRegAB(regA, regB);
            } else // A positivo e B negativo
            {
                if (this.AMenorB(regA, regB)) {
                    //Se |A| < |B|, então A fica negativo
                    this.difRegAB(regA, regB);
                    sinalA.incrementa();
                } else {
                    this.difRegAB(regA, regB);
                }
            }
        } else if (sinalB.isZero()) {
            // A é negativo e B Positivo

            if (this.AMenorIgualB(regA, regB)) {
                //|A| <= |B|
                this.difRegAB(regA, regB);
                sinalA.decrementa();
            } else {
                this.difRegAB(regA, regB);
            }

        } else {
            //SOMA DE DOIS NUMEROS NEGATIVOS, sinais ficam iguais
            this.somaRegAB(regA, regB);

        }

        sinalB.decrementa(); // B fica zero depois dessa operação
        this.regs.get(0).getValor();
        this.regs.get(1).getValor();
    }

    public void somaNumABC(int pos1, int pos2, int pos3) {
        //Soma A e B e armazena resultado em A
        Registrador regA, regB, regC, divA, divB, sinalA, sinalB;
        Registrador auxB, auxC, auxD;
        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        regC = this.regs.get(pos3);
        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        divA = this.divs.get(pos1);
        divB = this.divs.get(pos2);

        auxB = new Registrador();
        auxC = new Registrador();
        auxD = new Registrador();
        //Regra de operacao com fração
        this.atribuirRegABC(auxB, divA, regC);

        this.multiplicaRegACBD(regA, divB, auxC, auxD);
        this.multiplicaRegACBD(auxB, regB, auxC, auxD);
        this.multiplicaRegACBD(divA, divB, auxC, auxD);
        if (sinalA.isZero()) {
            if (sinalB.isZero()) {
                //SOMA DE DOIS NUMEROS POSITIVOS
                this.somaRegABC(regA, auxB, regC);
            } else // A positivo e B negativo
            if (this.AMenorB(regA, auxB)) {
                //Se |A| < |B|, então A fica negativo
                this.difRegABC(regA, auxB, regC);
                sinalA.incrementa();
            } else {
                this.difRegABC(regA, auxB, regC);
            }
        } else if (sinalB.isZero()) {
            // A é negativo e B Positivo

            if (this.AMenorIgualB(regA, auxB)) {
                //|A| <= |B|
                this.difRegABC(regA, auxB, regC);
                sinalA.decrementa();
            } else {
                this.difRegABC(regA, auxB, regC);
            }

        } else {
            //SOMA DE DOIS NUMEROS NEGATIVOS, sinais ficam iguais
            this.somaRegABC(regA, auxB, regC);

        }
    }

    public void atribuirNumABC(int pos1, int pos2, int pos3) {
        Registrador regA, regB, regC, divA, divB;
        Registrador sinalA, sinalB;

        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        regC = this.regs.get(pos3);

        divA = this.divs.get(pos1);
        divB = this.divs.get(pos2);

        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);

        this.atribuirRegABC(regA, regB, regC);
        this.atribuirRegABC(divA, divB, regC);
        this.zeraReg(sinalA);
        if (sinalB.isZero()) {
            return;
        }
        sinalA.incrementa();
    }

    public void multiplicaNumACBD(int pos1, int pos2, int pos3, int pos4) {
        Registrador regA, regB, regC, regD, divA, divB;
        Registrador sinalA, sinalB;

        regA = this.regs.get(pos1);
        regB = this.regs.get(pos2);
        regC = this.regs.get(pos3);
        regD = this.regs.get(pos4);

        divA = this.divs.get(pos1);
        divB = this.divs.get(pos2);

        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        this.multiplicaRegACBD(regA, regB, regC, regD);
        this.multiplicaRegACBD(divA, divB, regC, regD);

        if (sinalB.isZero()) {
            return;
        }

        if (sinalA.isZero()) {
            sinalA.incrementa();
        } else {
            sinalA.decrementa();
        }
    }

    public void divideNumIntABCD(int pos1, int pos2, int pos3, int pos4) {
        Registrador regA, regB, regC, regD, sinalA, sinalB, sinalC;

        regA = this.regs.get(pos1); //Devidendo
        regB = this.regs.get(pos2); //Divisor
        regC = this.regs.get(pos3); //Resultado
        regD = this.regs.get(pos4); //Auxiliador

        sinalA = this.sinais.get(pos1);
        sinalB = this.sinais.get(pos2);
        sinalC = this.sinais.get(pos3);

        this.divideRegIntABCD(regA, regB, regC, regD);
        
        //A for positivo e B negativo C é negativo
        if (sinalA.isZero()) {
            if (!sinalB.isZero()) {
                sinalC.incrementa();
            }
        } else { //A for negativo e B positivo C é negativo
            if (sinalB.isZero()) {
                sinalC.incrementa();
            }
        }
        
        this.regs.get(0).getValor();
        this.regs.get(1).getValor();
        this.regs.get(2).getValor();
        this.regs.get(3).getValor();
        return;
    }
}
