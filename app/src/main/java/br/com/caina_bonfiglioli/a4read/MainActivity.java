package br.com.caina_bonfiglioli.a4read;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.caina_bonfiglioli.a4read.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnLogin;
    private Button btnRegister;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button)findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        btnRegister = (Button)findViewById(R.id.btn_login_register);
        btnRegister.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btn_login){
            it = new Intent(
                    getApplicationContext(),
                    AboutActivity.class
            );
        }

//        if (v.getId() == R.id.btn_login_register){
//            it = new Intent(
//                    getApplicationContext(),
//                    RegisterActivity.class
//            );
//        }


        startActivity(it);
    }
}
