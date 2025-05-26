package User;

public class User {
    protected String id;
    protected String nama;
    protected String noTelepon;
    protected String alamat;

    public User(String id, String nama, String noTelepon, String alamat) {
        this.id = id;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }

    public void login() {
        System.out.println(nama + " berhasil login.");
    }

    public void logout() {
        System.out.println(nama + " berhasil logout.");
    }

  
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public String getAlamat() { return alamat; }
    public void setAlamat(String alamat) { this.alamat = alamat; }
}
