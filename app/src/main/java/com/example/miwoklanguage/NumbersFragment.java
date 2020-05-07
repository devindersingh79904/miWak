package com.example.miwoklanguage;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NumbersFragment extends Fragment {

    private MediaPlayer sound;

    private AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange ==  AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                sound.pause();
                sound.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
            {
                sound.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
            {
                releaseMediaPlayer();
            }
        }
    };

    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };



    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        /** TODO: Insert all the code from the NumberActivity’s onCreate() method after the setContentView method call */

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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


        WordAdapter items = new WordAdapter(getActivity(),numbers,R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setAdapter(items);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {
//                    mAudioManager.registerMediaButtonEventReceiver();

                    sound = MediaPlayer.create(getActivity(),numbers.get(position).getmSoundResourceId());
                    sound.start();

                    sound.setOnCompletionListener(mOnCompletionListener);


                }
            }
        });




        return rootView;
//        return textView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer()
    {
        if(sound != null){

            sound.release();

            sound = null;

            mAudioManager.abandonAudioFocus(mAudioFocusChangeListener);
        }
    }

}
