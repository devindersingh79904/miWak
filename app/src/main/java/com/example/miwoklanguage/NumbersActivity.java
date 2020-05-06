package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    MediaPlayer sound;

    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> numbers = new ArrayList<Word>();
        numbers.add(new Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        numbers.add(new Word("Two","otikko",R.drawable.number_two,R.raw.number_two));
        numbers.add(new Word("Three","tolookosu",R.drawable.number_three,R.raw.number_three));
        numbers.add(new Word("Four","oyyisa",R.drawable.number_four,R.raw.number_four));
        numbers.add(new Word("Five","massoka",R.drawable.number_five,R.raw.number_five));
        numbers.add(new Word("Six","temmokka",R.drawable.number_six,R.raw.number_six));
        numbers.add(new Word("Seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        numbers.add(new Word("Eight","Kawinta",R.drawable.number_eight,R.raw.number_eight));
        numbers.add(new Word("Nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        numbers.add(new Word("Ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));


        WordAdapter items = new WordAdapter(this,numbers,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                sound = MediaPlayer.create(NumbersActivity.this,numbers.get(position).getmSoundResourceId());
                sound.start();

                sound.setOnCompletionListener(mOnCompletionListener);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(sound != null){

            sound.release();

            sound = null;
        }
    }

}
