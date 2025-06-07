package User;

import Kendaraan.Kendaraan;
import java.util.List;

public class Pelanggan extends User {

    public Pelanggan(String id, String nama, String noTelepon, String alamat) {
        super(id, nama, noTelepon, alamat);
    }

    public void lihatDaftarKendaraan(List<? extends Kendaraan> daftar) {
        System.out.println("=== Daftar Kendaraan ===");
        for (Kendaraan k : daftar) {
            if (k.isTersedia()) {
                k.printDetail();
            }
        }
    }
}