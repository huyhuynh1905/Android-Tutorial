package android.huyhuynh.firebaserecedata;

/**
 * Created by Huy Huynh on 07/25/19.
 */
public class PhuongTien {
    private String ten;
    private int sobanh;

    public PhuongTien(String ten, int sobanh) {
        this.ten = ten;
        this.sobanh = sobanh;
    }

    public PhuongTien() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getSobanh() {
        return sobanh;
    }

    public void setSobanh(int sobanh) {
        this.sobanh = sobanh;
    }

    @Override
    public String toString() {
        return "PhuongTien{" +
                "ten='" + ten + '\'' +
                ", sobanh=" + sobanh +
                '}';
    }
}
