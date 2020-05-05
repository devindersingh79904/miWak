package com.example.miwoklanguage;

import java.io.StringReader;

public class Word {

    private String mDefaultTranslation ;

    private  String mMiwokTranslation;


    public  Word(String defaultTranslation,String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

    }

    public String getDefaultTranslation()
    {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }
}
