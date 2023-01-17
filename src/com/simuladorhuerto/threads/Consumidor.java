package com.simuladorhuerto.threads;

import com.simuladorhuerto.resources.Huerto;

public class Consumidor extends Thread{

    private String nombreConsumidor;
    private Huerto huerto;
    private int consumicionMax;
    private final long tiempoConsumo;

    public Consumidor(String nombreConsumidor, int consumicionMax, int tiempoConsumo, Huerto huerto) {
        this.nombreConsumidor = nombreConsumidor;
        this.consumicionMax = consumicionMax;
        this.huerto = huerto;
        this.tiempoConsumo = tiempoConsumo * 1000;
    }

    @Override
    public void run() {
        for (int i = 0; i < this.consumicionMax; i++) {
            try {
                String verduraAConsumir = this.huerto.consumirVerdura(this.nombreConsumidor);
                Thread.sleep(this.tiempoConsumo);
                System.out.println(this.nombreConsumidor + " ha consumido " + verduraAConsumir);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
