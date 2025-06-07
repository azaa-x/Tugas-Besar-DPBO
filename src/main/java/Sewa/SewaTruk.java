package Sewa;

import Kendaraan.Truk;

public class SewaTruk extends Sewa {

    public SewaTruk(Truk truk, int lamaSewa) {
        super(truk, lamaSewa);
    }

    @Override
    public double hitungTotalBiaya() {
        return getKendaraan().hitungBiaya(getLamaSewa());
    }
}