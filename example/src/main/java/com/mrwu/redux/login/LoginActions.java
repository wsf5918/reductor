package com.mrwu.redux.login;

import com.mrwu.redux.model.UserModel;
import com.yheriatovych.reductor.Action;
import com.yheriatovych.reductor.annotations.ActionCreator;

/**
 * ********************************************************************
 *
 * @author sufun
 * @version 1.40.12
 * @createtime 17/8/29
 * @description ********************************************************************
 */
@ActionCreator
public interface LoginActions {

    String LOGIN_ACITON="LOGIN_ACITON";
    String EXIT_ACTION="EXIT_ACTION";
    @ActionCreator.Action(LoginActions.LOGIN_ACITON)
    Action doLogin(UserModel data);  //String uId,String pasd

    @ActionCreator.Action((LoginActions.EXIT_ACTION))
    Action doExit(UserModel data);


}
