package uz.exemple.less54_mesangerui_withcreateroom_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import uz.exemple.less54_mesangerui_withcreateroom_java.adapter.ChatAdapter;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Chat;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Message;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Room;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    void initViews(){
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        refreshAdapter(getAllChats());
    }

    ArrayList<Chat> getAllChats()  {
        ArrayList<Chat> chats = new  ArrayList<Chat>();

        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(new Room(null, "Create room"));
        rooms.add(new Room(R.drawable.photo1, "Xushnud Boymurotov"));
        rooms.add(new Room(R.drawable.photo2, "Barnoxon Kabirova"));
        rooms.add(new Room(R.drawable.photo3, "Kamolaxon Nematjonova"));
        rooms.add(new Room(R.drawable.photo4, "Abdullatif Nematjonov"));
        rooms.add(new Room(R.drawable.photo1, "Xushnud Boymurotov"));
        rooms.add(new Room(R.drawable.photo2, "Barnoxon Kabirova"));
        rooms.add(new Room(R.drawable.photo3, "Kamolaxon Nematjonova"));
        rooms.add(new Room(R.drawable.photo4, "Abdullatif Nematjonov"));

        // Rooms
        chats.add( new Chat(rooms));
        String text1 = "Xushnud sent voice message";
        String text2 = "Opamga aytaman";
        String text3 = "Ayam o'zingga buyurdilar";
        String text4 = "Opajon siz chiqib keling";
        // Messages

        chats.add(new Chat(new Message(R.drawable.photo4, "Abdullatif","Ayam o'zingga buyurdilar","18:12", false)));
        chats.add(new Chat(new Message(R.drawable.photo3, "Kamolaxon", "Opajon siz chiqib keling","18:07",true)));
        chats.add(new Chat(new Message(R.drawable.photo2, "Barnoxon","Opamga aytaman","17:45", false)));
        chats.add(new Chat(new Message(R.drawable.photo1, "Xushnud", "Xushnud sent voice message","Tue",false)));
        chats.add(new Chat(new Message(R.drawable.photo4, "Abdullatif","Ayam o'zingga buyurdilar","18:12", true)));
        chats.add(new Chat(new Message(R.drawable.photo3, "Kamolaxon","Opajon siz chiqib keling","18:07", false)));
        chats.add(new Chat(new Message(R.drawable.photo2, "Barnoxon","Opamga aytaman","17:45", true)));
        chats.add(new Chat(new Message(R.drawable.photo1, "Xushnud","Xushnud sent voice message","Tue", true)));
        chats.add(new Chat(new Message(R.drawable.photo4, "Abdullatif","Ayam o'zingga buyurdilar","18:12", false)));
        chats.add(new Chat(new Message(R.drawable.photo3, "Kamolaxon","Opajon siz chiqib keling","18:07", true)));
        chats.add(new Chat(new Message(R.drawable.photo2, "Barnoxon","Opamga aytaman","17:45", false)));
        chats.add(new Chat(new Message(R.drawable.photo1, "Xushnud","Xushnud sent voice message","Tue", true)));

        return chats;
    }
    void refreshAdapter(ArrayList<Chat> chats) {
        ChatAdapter adapter = new ChatAdapter(this, chats);
        recyclerView.setAdapter(adapter);
    }
}