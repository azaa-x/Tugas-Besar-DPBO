package User;

import Kendaraan.Kendaraan;
import java.util.List;

public class Admin extends User {
    public Admin(String id, String nama, String noTelepon, String alamat) {
        super(id, nama, noTelepon, alamat);
    }

    @Override
    public void login() {
        System.out.println("Admin " + getNama() + " berhasil login.");
    }

    @Override
    public void logout() {
        System.out.println("Admin " + getNama() + " telah logout.");
    }

    // Gunakan generic <T extends Kendaraan>
    public <T extends Kendaraan> void tambahKendaraan(List<T> daftar, T kendaraan) {
        daftar.add(kendaraan);
        System.out.println("Kendaraan merk " + kendaraan.getMerek() + " dengan model " + kendaraan.getModel() + " ditambahkan.");
    }

    public <T extends Kendaraan> void hapusKendaraan(List<T> daftar, String idKendaraan) {
        boolean removed = daftar.removeIf(k -> k.getId().equalsIgnoreCase(idKendaraan));
        if (removed) {
            System.out.println("Kendaraan dengan ID " + idKendaraan + " telah dihapus.");
        } else {
            System.out.println("Kendaraan dengan ID " + idKendaraan + " tidak ditemukan.");
        }
    }
}
