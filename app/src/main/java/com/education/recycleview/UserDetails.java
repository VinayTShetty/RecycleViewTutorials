package com.education.recycleview;

import android.graphics.drawable.Drawable;

public class UserDetails {

    private String userName;
    private Drawable userpic;

    public UserDetails(String userName, Drawable userpic) {
        this.userName = userName;
        this.userpic = userpic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Drawable getUserpic() {
        return userpic;
    }

    public void setUserpic(Drawable userpic) {
        this.userpic = userpic;
    }
}
