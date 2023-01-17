package com.simuladorhuerto.resources;
import java.util.ArrayList;

public class Huerto {
    private int capacidad;
    private ArrayList<String> verdurasDisponibles = new ArrayList<String>();

    public Huerto(int capacidadHuerto) {
        this.capacidad = capacidadHuerto;
    }

    synchronized public void anadirVerdura(String nombreGranjero, String nuevaVerdura) throws InterruptedException {
        while (this.verdurasDisponibles.size() >= this.capacidad) {
            wait();
        }
        this.verdurasDisponibles.add(nuevaVerdura);
        System.out.println(nombreGranjero + " ha producido " + nuevaVerdura);
        notifyAll();
    }

    synchronized public String consumirVerdura(String clientName) throws InterruptedException {
        while (this.verdurasDisponibles.size() == 0) {
            wait();
        }
        String verduraAConsumir = this.verdurasDisponibles.remove(0);
        notifyAll();
        return verduraAConsumir;
    }
}