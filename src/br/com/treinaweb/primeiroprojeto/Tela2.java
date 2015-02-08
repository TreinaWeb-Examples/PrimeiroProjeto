package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela2);
		
		Intent intent = getIntent();
		Bundle args = intent.getExtras();
		
		String nome = args.getString("nome");
		
		TextView tvTitulo2 = (TextView)findViewById(R.id.textViewTitulo);
		TextView tvResultado = (TextView) findViewById(R.id.textViewResultado);
		tvTitulo2.setText(nome + " digite o curso abaixo:");
		tvResultado.setText("Resultado: Dados da primeira tela: " + nome);
		
		Button btnVoltar = (Button) findViewById(R.id.buttonVoltar);
		btnVoltar.setOnClickListener(mOnClickListener);
		
	}
	
	private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText txtCurso = (EditText) findViewById(R.id.editTextCurso);
			Intent data = new Intent();
			Bundle parans = new Bundle();
			try{
				String curso = txtCurso.getText().toString();
				parans.putString("curso", curso);
				
				data.putExtras(parans);
				
				setResult(RESULT_OK, data);
			}catch(Exception e){
				setResult(RESULT_CANCELED);
			}
			finish();
		}
	};
}
