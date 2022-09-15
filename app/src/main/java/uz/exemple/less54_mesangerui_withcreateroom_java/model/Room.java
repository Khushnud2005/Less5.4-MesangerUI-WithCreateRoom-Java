package uz.exemple.less54_mesangerui_withcreateroom_java.model;

public class Room {
    Integer profile = null;
    String fullname;

    public Room(Integer profile, String fullname) {
        this.profile = profile;
        this.fullname = fullname;
    }

    public Integer getProfile() {
        return profile;
    }

    public String getFullname() {
        return fullname;
    }
}
