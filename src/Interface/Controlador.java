/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import maquina_norma.Maquina;
import maquina_norma.Registrador;

/**
 *
 * @author Gustavo
 */
public class Controlador {

    private Maquina maquina;
    private int[] info;

    public Controlador() {
        this.maquina = new Maquina();
        this.info = new int[3];
    }

    public int[] getInfosReg(int pos) {
        info[0] = this.maquina.regs.get(pos).getValor(); //Posição 0 -> valor do Reg
        info[1] = this.maquina.sinais.get(pos).getValor(); //Posição 1 -> sinal do Reg
        info[2] = this.maquina.divs.get(pos).getValor(); //Posição 2 -> valor do Reg

        return this.info;
    }

    /*Por pré definição, os registradores serão organizados da seguinte forma:
    A -> 0
    B -> 1
    C -> 2
    D -> 3
     */
    public void atribuirA(int valor, int sinal, int div) {
        this.maquina.atribuir(0, valor, div, sinal);
    }

    public void atribuirB(int valor, int sinal, int div) {
        this.maquina.atribuir(1, valor, div, sinal);
    }

    public void somaAB() {
        this.maquina.somaNumAB(0, 1);
    }

    public void somaABC() {
        this.maquina.somaNumABC(0, 1, 2);
    }

    public void multAB() {
        this.maquina.multiplicaNumACBD(0, 1, 2, 3);
    }

    public void divAB() {
        Registrador aux = new Registrador();
        aux.incrementa(); // = 1

        if (this.maquina.menorAux(this.maquina.divs.get(0), aux)) { // Se forem inteiros
            if (this.maquina.menorAux(this.maquina.divs.get(1), aux)) {
                this.maquina.divideNumIntABCD(0, 1, 2, 3);
            }
        } else {    // Re forem reais
            this.maquina.divideNumReaisA(0, 1);
        }
    }

    public void fatorialA() {
        this.maquina.fatorialNumA(0, 2);
    }
    
    public void potenciacaoAB(){
        this.maquina.potenciacaoNumABC(0, 1, 2);
    }
    
    public void primoABCD(){
        this.maquina.primoNumABCD(0, 2);
    }
    
    public void zeraMaquina(){
        this.maquina.resetRegs();
    }
    
    public void empilha(int num){
        this.maquina.empilha(num);
    }
    
    public int desempilha(){
        return this.maquina.desempilha();
    }
    
    public int topoPilha(){
        return this.maquina.recuperaTopo();
    }
    
    public void inicializaPilha(){
        this.maquina.inicializaPilha();
    }
}
