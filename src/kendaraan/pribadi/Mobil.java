package kendaraan.pribadi;

import kendaraan.Kendaraan;

public class Mobil extends Kendaraan {
    @Override
    public void Start() {
        System.out.println("Mobil " + getModel() + " dinyalakan");
    }

    @Override
    public void Stop() {
        System.out.println("Mobil " + getModel() + " dimatikan");
    }

    @Override
    public void Brake() {
        System.out.println("Mobil berhenti");
    }
}