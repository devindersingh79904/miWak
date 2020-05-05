package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.service.autofill.LuhnChecksumValidator;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one","lutti"));
        numbers.add(new Word("Two","otikko"));
        numbers.add(new Word("Three","tolookosu"));
        numbers.add(new Word("Four","oyyisa"));
        numbers.add(new Word("Five","massoka"));
        numbers.add(new Word("Six","temmokka"));
        numbers.add(new Word("Seven","kenekaku"));
        numbers.add(new Word("Eight","Kawinta"));
        numbers.add(new Word("Nine","wo'e"));
        numbers.add(new Word("Ten","na'aacha"));

        WordAdapter items = new WordAdapter(this,numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);

    }
}
