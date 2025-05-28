package Report;

import java.util.Date;

public class Insurance extends Report {
    private String nomorPolis;
    private String penyedia;

    public Insurance(String deskripsi, Date tanggalLaporan, String nomorPolis, String penyedia) {
        super(deskripsi, tanggalLaporan);
        this.nomorPolis = nomorPolis;
        this.penyedia = penyedia;
    }

    public String getNomorPolis() {
        return nomorPolis;
    }

    public String getPenyedia() {
        return penyedia;
    }

    @Override
    public void tampilkanLaporan() {
        System.out.println("===== Laporan Asuransi =====");
        System.out.println("Deskripsi           : " + getDeskripsi());
        System.out.println("Tanggal Laporan     : " + getTanggalLaporan());
        System.out.println("Nomor Polis         : " + nomorPolis);
        System.out.println("Penyedia Asuransi   : " + penyedia);
        System.out.println();
    }
}