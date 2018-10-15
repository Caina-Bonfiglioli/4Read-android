package br.com.caina_bonfiglioli.a4read;

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

        // 01. Definir as propriedades da Notificação
        final int NOTIFICATION_ID = 123;
        final String CHANNEL_ID = "Notificação";

        // 02. Instanciar o gerenciador de notificações
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);


        // 03. Definir um Canal de Notificação para API >= 28
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

        // 04. Especificar o ícone, o título e a mensagem da notificação
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle(titulo)
                .setStyle(
                        new NotificationCompat.BigTextStyle().bigText(texto)
                )
                .setContentText(texto);

        // 05. Definir qual Atividade será chamada quando o usuário clicar na notificação
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(TelaPrincipal.class);
//        stackBuilder.addNextIntent(new Intent(this, TelaPrincipal.class));
//        PendingIntent it = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
//        builder.setContentIntent(it);

        // 06. Exibir a notificação
        notificationManager.notify(NOTIFICATION_ID, builder.build());
    }
}
