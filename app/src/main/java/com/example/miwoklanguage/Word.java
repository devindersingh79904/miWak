package com.example.miwoklanguage;

import java.io.StringReader;

public class Word {

    private String mDefaultTranslation ;
    private String mMiwokTranslation;
    private int mImageResourceID;
    private int mSoundResourceId;

    public  Word(String defaultTranslation,String miwokTranslation,int imageResourceID,int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;
        mSoundResourceId = soundResourceId;

    }

    public  Word(String defaultTranslation,String miwokTranslation,int soundResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mSoundResourceId = soundResourceId;

    }


    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getmImageResourceID(){ return mImageResourceID;}

    public int getmSoundResourceId(){return mSoundResourceId;}
}
