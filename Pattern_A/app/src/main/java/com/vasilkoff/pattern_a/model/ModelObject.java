package com.vasilkoff.pattern_a.model;

import android.database.Cursor;

import java.lang.reflect.Field;

/**
 * Created by maxim.vasilkov@gmail.com on 24/08/15.
 */
public class ModelObject {

    public String id;


    public ModelObject(Cursor record) {
        Field[] fields = this.getClass().getFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            int col = record.getColumnIndex(f.getName());
            if(col>=0) {
                try {
                    f.set(this,record.getString(col));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static String[] getProjection(Class cl) {
        Field[] fields = cl.getFields();
        String[] strings = new String[fields.length+1];
        strings[0] = "_id";
        for (int i = 0; i < fields.length; i++) {
            strings[i + 1] = fields[i].getName();
        }
        return strings;
    }
}
