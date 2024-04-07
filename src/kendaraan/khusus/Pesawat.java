package kendaraan.khusus;

import kendaraan.Kendaraan;
import kendaraan.util.Flyable;

public class Pesawat extends Kendaraan implements Flyable {
    @Override
    public void Start() {
        System.out.println("Mennyalakan pesawat " + getModel());
    }

    @Override
    public void Stop() {
        System.out.println("Mematikan mesin pesawat " + getModel());
    }

    @Override
    public void Brake() {
        System.out.println("Pesawat "+ getModel() +" mengurangi kecepatan/ mengerem");
    }

    @Override
    public void fly() {
        System.out.println("Pesawat " + getModel() + " lepas landas");
    }
}
