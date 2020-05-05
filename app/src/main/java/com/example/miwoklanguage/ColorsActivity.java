package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("red","weṭeṭṭi"));
        numbers.add(new Word("green","chokokki"));
        numbers.add(new Word("brown","ṭakaakki"));
        numbers.add(new Word("gray","ṭopoppi"));
        numbers.add(new Word("black","kululli"));
        numbers.add(new Word("white","kelelli"));
        numbers.add(new Word("dusty yellow","ṭopiisә"));
        numbers.add(new Word("mustard yellow","chiwiiṭә"));

        WordAdapter items = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);
    }
}
