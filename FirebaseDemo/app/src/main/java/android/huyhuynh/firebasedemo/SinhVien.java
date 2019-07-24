package android.huyhuynh.firebasedemo;

/**
 * Created by Huy Huynh on 07/24/19.
 */
public class SinhVien {
    private String hoten;
    private int tuoi;
    private String diachi;

    public SinhVien(String hoten, int tuoi, String diachi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.diachi = diachi;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
