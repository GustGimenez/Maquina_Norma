/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import maquina_norma.Maquina;

/**
 *
 * @author Gustavo
 */
public class Controlador {
    private Maquina maquina;
    private int[] info;
    
    public Controlador(){
        this.maquina = new Maquina();
        this.info = new int[3];
    }
    
    public int[] getInfosReg(int pos){
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
    public void atribuirA(int valor, int sinal, int div){
        this.maquina.atribuir(0, valor, div, sinal);  
    }
    
    public void atribuirB(int valor, int sinal, int div){
        this.maquina.atribuir(1, valor, div, sinal);
    }
    
    public void somaAB(){
        this.maquina.somaNumAB(0, 1); 
    }
    
    public void somaABC(){
        this.maquina.somaNumABC(0, 1, 2);
    }
    
    public void multAB(){
        this.maquina.multiplicaNumACBD(0, 1, 2, 3);
    }
    
    public void divAB(){
        this.maquina.divideNumIntABCD(0, 1, 2, 3);
    }
        
    public void fatorialAB(){
        this.maquina.fatorialNumAB(0, 1);
    }
}
