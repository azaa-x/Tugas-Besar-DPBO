package TubesDPBO;

import User.Admin;
import User.Pelanggan;
import Kendaraan.Mobil;
import Kendaraan.Truk;
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

            if (menu == 0) {
            	System.out.println("Program selesai.");
            	break;

            } if (menu == 1) {
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
                        System.out.println("7. Lihat Laporan Maintenance");
                        System.out.println("0. Logout");
                        System.out.print("Pilih: ");
                        pilihAdmin = scanner.nextInt(); scanner.nextLine();

                        switch (pilihAdmin) {
                            case 1:
                                System.out.print("ID Mobil: ");
                                String idMobil = scanner.nextLine();
                                System.out.print("Merek: ");
                                String merek = scanner.nextLine();
                                System.out.print("Model: ");
                                String model = scanner.nextLine();
                                System.out.print("Tahun: ");
                                int tahun = scanner.nextInt();
                                System.out.print("Harga Sewa: ");
                                double harga = scanner.nextDouble();
                                System.out.print("Kapasitas Penumpang: ");
                                int kapasitas = scanner.nextInt(); scanner.nextLine();
                                System.out.print("Jenis: ");
                                String jenis = scanner.nextLine();

                                Mobil mobilBaru = new Mobil(idMobil, merek, model, tahun, harga, kapasitas, jenis);
                                admin.tambahKendaraan(daftarMobil, mobilBaru);
                                break;
                            case 2:
                                System.out.print("ID Truk: ");
                                String idTruk = scanner.nextLine();
                                System.out.print("Merek: ");
                                String merekTruk = scanner.nextLine();
                                System.out.print("Model: ");
                                String modelTruk = scanner.nextLine();
                                System.out.print("Tahun: ");
                                int tahunTruk = scanner.nextInt();
                                System.out.print("Harga Sewa: ");
                                double hargaTruk = scanner.nextDouble();
                                System.out.print("Kapasitas Muatan (ton): ");
                                double muatan = scanner.nextDouble(); scanner.nextLine();
                                System.out.print("Jenis: ");
                                String jenisTruk = scanner.nextLine();

                                Truk trukBaru = new Truk(idTruk, merekTruk, modelTruk, tahunTruk, hargaTruk, muatan, jenisTruk);
                                admin.tambahKendaraan(daftarTruk, trukBaru);
                                break;
                            case 3:
                                System.out.print("ID Mobil yang ingin dihapus: ");
                                String hapusMobil = scanner.nextLine();
                                admin.hapusKendaraan(daftarMobil, hapusMobil);
                                break;
                            case 4:
                                System.out.print("ID Truk yang ingin dihapus: ");
                                String hapusTruk = scanner.nextLine();
                                admin.hapusKendaraan(daftarTruk, hapusTruk);
                                break;
                            case 5:
                                laporanAsuransi.forEach(Insurance::tampilkanLaporan);
                                break;
                            case 6:
                                System.out.print("Nomor polis: ");
                                String polis = scanner.nextLine();
                                System.out.print("Penyedia asuransi: ");
                                String penyedia = scanner.nextLine();
                                Insurance i = new Insurance("Laporan dari admin", new Date(), polis, penyedia);
                                laporanAsuransi.add(i);
                                System.out.println("Laporan asuransi diteruskan.");
                                break;
                            case 7:
                                laporanMaintenance.forEach(Maintenance::tampilkanLaporan);
                                break;
                        }
                    } while (pilihAdmin != 0);
                    admin.logout();
                } else {
                    System.out.println("Login admin gagal!");
                }
            } else if (menu == 2) {
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("No Telepon: ");
                String noTelp = scanner.nextLine();
                System.out.print("Alamat: ");
                String alamat = scanner.nextLine();

                Pelanggan user = new Pelanggan("PLG001", nama, noTelp, alamat);
                user.login();

                int pilihan;
                do {
                    System.out.println("\n=== MENU PELANGGAN ===");
                    System.out.println("1. Lihat Mobil");
                    System.out.println("2. Lihat Truk");
                    System.out.println("3. Sewa Mobil");
                    System.out.println("4. Sewa Truk");
                    System.out.println("5. Kembalikan Kendaraan");
                    System.out.println("0. Logout");
                    System.out.print("Pilih: ");
                    pilihan = scanner.nextInt(); scanner.nextLine();

                    switch (pilihan) {
                        case 1:
                            daftarMobil.stream().filter(m -> m.isTersedia() && !m.isMaintenance()).forEach(Mobil::printDetail);
                            break;
                        case 2:
                            daftarTruk.stream().filter(t -> t.isTersedia() && !t.isMaintenance()).forEach(Truk::printDetail);
                            break;
                        case 3:
                            System.out.print("ID Mobil: ");
                            String idMobilSewa = scanner.nextLine();
                            for (Mobil m : daftarMobil) {
                                if (m.getId().equalsIgnoreCase(idMobilSewa) && m.isTersedia() && !m.isMaintenance()) {
                                    System.out.print("Lama sewa (hari): ");
                                    int lama = scanner.nextInt(); scanner.nextLine();
                                    SewaMobil sewa = new SewaMobil(m, lama);
                                    m.setTersedia(false);
                                    user.setSewaAktif(sewa);
                                    System.out.println("Berhasil disewa.");
                                    System.out.println("Lama Sewa: " + lama + " hari");
                                    System.out.println("Total Biaya: Rp " + formatter.format(sewa.hitungTotalBiaya()));
                                    break;
                                }
                            }
                            break;
                        case 4:
                            System.out.print("ID Truk: ");
                            String idTrukSewa = scanner.nextLine();
                            for (Truk t : daftarTruk) {
                                if (t.getId().equalsIgnoreCase(idTrukSewa) && t.isTersedia() && !t.isMaintenance()) {
                                    System.out.print("Lama sewa (hari): ");
                                    int lama = scanner.nextInt(); scanner.nextLine();
                                    SewaTruk sewa = new SewaTruk(t, lama);
                                    t.setTersedia(false);
                                    user.setSewaAktif(sewa);
                                    System.out.println("Berhasil disewa.");
                                    break;
                                }
                            }
                            break;
                        case 5:
                            Sewa sewa = user.getSewaAktif();
                            if (sewa != null) {
                                sewa.getKendaraan().setTersedia(true);

                                System.out.print("Apakah kendaraan perlu maintenance? (ya/tidak): ");
                                String perluMaintenance = scanner.nextLine();
                                if (perluMaintenance.equalsIgnoreCase("ya")) {
                                    sewa.getKendaraan().setMaintenance(true);
                                    Maintenance m = new Maintenance("Perlu maintenance setelah pengembalian", new Date());
                                    laporanMaintenance.add(m);
                                    m.tampilkanLaporan();
                                }

                                System.out.print("Apakah ada kerusakan? (ya/tidak): ");
                                String jawab = scanner.nextLine();
                                if (jawab.equalsIgnoreCase("ya")) {
                                    System.out.print("Tingkat kerusakan: ");
                                    String tingkat = scanner.nextLine();
                                    DamageReport dr = new DamageReport("Kerusakan oleh pelanggan " + user.getNama(), new Date(), tingkat);
                                    laporanKerusakan.add(dr);
                                    dr.tampilkanLaporan();
                                }
                                user.hapusSewaAktif();
                                System.out.println("Pengembalian berhasil.");
                            } else {
                                System.out.println("Tidak ada kendaraan yang sedang disewa.");
                            }
                            break;
                    }
                } while (pilihan != 0);
                user.logout();
            }
        }
        scanner.close();
    }
}