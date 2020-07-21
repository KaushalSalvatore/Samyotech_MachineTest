package com.samyotech.machinetest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.samyotech.machinetest.R;
import com.samyotech.machinetest.apicalling.APIClient;
import com.samyotech.machinetest.apicalling.APIInterface;
import com.samyotech.machinetest.model.Loginmodel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    TextView tv_signup,tv_login;
    EditText et_loginemail,et_loginpassword;
    ProgressBar progress_circular;
    String devicetype;
    String devicemodel;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_signup = findViewById(R.id.tv_signup);
        tv_login = findViewById(R.id.tv_login);
        et_loginemail = findViewById(R.id.et_loginemail);
        et_loginpassword = findViewById(R.id.et_loginpassword);
        progress_circular = findViewById(R.id.progress_circular);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new
                    StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Log.d("andriod 9","--------");

        }

        String s="Debug-infos:";
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        s += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        s += "\n Device: " + android.os.Build.DEVICE;
        s += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";

        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });

    }

    private void login()
    {
        //devic id or model for demo testing only

        devicetype  =  android.os.Build.DEVICE ;
        devicemodel = Build.MODEL;

         email = et_loginemail.getText().toString().trim();
         password = et_loginpassword.getText().toString().trim();
        progress_circular.setVisibility(View.VISIBLE);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Loginmodel> callback = apiInterface.userLogin(email,password,devicetype,devicemodel);
        callback.enqueue(new Callback<Loginmodel>() {
            @Override
            public void onResponse(Call<Loginmodel> call, Response<Loginmodel> response) {
                progress_circular.setVisibility(View.GONE);
                if(response.code() == 200)
                {
                    Loginmodel data = response.body();
                    int status = data.getStatus();
                    Log.d("status","---------"+status);
                    if(status == 1)
                    {
                        Toast.makeText(Login.this, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                        Loginmodel.Data token = data.getData();
                        String user_id = token.getUserId();
                        Intent intent = new Intent(Login.this,Home.class);
                        intent.putExtra("userId",user_id);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    if(status == 0)
                    {
                        Toast.makeText(Login.this, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
                else
                    {
                        progress_circular.setVisibility(View.GONE);
                        Toast.makeText(Login.this, "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();


                    }
            }

            @Override
            public void onFailure(Call<Loginmodel> call, Throwable t) {
                progress_circular.setVisibility(View.GONE);
                Toast.makeText(Login.this, "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

}