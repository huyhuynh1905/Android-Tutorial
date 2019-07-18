package android.huyhuynh.saveimagetosqlite;

public class ImageClass {
    private int id;
    private String name;
    private String info;
    private byte[] picture;

    public ImageClass(int id, String name, String info, byte[] picture) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
