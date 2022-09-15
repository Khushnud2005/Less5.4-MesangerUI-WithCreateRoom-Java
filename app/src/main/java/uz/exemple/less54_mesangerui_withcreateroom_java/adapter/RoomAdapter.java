package uz.exemple.less54_mesangerui_withcreateroom_java.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import uz.exemple.less54_mesangerui_withcreateroom_java.R;
import uz.exemple.less54_mesangerui_withcreateroom_java.model.Room;

public class RoomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<Room> items;

    private int TYPE_ROOM_CREATE = 0;
    private int TYPE_ITEM_PROFILE = 1;

    public RoomAdapter(Context context, ArrayList<Room> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Room item = items.get(position);
        if (item.getProfile() == null)
            return TYPE_ROOM_CREATE;
        return TYPE_ITEM_PROFILE;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_ROOM_CREATE) {
            View view =
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.create_room_view, parent, false);
            return new CreateRoomViewHolder(view);
        }
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room_view, parent, false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Room room = items.get(position);

        if (holder instanceof RoomViewHolder) {
            ImageView iv_profile = ((RoomViewHolder) holder).iv_profile;
            TextView tv_fullname = ((RoomViewHolder) holder).tv_fullname;

            iv_profile.setImageResource(room.getProfile());
            tv_fullname.setText(room.getFullname());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    class RoomViewHolder extends RecyclerView.ViewHolder{

        ShapeableImageView iv_profile;
        TextView tv_fullname;
        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_profile = itemView.findViewById(R.id.iv_profile);
            tv_fullname = itemView.findViewById(R.id.tv_fullname);
        }
    }
    class CreateRoomViewHolder extends RecyclerView.ViewHolder {

        public CreateRoomViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
