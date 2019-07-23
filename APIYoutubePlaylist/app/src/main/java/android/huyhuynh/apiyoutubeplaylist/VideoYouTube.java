package android.huyhuynh.apiyoutubeplaylist;

/**
 * Created by Huy Huynh on 07/23/19.
 */
public class VideoYouTube {
    private String tittle;
    private String thumnails;
    private String id;

    public VideoYouTube(String tittle, String thumnails, String id) {
        this.tittle = tittle;
        this.thumnails = thumnails;
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getThumnails() {
        return thumnails;
    }

    public void setThumnails(String thumnails) {
        this.thumnails = thumnails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
