package com.mrwu.redux.model;

import static android.R.attr.id;


/**
 * ********************************************************************
 *
 * @author sufun
 * @version 1.40.12
 * @createtime 17/8/29
 * @description ********************************************************************
 */
public class UserModel {

    public String uId="";

    public String name="";

    public String email="";

    public String pasd="";


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserModel note1 = (UserModel) o;

        if (!name.equals(note1.name)) return false;
        if (!pasd.equals(note1.pasd )) return false;
        return name != null ? name.equals(note1.name) : note1.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (pasd.equals("") ? 1 : 0);
        return result;
    }
}
