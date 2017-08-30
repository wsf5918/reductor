package com.mrwu.redux.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.stetho.common.LogUtil;
import com.mrwu.redux.login.LoginActions;
import com.mrwu.redux.model.UserModel;
import com.yheriatovych.reductor.Actions;
import com.yheriatovych.reductor.Cancelable;
import com.yheriatovych.reductor.Cursors;
import com.yheriatovych.reductor.Store;
import com.yheriatovych.reductor.example.R;
import com.yheriatovych.reductor.example.ReductorApp;
import com.yheriatovych.reductor.example.model.AppState;

/**
 * ********************************************************************
 *
 * @author sufun
 * @version 1.40.12
 * @createtime 17/8/29
 * @description ********************************************************************
 */

public class LoginAct extends Activity implements View.OnClickListener {


    private TextView idResultShow;

    Store<AppState> mstore;

    LoginActions loginAction;

    Cancelable mCancelable;

    TextView id_result_show;


    Button id_btn_showresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        findViewById(R.id.id_btn_login).setOnClickListener(this);
        findViewById(R.id.id_btn_exit).setOnClickListener(this);
        idResultShow = (TextView) findViewById(R.id.id_result_show);

        mstore = ((ReductorApp) getApplicationContext()).store;
        loginAction= Actions.from(LoginActions.class);

        id_result_show=(TextView)findViewById(R.id.id_result_show);

        id_result_show.setText(mstore.getState().login().name);

        mCancelable = Cursors.forEach(mstore, state -> {
            //adapter.setNotes(state.getFilteredNotes());
            //spinner.setSelection(state.filter().ordinal());
            LogUtil.d(" store---->Changed",state.toString());
        });

        id_btn_showresult=(Button)findViewById(R.id.id_btn_showresult);
        id_btn_showresult.setOnClickListener(view -> {
            id_result_show.setText(mstore.getState().login().name);
        });

        // state=>{}
        mstore.subscribe(state -> {
            id_result_show.setText(mstore.getState().login().name+"<-----pass----->"+mstore.getState().login().pasd);


        });
    }

    private EditText getIdUserName(){
        return (EditText) findViewById(R.id.id_user_name);
    }

    private EditText getIdPasswd(){
        return (EditText) findViewById(R.id.id_passwd);
    }
    @Override
    public void onClick(View view) {
        String uname=getIdUserName().getText().toString();
        String passd=getIdPasswd().getText().toString();
        UserModel model=mstore.getState().login();

        switch (view.getId()) {
            case R.id.id_btn_login:
                //TODO implement
                model.name=uname;
                model.pasd=passd;
                mstore.dispatch(loginAction.doLogin(model));
                break;
            case R.id.id_btn_exit:
                //TODO implement
                model.name="";
                model.pasd="";
                mstore.dispatch(loginAction.doExit(model));
                break;
        }
    }

    @Override
    protected void onDestroy() {
        mCancelable.cancel();
        super.onDestroy();
    }
}
