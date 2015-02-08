package br.com.treinaweb.primeiroprojeto;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Tela6 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);

        Button btnIniciar = (Button) findViewById(R.id.buttonIniciar);
        Button btnRepetir = (Button) findViewById(R.id.buttonRepetir);
        Button btnParar = (Button) findViewById(R.id.buttonParar);

        btnIniciar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String msg;
                msg = "Executando o AlarmManager";
                Toast toast = Toast.makeText(view.getContext(), msg, Toast.LENGTH_LONG);
                toast.show();

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 5);
                Long tempo = calendar.getTimeInMillis();

                Intent intent = new Intent("ServiceSheduled");
                PendingIntent pIntent = PendingIntent.getService(getBaseContext(), 2, intent, 0);
                AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarme.set(AlarmManager.RTC, tempo, pIntent);
            }
        });

        btnRepetir.setOnClickListener(new View.OnClickListener() {

            @Override
              public void onClick(View v) {
                // TODO Auto-generated method stub
                String msg;
                msg = "Repetindo o AlarmManager";
                Toast toast = Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG);
                toast.show();

                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.SECOND, 5);
                Long tempo = calendar.getTimeInMillis();

                Intent intent = new Intent("ServiceSheduled");
                PendingIntent pIntent = PendingIntent.getService(getBaseContext(), 2, intent, 0);
                AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarme.setRepeating(AlarmManager.RTC, tempo, 5000, pIntent);
              }
        });

        btnParar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String msg;
                msg = "Parando o AlarmManager";
                Toast toast = Toast.makeText(v.getContext(), msg, Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent("ServiceSheduled");
                PendingIntent pIntent = PendingIntent.getService(getBaseContext(), 2, intent, 0);
                AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarme.cancel(pIntent);
            }
        });
    }

}