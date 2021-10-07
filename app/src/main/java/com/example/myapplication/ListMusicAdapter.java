package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.MusicViewHolder>{
    private List<Song> mSong;
    private Context context;
    public static int i;

    public ListMusicAdapter(List<Song> mSong, Context context) {
        this.mSong = mSong;
        this.context = context;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_music_item, parent,false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Song song = mSong.get(position);
        holder.img_Song.setImageResource(song.getImgSinger());
        holder.tvSongName.setText(song.getNameSong());
        holder.tvSingerName.setText(song.getNameSinger());
        holder.img_Song.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayMusicActivity.class);
                Bundle bundle = new Bundle();
                i = position;
                bundle.putSerializable("song", song);
                intent.putExtras(bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
            return mSong.size();
    }

    public class MusicViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView img_Song;
        private TextView tvSongName, tvSingerName;
        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Song = itemView.findViewById(R.id.img_song);
            tvSingerName = itemView.findViewById(R.id.tv_singer);
            tvSongName = itemView.findViewById(R.id.tv_songName);
        }
    }
}
