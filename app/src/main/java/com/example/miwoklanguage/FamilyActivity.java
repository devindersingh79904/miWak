package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("Father","әpә"));
        numbers.add(new Word("Mother","әṭa"));
        numbers.add(new Word("Son","angsi"));
        numbers.add(new Word("Daughter","tune "));
        numbers.add(new Word("older brother","taachi"));
        numbers.add(new Word("younger brother","chalitti"));
        numbers.add(new Word("older sister","teṭe"));
        numbers.add(new Word("younger sister","kolliti"));
        numbers.add(new Word("grandmother","ama"));
        numbers.add(new Word("grandfather","paapa"));

        WordAdapter items = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);
    }
}
