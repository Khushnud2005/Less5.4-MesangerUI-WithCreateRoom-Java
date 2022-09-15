package uz.exemple.less54_mesangerui_withcreateroom_java.model;

public class Message {
    int profile;
    String fullname;
    String msg;
    String time;
    Boolean isOnline = false;

    public Message(int profile, String fullname, String msg, String time, Boolean isOnline) {
        this.profile = profile;
        this.fullname = fullname;
        this.msg = msg;
        this.time = time;
        this.isOnline = isOnline;
    }

    public int getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMsg() {
        return msg;
    }

    public String getTime() {
        return time;
    }

    public Boolean getOnline() {
        return isOnline;
    }
}
