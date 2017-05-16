package com.curso.target.aula7;

import android.support.annotation.Nullable;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by sala01 on 16/05/2017.
 */

public class MFireData {

    private static FirebaseDatabase mDataBase;

    public static FirebaseDatabase getDataBase() {
        if (mDataBase == null) {
            mDataBase = FirebaseDatabase.getInstance();
            mDataBase.setPersistenceEnabled(true);
        }
        return mDataBase;
    }
}
