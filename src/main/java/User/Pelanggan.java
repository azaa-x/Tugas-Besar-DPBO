package User;

import java.util.ArrayList;
import java.util.List;

import DPBO.Tubes1.*;
import User.Sewa;
import User.User;

public class Pelanggan extends User {
    private List<Sewa> riwayatSewa = new ArrayList<>();

    public Pelanggan(String id, String nama, String noTelepon, String alamat) {
        super(id, nama, noTelepon, alamat);
    }

    public void lihatDaftarKendaraan(List<Kendaraan> daftar) {
        System.out.println("=== Daftar Kendaraan ===");
        for (Kendaraan k : daftar) {
            System.out.println(k);
        }
    }

    public void sewaKendaraan(Kendaraan kendaraan, String idSewa, int lamaHari) {
        if (kendaraan.isTersedia()) {
            Sewa sewa = new Sewa(idSewa, this, kendaraan, LocalDate.now(), LocalDate.now().plusDays(lamaHari));
            riwayatSewa.add(sewa);
            System.out.println("Berhasil menyewa: " + kendaraan.getNama());
        } else {
            System.out.println("Kendaraan tidak tersedia.");
        }
    }

    public void lihatRiwayatSewa() {
        System.out.println("=== Riwayat Sewa ===");
        for (Sewa s : riwayatSewa) {
            System.out.println("- " + s.getIdSewa() + " | Aktif: " + s.isAktif());
        }
    }
}

