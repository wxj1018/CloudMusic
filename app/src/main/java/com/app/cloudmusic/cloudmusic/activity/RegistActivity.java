package com.app.cloudmusic.cloudmusic.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.app.cloudmusic.cloudmusic.R;

public class RegistActivity extends Activity implements View.OnClickListener {

    private EditText et_raccount, et_rpw, et_rrpw;
    private Button btn_regist;

    private static final String action = "register";
    private static final String url = "http://127.0.0.1:9096/CloudMusic/login.php?action=register&account=\"+et_raccount.getText().toString()+\"&password\"+et_rrpw.getText().toString()";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);

        initViews();
    }

    private void initViews() {
        btn_regist = (Button) findViewById(R.id.btn_regist);
        et_raccount = (EditText) findViewById(R.id.et_regist_account);
        et_rpw = (EditText) findViewById(R.id.et_regist_password);
        et_rrpw = (EditText) findViewById(R.id.et_regist_repassword);
        btn_regist.setOnClickListener(this);
        et_raccount.setOnClickListener(this);
        et_rpw.setOnClickListener(this);
        et_rrpw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.i("test", "click");
        switch (v.getId()) {
            case R.id.btn_regist:
                if (et_rpw.getText().toString().equals(et_rrpw.getText().toString()) && !et_raccount.getText().equals("")) {
                    RequestQueue rq = Volley.newRequestQueue(this);
                    StringRequest sr = new StringRequest(Request.Method.GET, "http://192.168.191.1:9096/cloudmusic/login.php?action=register&account=" + et_raccount.getText().toString() + "&password=" + et_rrpw.getText().toString(), new Response.Listener<String>() {
                        @Override
                        public void onResponse(String s) {
                            Log.i("test", s);
                            Toast.makeText(RegistActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                            finish();

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError volleyError) {
                            Log.e("test", volleyError.toString());
                        }
                    }) {
//                        @Override
//                        protected Map<String, String> getParams() throws AuthFailureError {
//                            HashMap<String, String> params = new HashMap<String, String>();
//                            params.put("action", action);
//                            params.put("account",et_raccount.getText().toString());
//                            params.put("password",et_rrpw.getText().toString());
//                            return params;
//                        }
//
//                        @Override
//                        public Priority getPriority() {
//                            Request.Priority mPriority = Priority.HIGH;
//                            return mPriority;
//                        }
                    };
                    sr.setRetryPolicy(new RetryPolicy() {
                        @Override
                        public int getCurrentTimeout() {
                            return 50000;
                        }

                        @Override
                        public int getCurrentRetryCount() {
                            return 50000;
                        }

                        @Override
                        public void retry(VolleyError error) throws VolleyError {

                        }
                    });
                    rq.add(sr);
                } else if (et_raccount.getText().equals("")) {
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "两次密码输入不同", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
