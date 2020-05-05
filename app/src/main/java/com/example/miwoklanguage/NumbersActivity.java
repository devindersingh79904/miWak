package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one","lutti",R.drawable.number_one));
        numbers.add(new Word("Two","otikko",R.drawable.number_two));
        numbers.add(new Word("Three","tolookosu",R.drawable.number_three));
        numbers.add(new Word("Four","oyyisa",R.drawable.number_four));
        numbers.add(new Word("Five","massoka",R.drawable.number_five));
        numbers.add(new Word("Six","temmokka",R.drawable.number_six));
        numbers.add(new Word("Seven","kenekaku",R.drawable.number_seven));
        numbers.add(new Word("Eight","Kawinta",R.drawable.number_eight));
        numbers.add(new Word("Nine","wo'e",R.drawable.number_nine));
        numbers.add(new Word("Ten","na'aacha",R.drawable.number_ten));


        WordAdapter items = new WordAdapter(this,numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);

    }
}
