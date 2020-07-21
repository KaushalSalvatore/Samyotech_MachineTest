package com.samyotech.machinetest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
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
import com.samyotech.machinetest.model.Signupmodel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Signup extends AppCompatActivity {
    EditText et_signupname,et_signupemail,et_signuppassword;
    TextView tv_signup,tv_usersignin;
    ProgressBar progress_circularsign;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        et_signupname = findViewById(R.id.et_signupname);
        et_signupemail = findViewById(R.id.et_signupemail);
        et_signuppassword = findViewById(R.id.et_signuppassword);
        tv_signup = findViewById(R.id.tv_signup);
        tv_usersignin = findViewById(R.id.tv_usersignin);
        progress_circularsign = findViewById(R.id.progress_circularsign);

        String s="Debug-infos:";
        s += "\n OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
        s += "\n OS API Level: " + android.os.Build.VERSION.SDK_INT;
        s += "\n Device: " + android.os.Build.DEVICE;
        s += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";


        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Signup();
            }
        });

        tv_usersignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Signup.this,Login.class);
                startActivity(intent);
            }
        });
    }

    private void Signup()
    {
        //devic id or model for demo testing only


        String devicetype  =  android.os.Build.DEVICE ;
        String devicemodel = Build.MODEL;
        String name = et_signupname.getText().toString().trim();
        String email = et_signupemail.getText().toString().trim();
        String password = et_signuppassword.getText().toString().trim();


        progress_circularsign.setVisibility(View.VISIBLE);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Signupmodel> callback = apiInterface.userSignup(email,name,password,devicetype,devicemodel,devicetype);
        callback.enqueue(new Callback<Signupmodel>() {
            @Override
            public void onResponse(Call<Signupmodel> call, Response<Signupmodel> response) {
                progress_circularsign.setVisibility(View.GONE);
                if(response.code() == 200)
                {
                    Signupmodel data = response.body();
                    int status = data.getStatus();
                    String messaeg = data.getMessage();
                    Log.d("status","---------"+status);
                    if(status == 1)
                    {
                        Toast.makeText(Signup.this, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Signup.this,Login.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                    }
                    if(status == 0)
                    {
                        Toast.makeText(Signup.this, ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
                else
                {
                    progress_circularsign.setVisibility(View.GONE);
                    Toast.makeText(Signup.this, "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();


                }
            }
            @Override
            public void onFailure(Call<Signupmodel> call, Throwable t) {
                progress_circularsign.setVisibility(View.GONE);
                Toast.makeText(Signup.this, "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

}