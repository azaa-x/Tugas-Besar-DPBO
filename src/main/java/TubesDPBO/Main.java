package TubesDPBO;

import User.Admin;
import User.Pelanggan;
import Kendaraan.Mobil;
import Kendaraan.Truk;
import Kendaraan.Kendaraan;
import Sewa.SewaMobil;
import Sewa.SewaTruk;
import Sewa.Sewa;
import Report.DamageReport;
import Report.Insurance;
import Report.Maintenance;

import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#,###");

        List<Mobil> daftarMobil = new ArrayList<>();
        daftarMobil.add(new Mobil("M001", "Toyota", "Avanza", 2020, 400000, 7, "MPV"));
        daftarMobil.add(new Mobil("M002", "Honda", "Brio", 2019, 350000, 5, "Hatchback"));

        List<Truk> daftarTruk = new ArrayList<>();
        daftarTruk.add(new Truk("T001", "Mitsubishi", "Canter", 2018, 500000, 5.0, "Box"));
        daftarTruk.add(new Truk("T002", "Isuzu", "Giga", 2021, 650000, 10.0, "Bak Terbuka"));

        List<DamageReport> laporanKerusakan = new ArrayList<>();
        List<Insurance> laporanAsuransi = new ArrayList<>();
        List<Maintenance> laporanMaintenance = new ArrayList<>();

        while (true) {
            System.out.println("\n=== SELAMAT DATANG ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Pelanggan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int menu = scanner.nextInt(); scanner.nextLine();

            if (menu == 0) break;

            if (menu == 1) {
                System.out.print("Masukkan nama admin: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan password admin: ");
                String password = scanner.nextLine();

                if (nama.equals("admin") && password.equals("admin123")) {
                    Admin admin = new Admin("ADM001", nama, "-", "-");
                    admin.login();

                    int pilihAdmin;
                    do {
                        System.out.println("\n=== MENU ADMIN ===");
                        System.out.println("1. Tambah Mobil");
                        System.out.println("2. Tambah Truk");
                        System.out.println("3. Hapus Mobil");
                        System.out.println("4. Hapus Truk");
                        System.out.println("5. Lihat Laporan Asuransi");
                        System.out.println("6. Teruskan Laporan Asuransi");
                        System.out.println("7. Set Maintenance Kendaraan");
                        System.out.println("0. Logout");
                        System.out.print("Pilih: ");
                        pilihAdmin = scanner.nextInt(); scanner.nextLine();

                        switch (pilihAdmin) {
                            case 7:
                                System.out.print("ID Kendaraan: ");
                                String idK = scanner.nextLine();
                                boolean ditemukan = false;
                                for (Kendaraan k : daftarMobil) {
                                    if (k.getId().equalsIgnoreCase(idK)) {
                                        k.setMaintenance(true);
                                        laporanMaintenance.add(new Maintenance("Maintenance oleh admin", new Date()));
                                        System.out.println("Kendaraan dalam status maintenance.");
                                        ditemukan = true;
                                        break;
                                    }
                                }
                                if (!ditemukan) {
                                    for (Kendaraan k : daftarTruk) {
                                        if (k.getId().equalsIgnoreCase(idK)) {
                                            k.setMaintenance(true);
                                            laporanMaintenance.add(new Maintenance("Maintenance oleh admin", new Date()));
                                            System.out.println("Kendaraan dalam status maintenance.");
                                            break;
                                        }
                                    }
                                }
                                break;
                        }
                    } while (pilihAdmin != 0);
                    admin.logout();
                } else {
                    System.out.println("Login admin gagal!");
                }
            } else if (menu == 2) {
                // tidak diubah
            }
        }
        scanner.close();
    }
}
