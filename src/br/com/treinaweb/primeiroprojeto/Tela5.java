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

public class Tela5 extends Activity {
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela5);
		
		Button btn = (Button) findViewById(R.id.buttonAlarmManeger);
		btn.setOnClickListener(mClickListener);
	}
	
	private View.OnClickListener mClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String msg;
			msg = "Executando AlarmManager";
			
			Toast toast = Toast.makeText(Tela5.this, msg, Toast.LENGTH_LONG);
			toast.show();
			
			Intent intent = new Intent("ReceiverSheduled");
			PendingIntent pIntent = PendingIntent.getBroadcast(Tela5.this, 0, intent, 0);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.SECOND, 5);
			
			Long tempo = calendar.getTimeInMillis();
			AlarmManager alarme = (AlarmManager) getSystemService(ALARM_SERVICE);
			alarme.set(AlarmManager.RTC, tempo, pIntent);
			
		}
	};
}
