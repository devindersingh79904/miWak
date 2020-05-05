package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("Where are you going?","minto wuksus"));
        numbers.add(new Word("What is your name?","tinnә oyaase'nә"));
        numbers.add(new Word("My name is...","oyaaset..."));
        numbers.add(new Word("How are you feeling?","michәksәs?"));
        numbers.add(new Word("I’m feeling good.","kuchi achit"));
        numbers.add(new Word("Are you coming?","әәnәs'aa?"));
        numbers.add(new Word("Yes, I’m coming.","hәә’ әәnәm"));
        numbers.add(new Word("I’m coming.", "әәnәm"));
        numbers.add(new Word("Let’s go.","yoowutis"));
        numbers.add(new Word("Come here.","әnni'nem"));

        WordAdapter items = new WordAdapter(this,numbers,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);
    }
}
