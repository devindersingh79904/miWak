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
public class FamilyFragment extends Fragment {

    MediaPlayer sound;

    AudioManager mAudioManager ;


    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {

            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                sound.pause();
                sound.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                sound.start();
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    } ;



    MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.word_list,container,false);



        mAudioManager =(AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

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

        WordAdapter items = new WordAdapter(getActivity(),numbers,R.color.category_family);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setAdapter(items);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result = mAudioManager.requestAudioFocus(mAudioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    sound = MediaPlayer.create(getActivity(),numbers.get(position).getmSoundResourceId());
                    sound.start();
                    sound.setOnCompletionListener(mOnCompletionListener);
                }


            }
        });


        return  rootView;
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
