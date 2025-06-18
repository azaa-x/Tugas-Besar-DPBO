package Kendaraan;

public abstract class Kendaraan {
    private String id;
    private String merek;
    private String model;
    private int tahun;
    private double tarifPerHari;
    private boolean tersedia;
    private boolean maintenance = false;

    public Kendaraan(String id, String merek, String model, 
    		int tahun, double tarifPerHari) {
        this.id = id;
        this.merek = merek;
        this.model = model;
        this.tahun = tahun;
        this.tarifPerHari = tarifPerHari;
        this.tersedia = true; 
    }

    public String getId() {
        return id;
    }

    public String getMerek() {
        return merek;
    }

    public String getModel() {
        return model;
    }

    public int getTahun() {
        return tahun;
    }
    
    public void setTarifPerHari(double tarifPerHari) {
		this.tarifPerHari = tarifPerHari;
	}

	public double getTarifPerHari() {
        return tarifPerHari;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public boolean isMaintenance() {
        return maintenance;
    }

    public void setMaintenance(boolean maintenance) {
        this.maintenance = maintenance;
    }

    public void mulaiMaintenance() {
        this.maintenance = true;
    }

    public void selesaiMaintenance() {
        this.maintenance = false;
    }

    public double hitungBiaya(int sewaHari) {
        return tarifPerHari * sewaHari;
    }

    public abstract void printDetail();
}
