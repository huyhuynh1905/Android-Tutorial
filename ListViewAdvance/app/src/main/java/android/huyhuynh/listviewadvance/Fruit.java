package android.huyhuynh.listviewadvance;

public class Fruit {
    private String name;
    private String info;
    private int picture;

    public Fruit(String name, String info, int picture) {
        this.name = name;
        this.info = info;
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
