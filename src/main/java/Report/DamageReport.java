package Report;

import java.util.Date;

public class DamageReport extends Report {
    private String tingkatKerusakan;
    private String statusPerbaikan;

    public DamageReport(String deskripsi, Date tanggalLaporan, String tingkatKerusakan) {
        super(deskripsi, tanggalLaporan);
        this.tingkatKerusakan = tingkatKerusakan;
        this.statusPerbaikan = "Belum diperbaiki";
    }

    public String getTingkatKerusakan() {
        return tingkatKerusakan;
    }

    public void setTingkatKerusakan(String tingkatKerusakan) {
        this.tingkatKerusakan = tingkatKerusakan;
    }

    public String getStatusPerbaikan() {
        return statusPerbaikan;
    }

    public void setStatusPerbaikan(String statusPerbaikan) {
        this.statusPerbaikan = statusPerbaikan;
    }

    public void ubahStatusPerbaikan(String statusBaru) {
        this.statusPerbaikan = statusBaru;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("===== Laporan Kerusakan =====");
        System.out.println("Deskripsi        : " + getDeskripsi());
        System.out.println("Tanggal          : " + getTanggalLaporan());
        System.out.println("Tingkat Kerusakan: " + tingkatKerusakan);
        System.out.println("Status Perbaikan : " + statusPerbaikan);
        System.out.println();
    }
}