package com.mrwu.redux.login;

import com.mrwu.redux.model.UserModel;
import com.yheriatovych.reductor.Reducer;
import com.yheriatovych.reductor.annotations.AutoReducer;

import com.yheriatovych.reductor.annotations.AutoReducer.Action;

/**
 * ********************************************************************
 *
 * @author sufun
 * @version 1.40.12
 * @createtime 17/8/29
 * @description ********************************************************************
 */
@AutoReducer
public abstract class LoginReducer implements Reducer<UserModel> {
    @AutoReducer.InitialState
    UserModel initialState(){
        return  new UserModel();
    }
    @Action(value = LoginActions.LOGIN_ACITON,from = LoginActions.class)
    UserModel doLogin(UserModel state,UserModel value){
        return  value;
    }
    @Action(value =LoginActions.EXIT_ACTION,from =LoginActions.class)
    UserModel doExit(UserModel state,UserModel value){
        return value;
    }

    public static LoginReducer create(){
        return new LoginReducerImpl();
    }
}
