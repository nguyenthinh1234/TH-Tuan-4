package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Fragment.BrowserFragment;
import com.example.myapplication.Fragment.ForyouFragment;
import com.example.myapplication.Fragment.RadioFragment;
import com.example.myapplication.Fragment.TitleFragment;
import com.example.myapplication.Fragment.UserFragment;

public class ViewAdapter extends FragmentStatePagerAdapter {
    public ViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new UserFragment();
            case 1:
                return new TitleFragment();
            case 2:
                return new BrowserFragment();
            case 3:
                return new ForyouFragment();
            case 4:
                return new RadioFragment();
            default:
                return new TitleFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
