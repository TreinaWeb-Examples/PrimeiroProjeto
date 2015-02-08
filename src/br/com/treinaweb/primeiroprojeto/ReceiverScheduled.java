package br.com.treinaweb.primeiroprojeto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReceiverScheduled extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String msg;
		msg = "Mensagem: ReceiverSheduled sendo executado!";
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		toast.show();

	}

}
