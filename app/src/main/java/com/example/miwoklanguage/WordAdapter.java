package com.example.miwoklanguage;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

import dalvik.system.InMemoryDexClassLoader;

public class WordAdapter extends ArrayAdapter<Word> {
    int activityBackground;
    public WordAdapter(Activity context , ArrayList<Word> items,int background){
        super(context,0,items);
        activityBackground = background;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }


        Word currentWord = getItem(position);



        View view = listItemView.findViewById(R.id.text_box_liner_layout);
        int color = ContextCompat.getColor(getContext(),activityBackground);
        view.setBackgroundColor(color);


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.mikok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imegeView = (ImageView) listItemView.findViewById(R.id.img_image_view);

        if(currentWord.getmImageResourceID() != 0){
            imegeView.setImageResource(currentWord.getmImageResourceID());
        }
        else{
            imegeView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
