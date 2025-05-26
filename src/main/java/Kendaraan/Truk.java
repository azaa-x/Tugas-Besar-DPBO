package Kendaraan;

public class Truk extends Kendaraan {
    private double kapasitasMuatan;
    private String jenisTruk;

    public Truk(String id, String merek, String model, int tahun, double tarifPerHari,
                double kapasitasMuatan, String jenisTruk) {
        super(id, merek, model, tahun, tarifPerHari);
        this.kapasitasMuatan = kapasitasMuatan;
        this.jenisTruk = jenisTruk;
    }

    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public String getJenisTruk() {
        return jenisTruk;
    }

    @Override
    public void printDetail() {
        System.out.println("=== Detail Truk ===");
        System.out.println("ID: " + getId());
        System.out.println("Merek: " + getMerek());
        System.out.println("Model: " + getModel());
        System.out.println("Tahun: " + getTahun());
        System.out.println("Tarif per Hari: Rp " + getTarifPerHari());
        System.out.println("Kapasitas Muatan: " + kapasitasMuatan + " ton");
        System.out.println("Jenis Truk: " + jenisTruk);
        System.out.println("Status: " + (isTersedia() ? "Tersedia" : "Tidak Tersedia"));
    }
}
