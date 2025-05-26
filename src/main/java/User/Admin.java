package User;

import java.util.List;

import DPBO.Tubes1.*;
import Kendaraan.Kendaraan;

public class Admin extends User {

    public Admin(String id, String nama, String noTelepon, String alamat) {
        super(id, nama, noTelepon, alamat);
    }

    public void tambahKendaraan(List<Kendaraan> daftar, Kendaraan kendaraan) {
        daftar.add(kendaraan);
        System.out.println("Kendaraan merk " + kendaraan.getMerek() + " dengan model "  + kendaraan.getModel() + " ditambahkan.");
    }

    public void hapusKendaraan(List<Kendaraan> daftar, String idKendaraan) {
        daftar.removeIf(k -> k.getId().equals(idKendaraan));
        System.out.println("Kendaraan dengan ID " + idKendaraan + " telah dihapus.");
    }
}
