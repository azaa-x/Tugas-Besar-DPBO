package Report;

import java.util.Date;

public abstract class Report {
    private String deskripsi;
    private Date tanggalLaporan;

    public Report(String deskripsi, Date tanggalLaporan) {
        this.setDeskripsi(deskripsi);
        this.setTanggalLaporan(tanggalLaporan);
    }

    public abstract void tampilkanLaporan();

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Date getTanggalLaporan() {
		return tanggalLaporan;
	}

	public void setTanggalLaporan(Date tanggalLaporan) {
		this.tanggalLaporan = tanggalLaporan;
	}
}
