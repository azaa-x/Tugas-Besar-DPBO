package User;

import Sewa.Sewa;

public class Pelanggan extends User {
    private Sewa sewaAktif;

    public Pelanggan(String id, String nama, String noTelepon, String alamat) {
        super(id, nama, noTelepon, alamat);
    }

    public Sewa getSewaAktif() {
        return sewaAktif;
    }

    public void setSewaAktif(Sewa sewa) {
        this.sewaAktif = sewa;
    }

    public void hapusSewaAktif() {
        this.sewaAktif = null;
    }

    @Override
    public void login() {
        System.out.println("Login sebagai pelanggan berhasil. Selamat datang, " + getNama() + "!");
    }

    @Override
    public void logout() {
        System.out.println("Logout berhasil. Terima kasih, " + getNama() + "!");
    }
}
