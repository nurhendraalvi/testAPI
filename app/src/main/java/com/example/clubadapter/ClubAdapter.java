package com.example.clubadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ClubAdapter extends RecyclerView.Adapter<ClubAdapter.ViewHolder> {

    private static String BASE_IMAGE_URL = "https:\\/\\/www.thesportsdb.com\\/images\\/media\\/team\\/logo\\/";
    public Context context;
    private ArrayList<TeamsItem> Club = new ArrayList<>();

    public ClubAdapter(Context context) {
        this.context = context;
    }

    public void setClub(ArrayList<TeamsItem> Club) {
        Club.clear();
        Club.addAll(Club);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.club_list, parent, false);
        return new ClubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Glide.with(context).load(BASE_IMAGE_URL + Club.get(position).getStrTeamLogo())
                //.into(holder.ivIcon);
        holder.tvNama.setText(String.valueOf(Club.get(position).getStrTeam()));
    }

    @Override
    public int getItemCount() {
        return Club.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama;
        ImageView ivIcon;
        Button btnFav;
        CardView cvClub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_nama);
            ivIcon = itemView.findViewById(R.id.iv_img);
            btnFav = itemView.findViewById(R.id.btn_fav);
            cvClub = itemView.findViewById(R.id.cv_event);
        }
    }
}
