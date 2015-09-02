package com.vasilkoff.pattern_a.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.vasilkoff.pattern_a.model.VideoObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maxim.vasilkov@gmail.com on 02/09/15.
 */
public class QueryHelper {

    public static List<VideoObject> getVideos(Context context, int offset) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        String sql = "SELECT * FROM "+VideoObject.class.getSimpleName()+" LIMIT "+offset+",3";
        Cursor c = db.rawQuery(sql, null);
        List<VideoObject> result = new ArrayList<>(3);

        if (c != null) {
            while(c.moveToNext()) {
                result.add(new VideoObject(c));
            }
            c.close();
        }
        return result;
    }
}
