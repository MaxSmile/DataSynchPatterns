package com.vasilkoff.pattern_a.model;


import android.database.Cursor;

/**
 * Created by maxim.vasilkov@gmail.com on 24/08/15.
 */
public class VideoObject extends ModelObject {

    public String author;
    public String created_at;
    public String video_path;
    public String description;
    public String bitmap_preview;
    public String recorded_app;
    public String duration;


    public static String[] getProjection() {
        return getProjection(VideoObject.class);
    }

    public VideoObject(Cursor cursor) {
        super(cursor);
    }
}
