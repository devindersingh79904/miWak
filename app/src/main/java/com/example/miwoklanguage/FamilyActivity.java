package com.example.miwoklanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

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

        numbers.add(new Word("Father","әpә",R.drawable.family_father,R.raw.family_father));
        numbers.add(new Word("Mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        numbers.add(new Word("Son","angsi",R.drawable.family_son,R.raw.family_son));
        numbers.add(new Word("Daughter","tune ",R.drawable.family_daughter,R.raw.family_daughter));
        numbers.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        numbers.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        numbers.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        numbers.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        numbers.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        numbers.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        WordAdapter items = new WordAdapter(this,numbers,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.listView);

        listView.setAdapter(items);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                sound = MediaPlayer.create(FamilyActivity.this,numbers.get(position).getmSoundResourceId());
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
