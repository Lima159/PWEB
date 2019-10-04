/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author ialima
 */
public class Farmacia {
    private ArrayList<Remedio> normais = new ArrayList<Remedio>();
    private ArrayList<Remedio> naoControlados = new ArrayList<Remedio>();
    private ArrayList<Remedio> controlados = new ArrayList<Remedio>();

    public ArrayList<Remedio> getNormais() {
        return normais;
    }

    public ArrayList<Remedio> getNaoControlados() {
        return naoControlados;
    }

    public ArrayList<Remedio> getControlados() {
        return controlados;
    }
    
    
    
}
