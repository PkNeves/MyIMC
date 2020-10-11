package adroid.petterson.myimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo de vida", getClass() + ".onCreate() chamado");
        setContentView(R.layout.activity_main);
    }

    public void calcularIMC(View v) {
        EditText nome = (EditText) findViewById(R.id.inputNome);
        EditText idade = (EditText) findViewById(R.id.inputIdade);
        EditText peso = (EditText) findViewById(R.id.inputPeso);
        EditText altura = (EditText) findViewById(R.id.inputAltura);

        Intent it = new Intent(getBaseContext(), Relatorio.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        it.putExtra("nome", nome.getText().toString());
        it.putExtra("idade", Integer.parseInt(idade.getText().toString()));
        it.putExtra("peso", Double.parseDouble(peso.getText().toString()));
        it.putExtra("altura", Double.parseDouble(altura.getText().toString()));

        startActivity(it);
    }

    private String getClassName() {
        String s = getClass().getName();
        return s;
    }

    protected void onStart() {
        super.onStart();
        Log.i("Ciclo de vida", getClass() + ".onStart() chamado");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("Ciclo de vida", getClass() + ".onRestart() chamado");
    }

    protected void onResume() {
        super.onResume();
        Log.i("Ciclo de vida", getClass() + ".onResume chamado");
    }

    protected void onPause() {
        super.onPause();
        Log.i("Ciclo de vida", getClass() + ".onPause chamado");
    }

    protected void onStop() {
        super.onStop();
        Log.i("Ciclo de vida", getClass() + ".onStop chamado");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("Ciclo de vida", getClass() + ".onDestroy chamado");
    }

}