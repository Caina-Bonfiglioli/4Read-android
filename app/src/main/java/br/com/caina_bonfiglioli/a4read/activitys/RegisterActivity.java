package br.com.caina_bonfiglioli.a4read.activitys;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.caina_bonfiglioli.a4read.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnRegister;
    private Button btnTerms;
    private Intent it;
    private EditText edtNameRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button)findViewById(R.id.btn_register_register);
        btnRegister.setOnClickListener(this);
        btnTerms = (Button)findViewById(R.id.btn_Terms_Register);
        btnTerms.setOnClickListener(this);
        edtNameRegister = (EditText)findViewById(R.id.edit_name);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_register_register){
            criarNotificacao(
                    "Bem Vindo",
                    "Faça um tour pela nosso aplicativo.\n" +
                            "Aqui você encontra todo tipo de literatura. \n"
            );

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

    private void criarNotificacao(String titulo, String texto){

        final int NOTIFICATION_ID = 123;
        final String CHANNEL_ID = "Notificação";
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "canal", importance);
            channel.setDescription("Canal de Notificação");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            channel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            channel.setShowBadge(true);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(titulo)
                .setStyle(
                        new NotificationCompat.BigTextStyle().bigText(texto)
                )
                .setContentText(texto);
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
