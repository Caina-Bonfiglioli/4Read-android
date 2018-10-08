package br.com.caina_bonfiglioli.a4read;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private Button btnTerms;
    private Intent it;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button)findViewById(R.id.btn_register_register);
        btnRegister.setOnClickListener(this);
        btnTerms = (Button)findViewById(R.id.btn_Terms_Register);
        btnTerms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register_register){
             it = new Intent(
                    getApplicationContext(),
                    HomeActivity.class
            );
        }

        if (v.getId() == R.id.btn_Terms_Register){
            it = new Intent(
                    getApplicationContext(),
                    TermsActivity.class
            );
        }

        startActivity(it);
    }
}
