package br.com.caina_bonfiglioli.a4read.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.caina_bonfiglioli.a4read.R;
import br.com.caina_bonfiglioli.a4read.controller.ApiService;
import br.com.caina_bonfiglioli.a4read.model.Result;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private Button btnRegister;
    private EditText edtLogin;
    private EditText editPassword;
    private Intent it;

    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String BASE_URL = "http://192.168.0.109:8080/user/";
    private static Retrofit retrofit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button)findViewById(R.id.btn_login_register);
        btnRegister.setOnClickListener(this);
        edtLogin = (EditText)findViewById(R.id.edit_email);
        editPassword = (EditText)findViewById(R.id.edit_password);

    }

    public void getUserApi(){
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        ApiService api = retrofit.create(ApiService.class);

        Call<Result> call = api.getUserByEmail(edtLogin.getText().toString());

        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                String email = response.body().getEmail();
                String password = response.body().getPassword();

                if (editPassword.getText().toString().equals(password)
                        && edtLogin.getText().toString().equals(email)){

                    it = new Intent(
                            getApplicationContext(),
                            HomeActivity.class);
                }

                System.out.println(response.body().getEmail());
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_login){
            getUserApi();
        }

        if (v.getId() == R.id.btn_login_register){
            it = new Intent(
                    getApplicationContext(),
                    RegisterActivity.class
            );
        }


        startActivity(it);
    }

}
