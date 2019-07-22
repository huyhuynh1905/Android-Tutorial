package android.huyhuynh.customfragment;

/**
 * Created by Huy Huynh on 07/22/19.
 */
public class SinhVien {
    private String name;
    private int age;
    private String diachi;

    public SinhVien(String name, int age, String diachi) {
        this.name = name;
        this.age = age;
        this.diachi = diachi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
