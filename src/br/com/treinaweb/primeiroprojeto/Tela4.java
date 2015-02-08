package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela4 extends Activity {
	
	MyService mService;
	boolean mBind = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela4);
		
		Button btn = (Button) findViewById(R.id.buttonService);
		btn.setOnClickListener(onClickListener);
	}
	
	@Override
	protected void onStart(){
		super.onStart();
		Intent intent = new Intent (this, MyService.class);
		bindService (intent, mServiceConnection, BIND_AUTO_CREATE);
	}
	
	private View.OnClickListener onClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			TextView status = (TextView) findViewById(R.id.textViewResultado);
			
			Intent intentService = new Intent("MyService");
			
			if(mBind){
				String hora = mService.getHora();
				status.setText("Status: data e hora do serviço: " + hora);
			}
			
		}
	};
	
	private ServiceConnection mServiceConnection  = new ServiceConnection() {
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			MyService.LocalBinder mLocalBind = (MyService.LocalBinder) service;
			mService = mLocalBind.getService();
			mBind = true;
			
		}
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			mBind = false;
		}
	};
	
	@Override
	protected void onStop(){
		super.onStop();
		if(mBind){
			unbindService(mServiceConnection);
			mBind = false;
		}
	}
	

}
