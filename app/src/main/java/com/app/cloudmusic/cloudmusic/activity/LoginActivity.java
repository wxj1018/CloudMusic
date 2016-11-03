package com.app.cloudmusic.cloudmusic.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.cloudmusic.cloudmusic.HomeActivity;
import com.app.cloudmusic.cloudmusic.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_newuser, tv_passer;
    private Button btn_login;
    private EditText et_account, et_password;

    //


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {

        tv_newuser = (TextView) findViewById(R.id.tv_regist_newuser);
        tv_passer = (TextView) findViewById(R.id.tv_passer_login);
        tv_newuser.setOnClickListener(this);
        tv_passer.setOnClickListener(this);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
        et_account = (EditText) findViewById(R.id.et_user_account);
        et_password = (EditText) findViewById(R.id.et_user_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_regist_newuser:
                startActivity(new Intent(this, RegistActivity.class));
                break;
            case R.id.tv_passer_login:
                startActivity(new Intent(this, HomeActivity.class));
                break;
            case R.id.btn_login:
                et_account.getText();
                et_password.getText();
                RequestQueue rq = Volley.newRequestQueue(this);
                StringRequest sr = new StringRequest(Request.Method.GET, "http://192.168.191.1:9096/CloudMusic/login.php?action=login&account=" + et_account.getText().toString() + "&password=" + et_password.getText().toString(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        Log.i("test", s);
                        Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        finish();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.e("test", volleyError.toString());
                    }
                });
                rq.add(sr);

                break;
        }
    }


}
