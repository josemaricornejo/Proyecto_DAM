package com.example.fooderful.utils;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.fooderful.ui.list.fragment.DespensaFragment;
import com.example.fooderful.ui.list.fragment.FrigoFragment;
import com.example.fooderful.ui.list.fragment.TodosFragment;

public class PagerController extends FragmentPagerAdapter {
    int numOfTabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TodosFragment();
            case 1:
                return new FrigoFragment();
            case 2:
                return new DespensaFragment();
                default:
                    return null;
        }


    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
