package android.huyhuynh.retrofitexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserJetty {

    @SerializedName("Id")
    @Expose
    private String id;
    @SerializedName("Email")
    @Expose
    private String email;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("Phone")
    @Expose
    private String phone;
    @SerializedName("Pass")
    @Expose
    private String pass;

    public String getId() {
    return id;
    }

    public void setId(String id) {
    this.id = id;
    }

    public String getEmail() {
    return email;
    }

    public void setEmail(String email) {
    this.email = email;
    }

    public String getName() {
    return name;
    }

    public void setName(String name) {
    this.name = name;
    }

    public String getPhone() {
    return phone;
    }

    public void setPhone(String phone) {
    this.phone = phone;
    }

    public String getPass() {
    return pass;
    }

    public void setPass(String pass) {
    this.pass = pass;
    }

}