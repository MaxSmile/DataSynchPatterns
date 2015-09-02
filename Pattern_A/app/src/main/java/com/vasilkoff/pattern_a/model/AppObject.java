package com.vasilkoff.pattern_a.model;


/**
 * Created by maxim.vasilkov@gmail.com on 24/08/15.
 */
public class AppObject  extends ModelObject {

    public String app_name;
    public String app_icon;
    public String app_bundle_id;
    public String app_url;
    public String app_developer;
    public String created_at;



    public static String[] getProjection() {
        return getProjection(AppObject.class);
    }
}
