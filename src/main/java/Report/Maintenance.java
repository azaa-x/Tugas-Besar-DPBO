package Report;

import java.util.Date;

import Kendaraan.Kendaraan;

public class Maintenance extends Report {
	  private boolean selesai;

	    public Maintenance(String deskripsi, Date tanggalLaporan) {
	        super(deskripsi, tanggalLaporan);
	        this.selesai = false;
	    }

	    public void telahSelesai() {
	        this.selesai = true;
	    }

	    public boolean isSelesai() {
	        return selesai;
	    }

	    public void setSelesai(boolean selesai) {
	        this.selesai = selesai;
	    }
	    
    @Override
    public void tampilkanLaporan() {
        System.out.println("===== Laporan Pemeliharaan =====");
        System.out.println("Deskripsi       : " + getDeskripsi());
        System.out.println("Tanggal         : " + getTanggalLaporan());
        System.out.println("Status          : " + (selesai ? "Selesai" : "Belum selesai"));
    }
}