package com.example.miwoklanguage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {

    SimpleFragmentPageAdapter (FragmentManager fm){
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0 : return new NumbersFragment();
            case 1 : return new ColorsFragment();
            case 2 : return new FamilyFragment();
            case 3 : return new PhrasesFragment();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0 : return "Numbers";
            case 1 : return "Colors";
            case 2 : return "Family";
            case 3 : return "Phrases";
            default: return "hi";

        }

    }
}
