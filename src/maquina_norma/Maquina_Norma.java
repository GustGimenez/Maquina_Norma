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
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Maquina maquina = new Maquina();
        int A = Integer.valueOf(input.readLine());
        int valor = Integer.valueOf(input.readLine());
        maquina.atribuir(A, valor, 2, 0);
        int B = Integer.valueOf(input.readLine());
        valor = Integer.valueOf(input.readLine());
        maquina.atribuir(B, valor, 3, 1);
        maquina.somaNumABC(A, B, 2);
        
        System.out.println("Pausa");
    }
}
