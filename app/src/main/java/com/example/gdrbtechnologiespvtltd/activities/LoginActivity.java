package com.example.gdrbtechnologiespvtltd.activities;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.gdrbtechnologiespvtltd.R;
import com.example.gdrbtechnologiespvtltd.Retrofit.RetrofitConfiguration;
import com.example.gdrbtechnologiespvtltd.interfaces.LoginAPIService;
import com.example.gdrbtechnologiespvtltd.model.UserLoginRequestPojo;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private TextView text_user_name, text_password;
    private EditText edit_user_name, edit_password;
    private Button button_login;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_main);
        initViews();
    }

    private void initViews() {
        text_user_name = findViewById(R.id.text_user_name);
        edit_user_name = findViewById(R.id.edit_user_name);
        text_password = findViewById(R.id.text_password);
        edit_password = findViewById(R.id.edit_password);
        button_login = findViewById(R.id.button_login);
        progressDialog = new ProgressDialog(LoginActivity.this);

        button_login.setOnClickListener(v -> {
            if (TextUtils.isEmpty(edit_user_name.getText().toString())) {
                text_user_name.setTextColor(Color.RED);
                edit_user_name.setError("This field is required!!!");
            }
            if (TextUtils.isEmpty(edit_password.getText().toString())) {
                text_password.setTextColor(Color.RED);
                edit_password.setError("This field is required!!!");
            }
            if (!TextUtils.isEmpty(edit_user_name.getText().toString()) &&
                    !TextUtils.isEmpty(edit_password.getText().toString())) {
                getLogin(edit_user_name.getText().toString(), edit_password.getText().toString());
            }
        });

    }

    @SuppressLint("HardwareIds")
    private void getLogin(String username, String password) {
        LoginAPIService apiService = RetrofitConfiguration.fetchRetrofit().create(LoginAPIService.class);
        progressDialog.setTitle("Login...");
        progressDialog.setMessage("Loading Please wait !!!");
        progressDialog.show();
        UserLoginRequestPojo loginUserPojo = new UserLoginRequestPojo();
        loginUserPojo.setEmail(username);
        loginUserPojo.setPassword(password);
        loginUserPojo.setDeviceId("exzcde");
        Call<ResponseBody> apiCallback = apiService.getLogin(loginUserPojo);
        try {
            apiCallback.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                    if (response.isSuccessful() && response.code() == 200) {
                        Log.d("LOGIN RESPONSE", ""+response.body().source());
                        String userLoginResponse = response.body().source().toString();
                        if (userLoginResponse.contains("\"status\":\"success\",\"message\":\"Login success\"")) {
                            openMainActivity();
                            progressDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Login Failed/Invalid Credentials!", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        if (response.code() == 401 || response.code() == 403) {
                            Toast.makeText(LoginActivity.this, "Login Failed/Invalid Credentials!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(LoginActivity.this,  "Response Code: " + response.code(), Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "" + t.getMessage(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }

            });
        } catch (Exception e) {
            Log.e(this.getClass().getSimpleName(), "getLoginError: " + e.getMessage());
            progressDialog.dismiss();
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

}