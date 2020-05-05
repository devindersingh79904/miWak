package com.example.miwoklanguage;

import java.io.StringReader;

public class Word {

    private String mDefaultTranslation ;
    private String mMiwokTranslation;
    private int mImageResourceID;

    public  Word(String defaultTranslation,String miwokTranslation,int imageResourceID){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;

    }

    public  Word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = 0;

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

}
