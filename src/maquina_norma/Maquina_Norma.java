/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_norma;

import Interface.Principal;
import java.io.IOException;

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
        Principal view = new Principal();
        
        view.setVisible(true);
    }
}
