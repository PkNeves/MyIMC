package adroid.petterson.myimc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Relatorio extends AppCompatActivity {

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Ciclo de vida", getClass() + ".onCreate() chamado");
        setContentView(R.layout.activity_relatorio);

        Intent it = getIntent();

        TextView nome = (TextView) findViewById(R.id.nome);
        TextView idade = (TextView) findViewById(R.id.idade);
        TextView peso = (TextView) findViewById(R.id.peso);
        TextView altura = (TextView) findViewById(R.id.altura);
        TextView imc = (TextView) findViewById(R.id.imc);
        TextView ideal = (TextView) findViewById(R.id.pesoIdeal);
        TextView classificacao = (TextView) findViewById(R.id.classificacao);
        double dpeso = it.getDoubleExtra("peso", 1.0);
        double daltura = it.getDoubleExtra("altura", 1.0);
        double calcImc = dpeso / (daltura * daltura);

        // imc = peso / (altura * altura)

        nome.setText(it.getStringExtra("nome"));
        idade.setText(it.getIntExtra("idade",1) + " anos");
        peso.setText(dpeso + " Kg");
        altura.setText(daltura + " m");
        imc.setText(String.format("%.2f", calcImc) + " Kg/m2");
        classificacao.setText(classificacaoIMC(calcImc));
        ideal.setText(pesoIdeal(daltura));

    }

    @SuppressLint("DefaultLocale")
    public String pesoIdeal(double altura) {
        double minimo = 18.51 * (altura * altura);
        double maximo = 24.9 * (altura * altura);
        return String.format("%.2f - %.2f", minimo, maximo);
    }

    public String classificacaoIMC(double imc) {
        if (imc < 18.5) return "Abaixo do Peso";
        else if (imc < 25) return "Saudável";
        else if (imc < 30) return "Sobrepeso";
        else if (imc < 35) return "Obesidade Grau I";
        else if (imc < 40) return "Obesidade Grau II (severa)";
        else return "Obesidade Grau III (mórbida)";
    }

    public void back(View v) {
        Intent it = new Intent(getBaseContext(), MainActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        finish();
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