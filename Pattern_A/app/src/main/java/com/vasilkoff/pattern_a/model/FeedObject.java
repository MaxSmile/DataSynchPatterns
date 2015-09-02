package com.vasilkoff.pattern_a.model;


/**
 * Created by maxim.vasilkov@gmail.com on 29/08/15.
 */
public class FeedObject extends ModelObject {

    // User fields
    public String username;
    public String picture_path;

    // Apps fields
    public String app_name;
    public String app_icon;
    public String app_bundle_id;
    public String app_url;
    public String app_developer;

    //Video fileds
    public String author;
    public String created_at;
    public String video_path;
    public String description;
    public String bitmap_preview;
    public String recorded_app;
    public String duration;


    public static String[] getProjection() {
        return getProjection(FeedObject.class);
    }

}
