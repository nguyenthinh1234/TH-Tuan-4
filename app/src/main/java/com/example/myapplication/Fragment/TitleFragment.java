package com.example.myapplication.Fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ListMusicAdapter;
import com.example.myapplication.R;
import com.example.myapplication.Song;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class TitleFragment extends Fragment {
    private RecyclerView rcvListSong;
    private ListMusicAdapter adapter;
    public static List<Song> mSong;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_title, container, false);
        rcvListSong = view.findViewById(R.id.rcv_ListSong);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        adapter = new ListMusicAdapter(getData(), view.getContext());
        rcvListSong.setLayoutManager(linearLayoutManager);
        rcvListSong.setAdapter(adapter);
        return view;
    }
    private List<Song> getData() {
        mSong = new ArrayList<>();
        mSong.add(new Song(R.raw.buon_hay_mua,R.drawable.jin_tuan_nam, "Buồn... Hay Mưa","Jin Tuấn Nam", R.drawable.jin_tuan_nam));
        mSong.add(new Song(R.raw.phan_duyen_lo_lang,R.drawable.phan_duy_lo_lang_phat_huy_truzg, "Phận duyên lỡ làng","Phát Huy x TRUZG", R.drawable.phan_duy_lo_lang_phat_huy_truzg));
        mSong.add(new Song(R.raw.con_dg_mua,R.drawable.caothaison, "Con đường mưa","Cao Thái Sơn", R.drawable.caothaison));
        mSong.add(new Song(R.raw.if_if,R.drawable.if_tu_vi, "IF","Tử Vi", R.drawable.if_tu_vi));
        mSong.add(new Song(R.raw.doan_duong_vang,R.drawable.khanhphong, "Đoạn đường vắng","Khánh Phong", R.drawable.khanhphong));
        mSong.add(new Song(R.raw.the_night,R.drawable.avici, "The night","Avici", R.drawable.avici));
        mSong.add(new Song(R.raw.sai_gon_dau_long_qua_toan_ky_niem_chung_ta_hua_kim_tuyen_x_hoang_duyen_official_mv,R.drawable.sai_gon_dau_long_qua_hoangduyen, "Sài gòn đau lòng quá","Hứa Kim Tuyền x Hoàng Duyên", R.drawable.sai_gon_dau_long_qua_hoangduyen));

        return mSong;
    }

}
