package Sewa;

import Kendaraan.Mobil;
import User.User;

public class SewaMobil extends Sewa {

    public SewaMobil(Mobil mobil, int lamaSewa) {
        super(mobil, lamaSewa);
    }

    @Override
    public double hitungTotalBiaya() {
        return getKendaraan().hitungBiaya(getLamaSewa());
    }
}