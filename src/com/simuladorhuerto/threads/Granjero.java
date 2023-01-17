package com.simuladorhuerto.threads;

import com.simuladorhuerto.resources.Huerto;
public class Granjero extends Thread{
    private String nombreGranjero;
    private int maximaProduccion;
    private int tiempoMaximoCrecimiento;
    private Huerto huerto;

    public Granjero(String nombreGranjero, int maximaProduccion, int tiempoMaximoCrecimiento, Huerto huerto) {
        this.nombreGranjero = nombreGranjero;
        this.maximaProduccion = maximaProduccion;
        this.tiempoMaximoCrecimiento = tiempoMaximoCrecimiento;
        this.huerto = huerto;
    }

    private String obtenerVerduraRandom() {
        String[] verduras = {"lettuce",  "cabbage", "onion", "spinach", "potato", "celery", "asparagus", "radish", "broccoli", "artichoke", "tomato", "cucumber", "eggplant", "carrot", "green bean"};
        return verduras[(int) (Math.random() * (verduras.length - 1))];
    }

    private long obtenerTiempoCrecimiento() {
        return (long) (Math.random() * (this.tiempoMaximoCrecimiento - 1)) + 1;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.maximaProduccion; i++) {
            try {
                String verduraAProducir = this.obtenerVerduraRandom();
                long tiempoCrecimiento = this.obtenerTiempoCrecimiento();
                Thread.sleep(tiempoCrecimiento * 1000);
                this.huerto.anadirVerdura(nombreGranjero, verduraAProducir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
