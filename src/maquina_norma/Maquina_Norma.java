/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_norma;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Gustavo
 */
public class Maquina_Norma {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Maquina maquina = new Maquina();
        
        maquina.atribuir(0, 4, 1, 0);
        maquina.primoNumABCD(0, 1, 2, 3);
    }
}
