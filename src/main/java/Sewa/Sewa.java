package Sewa;

import Kendaraan.Kendaraan;

public abstract class Sewa {
    private Kendaraan kendaraan;
    private int lamaSewa;

    public Sewa(Kendaraan kendaraan, int lamaSewa) {
        this.kendaraan = kendaraan;
        this.lamaSewa = lamaSewa;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public void setKendaraan(Kendaraan kendaraan) {
        this.kendaraan = kendaraan;
    }

    public int getLamaSewa() {
        return lamaSewa;
    }

    public void setLamaSewa(int lamaSewa) {
        this.lamaSewa = lamaSewa;
    }

    public abstract double hitungTotalBiaya();

    public void prosesSewa() {
        if (kendaraan.isTersedia()) {
            kendaraan.setTersedia(false);
            System.out.println("Sewa berhasil. Total biaya: Rp " + hitungTotalBiaya());
        } else {
            System.out.println("Maaf, kendaraan ini sedang tidak tersedia.");
        }
    }

    public void tampilkanInfo() {
        System.out.println("Kendaraan: " + kendaraan.getMerek() + " " + kendaraan.getModel());
        System.out.println("Lama Sewa: " + lamaSewa + " hari");
        System.out.println("Total Biaya: Rp " + hitungTotalBiaya());
    }
}