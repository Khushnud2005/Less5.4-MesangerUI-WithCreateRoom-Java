package uz.exemple.less54_mesangerui_withcreateroom_java.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import uz.exemple.less54_mesangerui_withcreateroom_java.R;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Chat;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Room;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<Chat> items;

    int TYPE_ITEM_ROOM = 1;
    int TYPE_ITEM_MESSAGE = 2;

    public ChatAdapter(Context context, ArrayList<Chat> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Chat chat = items.get(position);
        if (items.get(position).getMessage() == null){
            return TYPE_ITEM_ROOM;
        }
        //Log.d("@@@","Room Size = "+chat.getRooms().size());
        return TYPE_ITEM_MESSAGE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM_ROOM) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_room, parent, false);
            return new RoomViewHolder(context, view);
        }
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat_message, parent, false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Chat chat = items.get(position);

        if (holder instanceof RoomViewHolder) {
            RecyclerView recyclerView = ((RoomViewHolder) holder).recyclerView;
            refreshAdapter(chat.getRooms(), recyclerView);
        }

        if (holder instanceof MessageViewHolder) {
            ImageView iv_profile = ((MessageViewHolder) holder).iv_profile;
            TextView tv_fullname = ((MessageViewHolder) holder).tv_fullname;
            LinearLayout is_online = ((MessageViewHolder) holder).is_online;
            TextView tv_message = ((MessageViewHolder) holder).tv_message;
            TextView tv_time = ((MessageViewHolder) holder).tv_time;

            iv_profile.setImageResource(chat.getMessage().getProfile());
            tv_fullname.setText(chat.getMessage().getFullname());
            tv_message.setText(chat.getMessage().getMsg() + " Java");
            tv_time.setText(chat.getMessage().getTime());

            if (chat.getMessage().getOnline()) {
                is_online.setVisibility(View.VISIBLE);
            } else {
                is_online.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class RoomViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public RoomViewHolder(@NonNull Context context, View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(manager);
        }
    }
    class MessageViewHolder extends RecyclerView.ViewHolder {
        ShapeableImageView iv_profile;
        TextView tv_fullname;
        TextView tv_message;
        TextView tv_time;
        LinearLayout is_online;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
            tv_message = itemView.findViewById(R.id.tv_message);
            tv_time = itemView.findViewById(R.id.tv_time);
            is_online = itemView.findViewById(R.id.is_online);
        }
    }
    void refreshAdapter(ArrayList<Room> rooms ,RecyclerView recyclerView ) {
        RoomAdapter adapter = new  RoomAdapter(context, rooms);
        recyclerView.setAdapter(adapter);
    }

}
