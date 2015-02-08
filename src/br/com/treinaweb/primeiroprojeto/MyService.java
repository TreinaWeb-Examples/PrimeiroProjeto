package br.com.treinaweb.primeiroprojeto;

import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		IBinder mBinder = new LocalBinder();
		return mBinder;
	}
	
	public class LocalBinder extends Binder {
		
		MyService getService(){
			return MyService.this;
		}
	}
	
	public String getHora(){
		Date data = new Date();
		return data.toString();
	}
	
}
