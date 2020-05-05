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

        numbers.add(new Word("Father","әpә",R.drawable.family_father));
        numbers.add(new Word("Mother","әṭa",R.drawable.family_mother));
        numbers.add(new Word("Son","angsi",R.drawable.family_son));
        numbers.add(new Word("Daughter","tune ",R.drawable.family_daughter));
        numbers.add(new Word("older brother","taachi",R.drawable.family_older_brother));
        numbers.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother));
        numbers.add(new Word("older sister","teṭe",R.drawable.family_older_sister));
        numbers.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister));
        numbers.add(new Word("grandmother","ama",R.drawable.family_grandmother));
        numbers.add(new Word("grandfather","paapa",R.drawable.family_grandfather));

        WordAdapter items = new WordAdapter(this,numbers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);
    }
}
