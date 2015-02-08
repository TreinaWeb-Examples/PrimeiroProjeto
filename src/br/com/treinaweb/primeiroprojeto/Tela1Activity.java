package br.com.treinaweb.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tela1Activity extends Activity {
	
	private static final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        
        Button btnOk = (Button) findViewById(R.id.buttonOk);
        btnOk.setOnClickListener(mOnClickListener);
    }
    
    private OnClickListener mOnClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View view) {
			// TODO Auto-generated method stub
			Intent intent = new Intent(Tela1Activity.this, Tela2.class);
			EditText txtNome = (EditText) findViewById(R.id.editTextNome);


	        String nome = "";
	        nome = txtNome.getText().toString();
	        Bundle parans = new Bundle();
	        parans.putString("nome", nome);
	        intent.putExtras(parans);

	        startActivity(intent);
	        
	        startActivityForResult(intent, REQUEST_CODE);
			
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		switch(requestCode){
		case REQUEST_CODE:
			TextView tvResposta = (TextView) findViewById(R.id.textViewResposta);
			if(resultCode == RESULT_OK){
				if(data.hasExtra("curso")){
					String curso = data.getExtras().getString("curso");
					tvResposta.setText("Resultado: Curso retornado - " + curso);
				}
			}
		}
	}
	
}
