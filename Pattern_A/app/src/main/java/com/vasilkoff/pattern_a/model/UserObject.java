package com.vasilkoff.pattern_a.model;


/**
 * Created by maxim.vasilkov@gmail.com on 24/08/15.
 */
public class UserObject  extends ModelObject {



    public String username;
    public String picture_path;



    public static String[] getProjection() {
        return getProjection(UserObject.class);
    }
}
