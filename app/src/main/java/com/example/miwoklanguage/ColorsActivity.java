package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("red","weṭeṭṭi",R.drawable.color_red));
        numbers.add(new Word("green","chokokki",R.drawable.color_green));
        numbers.add(new Word("brown","ṭakaakki",R.drawable.color_brown));
        numbers.add(new Word("gray","ṭopoppi",R.drawable.color_gray));
        numbers.add(new Word("black","kululli",R.drawable.color_black));
        numbers.add(new Word("white","kelelli",R.drawable.color_white));
        numbers.add(new Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow));
        numbers.add(new Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow));

        WordAdapter items = new WordAdapter(this,numbers,R.color.category_colors);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);
    }
}
