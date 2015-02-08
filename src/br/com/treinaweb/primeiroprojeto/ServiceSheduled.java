package br.com.treinaweb.primeiroprojeto;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ServiceSheduled extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int onStartCommand(Intent intent, int flags, int startId){
		String msg;
		msg = "Mensagem: ServiceSheduled sendo executado!!";
		Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
		toast.show();
		return 0;
	}

}
