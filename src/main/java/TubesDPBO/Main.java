package TubesDPBO;

import User.Admin;
import User.Pelanggan;
import Kendaraan.Mobil;
import Kendaraan.Truk;
import Sewa.SewaMobil;
import Sewa.SewaTruk;
import Sewa.Sewa;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        while (true) {
            System.out.println("\n=== SELAMAT DATANG ===");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Pelanggan");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            if (menu == 0) {
                System.out.println("Program selesai.");
                break;

            } else if (menu == 1) {
                // Login Admin
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
                        System.out.println("0. Logout");
                        System.out.print("Pilih: ");
                        pilihAdmin = scanner.nextInt();
                        scanner.nextLine();

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
                                int kapasitas = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Jenis: ");
                                String jenis = scanner.nextLine();

                                Mobil mobilBaru = new Mobil(idMobil, merek, model, tahun, harga, kapasitas, jenis);
                                admin.tambahKendaraan(daftarMobil, mobilBaru);
                                System.out.println("Mobil berhasil ditambahkan.");
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
                                double muatan = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Jenis: ");
                                String jenisTruk = scanner.nextLine();

                                Truk trukBaru = new Truk(idTruk, merekTruk, modelTruk, tahunTruk, hargaTruk, muatan, jenisTruk);
                                admin.tambahKendaraan(daftarTruk, trukBaru);
                                System.out.println("Truk berhasil ditambahkan.");
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

                            case 0:
                                admin.logout();
                                break;

                            default:
                                System.out.println("Pilihan tidak valid.");
                        }
                    } while (pilihAdmin != 0);

                } else {
                    System.out.println("Login admin gagal!");
                }

            } else if (menu == 2) {
                // Login Pelanggan
                System.out.println("=== LOGIN PELANGGAN ===");
                System.out.print("Nama: ");
                String nama = scanner.nextLine();
                System.out.print("No Telepon: ");
                String noTelepon = scanner.nextLine();
                System.out.print("Alamat: ");
                String alamat = scanner.nextLine();

                Pelanggan user = new Pelanggan("PLG001", nama, noTelepon, alamat);
                user.login();

                int pilihan;
                do {
                    System.out.println("\n=== MENU PELANGGAN ===");
                    System.out.println("1. Lihat Mobil Tersedia");
                    System.out.println("2. Lihat Truk Tersedia");
                    System.out.println("3. Sewa Mobil");
                    System.out.println("4. Sewa Truk");
                    System.out.println("5. Kembalikan Kendaraan");
                    System.out.println("0. Logout");
                    System.out.print("Pilih menu: ");
                    pilihan = scanner.nextInt();
                    scanner.nextLine();

                    switch (pilihan) {
                        case 1:
                            for (Mobil mobil : daftarMobil) {
                                if (mobil.isTersedia()) {
                                    mobil.printDetail();
                                    System.out.println("-------------------");
                                }
                            }
                            break;

                        case 2:
                            for (Truk truk : daftarTruk) {
                                if (truk.isTersedia()) {
                                    truk.printDetail();
                                    System.out.println("-------------------");
                                }
                            }
                            break;

                        case 3:
                            System.out.println("=== Sewa Mobil ===");
                            for (Mobil mobil : daftarMobil) {
                                if (mobil.isTersedia()) {
                                    mobil.printDetail();
                                    System.out.println("-------------------");
                                }
                            }
                            System.out.print("Masukkan ID Mobil yang ingin disewa: ");
                            String idMobil = scanner.nextLine();
                            Mobil mobilDipilih = null;
                            for (Mobil mobil : daftarMobil) {
                                if (mobil.getId().equalsIgnoreCase(idMobil) && mobil.isTersedia()) {
                                    mobilDipilih = mobil;
                                    break;
                                }
                            }
                            if (mobilDipilih != null) {
                                System.out.print("Lama sewa (hari): ");
                                int lama = scanner.nextInt();
                                scanner.nextLine();
                                SewaMobil sewa = new SewaMobil(mobilDipilih, lama);
                                mobilDipilih.setTersedia(false);
<<<<<<< HEAD
=======
                                user.setSewaAktif(sewa);
>>>>>>> nasywa

                                System.out.println("\n=== Bukti Sewa ===");
                                System.out.println("Nama: " + user.getNama());
                                System.out.println("No Telepon: " + user.getNoTelepon());
                                System.out.println("Alamat: " + user.getAlamat());
                                mobilDipilih.printDetail();
                                System.out.println("Lama Sewa: " + lama + " hari");
                                System.out.println("Total Biaya: Rp " + formatter.format(sewa.hitungTotalBiaya()));
                            } else {
                                System.out.println("Mobil tidak ditemukan atau tidak tersedia.");
                            }
                            break;

                        case 4:
                            System.out.println("=== Sewa Truk ===");
                            for (Truk truk : daftarTruk) {
                                if (truk.isTersedia()) {
                                    truk.printDetail();
                                    System.out.println("-------------------");
                                }
                            }
                            System.out.print("Masukkan ID Truk yang ingin disewa: ");
                            String idTruk = scanner.nextLine();
                            Truk trukDipilih = null;
                            for (Truk truk : daftarTruk) {
                                if (truk.getId().equalsIgnoreCase(idTruk) && truk.isTersedia()) {
                                    trukDipilih = truk;
                                    break;
                                }
                            }
                            if (trukDipilih != null) {
                                System.out.print("Lama sewa (hari): ");
                                int lama = scanner.nextInt();
                                scanner.nextLine();
                                SewaTruk sewa = new SewaTruk(trukDipilih, lama);
                                trukDipilih.setTersedia(false);
<<<<<<< HEAD
                                // user.catatSewa(sewa); // dihapus
=======
                                user.setSewaAktif(sewa);
>>>>>>> nasywa

                                System.out.println("\n=== Bukti Sewa ===");
                                System.out.println("Nama: " + user.getNama());
                                System.out.println("No Telepon: " + user.getNoTelepon());
                                System.out.println("Alamat: " + user.getAlamat());
                                trukDipilih.printDetail();
                                System.out.println("Lama Sewa: " + lama + " hari");
                                System.out.println("Total Biaya: Rp " + formatter.format(sewa.hitungTotalBiaya()));
                            } else {
                                System.out.println("Truk tidak ditemukan atau tidak tersedia.");
                            }
                            break;

                        case 5:
                            Sewa sewaAktif = user.getSewaAktif();
                            if (sewaAktif != null) {
                                sewaAktif.getKendaraan().setTersedia(true);
                                user.hapusSewaAktif();
                                System.out.println("Kendaraan berhasil dikembalikan.");
                            } else {
                                System.out.println("Tidak ada kendaraan yang sedang disewa.");
                            }
                            break;

                        case 0:
                            user.logout();
                            break;

                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                } while (pilihan != 0);

            } else {
                System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}
