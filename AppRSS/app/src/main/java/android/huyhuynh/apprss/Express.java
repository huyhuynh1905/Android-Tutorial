package android.huyhuynh.apprss;

import android.graphics.Bitmap;

public class Express {
    private String tieude;
    private Bitmap bmAnh;
    private String content;
    private String link;

    public Express(String tieude, Bitmap bmAnh, String content, String link) {
        this.tieude = tieude;
        this.bmAnh = bmAnh;
        this.content = content;
        this.link = link;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public Bitmap getBmAnh() {
        return bmAnh;
    }

    public void setBmAnh(Bitmap bmAnh) {
        this.bmAnh = bmAnh;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
