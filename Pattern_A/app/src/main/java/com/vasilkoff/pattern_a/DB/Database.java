package com.vasilkoff.pattern_a.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.vasilkoff.pattern_a.model.AppObject;
import com.vasilkoff.pattern_a.model.UserObject;
import com.vasilkoff.pattern_a.model.VideoObject;

import java.lang.reflect.Field;

/**
 * Created by maxim.vasilkov@gmail.com on 22/08/15.
 */
public class Database extends SQLiteOpenHelper {

    /** Schema version. */
    public static final int DATABASE_VERSION = 1;

    /** Filename for SQLite file. */
    public static final String DATABASE_NAME = "qviky.db";

    private static final String TYPE_TEXT = " TEXT";
    private static final String TYPE_INTEGER = " INTEGER";
    private static final String COMMA_SEP = ",";



    /** SQL statement to create any table. */
    private String getSqlToCreateTable(Class cl) {
        String head = "CREATE TABLE " + cl.getSimpleName() + " (" +
                                    "_id"+TYPE_INTEGER+" PRIMARY KEY,";
        Field[] fields = cl.getFields();
        String body = "";
        for (int i = 0; i < fields.length; i++) {
            body+= fields[i].getName()+TYPE_TEXT;
            if(i+1<fields.length) body+=COMMA_SEP;
        }

        String tail = ");";
        return head + body + tail;
    }


    /** SQL statement to drop any table. */
    private String getSqlToDeleteTable(Class cl) {
        return "DROP TABLE IF EXISTS " + cl.getSimpleName();
    }


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(getSqlToCreateTable(AppObject.class));
        db.execSQL(getSqlToCreateTable(UserObject.class));
        db.execSQL(getSqlToCreateTable(VideoObject.class));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(getSqlToDeleteTable(VideoObject.class));
        db.execSQL(getSqlToDeleteTable(AppObject.class));
        db.execSQL(getSqlToDeleteTable(UserObject.class));

        onCreate(db);
    }
}