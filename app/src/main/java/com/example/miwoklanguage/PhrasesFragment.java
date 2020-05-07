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
public class PhrasesFragment extends Fragment {

    MediaPlayer sound;

    AudioManager mAudioManager;

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                sound.pause();
                sound.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                sound.start();
            }
            else if ( focusChange == AudioManager.AUDIOFOCUS_GAIN){
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


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list,container,false);


                mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("Where are you going?","minto wuksus",R.raw.phrase_where_are_you_going));
        numbers.add(new Word("What is your name?","tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        numbers.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        numbers.add(new Word("How are you feeling?","michәksәs?",R.raw.phrase_how_are_you_feeling));
        numbers.add(new Word("I’m feeling good.","kuchi achit",R.raw.phrase_im_feeling_good));
        numbers.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        numbers.add(new Word("Yes, I’m coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        numbers.add(new Word("I’m coming.", "әәnәm",R.raw.phrase_im_coming));
        numbers.add(new Word("Let’s go.","yoowutis",R.raw.phrase_lets_go));
        numbers.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        WordAdapter items = new WordAdapter(getActivity(),numbers,R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setAdapter(items);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    sound = MediaPlayer.create(getActivity(),numbers.get(position).getmSoundResourceId());
                    sound.start();
                    sound.setOnCompletionListener(mOnCompletionListener);
                }

            }
        });




        return rootView;
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

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }


}
