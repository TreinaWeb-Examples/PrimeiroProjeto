package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.Button;

public class Tela3 extends Activity {
	
	MyBroadcastReceiver2 mMyBroadcastReceiver2;
	@Override
	protected void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela3);
		
		mMyBroadcastReceiver2 = new MyBroadcastReceiver2();
		
		Button btn = (Button) findViewById(R.id.buttonReceiver);
		btn.setOnClickListener(onClickListener);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		LocalBroadcastManager mLocalBroadcast = LocalBroadcastManager.getInstance(this);
		
		mLocalBroadcast.unregisterReceiver(mMyBroadcastReceiver2);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		LocalBroadcastManager mLocalBroadcast = LocalBroadcastManager.getInstance(this);
		
		mLocalBroadcast.registerReceiver(mMyBroadcastReceiver2, new IntentFilter("teste"));
	}
	
	private View.OnClickListener onClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			LocalBroadcastManager mLocalBroadcastManager = LocalBroadcastManager.getInstance(Tela3.this);
			
			mLocalBroadcastManager.sendBroadcast(new Intent("teste"));
		}
	};

}
