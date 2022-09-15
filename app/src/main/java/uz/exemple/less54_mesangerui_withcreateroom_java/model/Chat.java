package uz.exemple.less54_mesangerui_withcreateroom_java.model;

import java.util.ArrayList;

public class Chat {
    Message message= null;
    ArrayList<Room> rooms;

    public Chat(Message message){
        this.message = message;
    }

    public Chat(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    public Message getMessage() {
        return message;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
