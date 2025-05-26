package Kendaraan;

public class Mobil extends Kendaraan {
    private int jumlahPenumpang;
    private String tipe; 

    public Mobil(String id, String merek, String model, int tahun, double tarifPerHari,
                 int jumlahPenumpang, String tipe) {
        super(id, merek, model, tahun, tarifPerHari);
        this.jumlahPenumpang = jumlahPenumpang;
        this.tipe = tipe;
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public String getTipe() {
        return tipe;
    }

    @Override
    public void printDetail() {
        System.out.println("=== Detail Mobil ===");
        System.out.println("ID: " + getId());
        System.out.println("Merek: " + getMerek());
        System.out.println("Model: " + getModel());
        System.out.println("Tahun: " + getTahun());
        System.out.println("Tarif per Hari: Rp " + getTarifPerHari());
        System.out.println("Jumlah Penumpang: " + jumlahPenumpang);
        System.out.println("Tipe: " + tipe);
        System.out.println("Status: " + (isTersedia() ? "Tersedia" : "Tidak Tersedia"));
    }
}