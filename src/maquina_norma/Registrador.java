/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maquina_norma;

/**
 *
 * @author fabio
 */
public class Registrador {

    private int valor;

    public Registrador() {
        this.valor = 0;
    }

    public int getValor() {
        return this.valor;
    }

    public boolean isZero() {
        return this.valor == 0;
    }

    public void incrementa() {
        this.valor++;
    }

    public void decrementa() {
        if (this.isZero()) {
            return;
        }
        this.valor--;
    }
}
