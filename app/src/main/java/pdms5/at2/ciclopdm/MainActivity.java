package pdms5.at2.ciclopdm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import pdms5.at2.ciclopdm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    // Constante de filtro do LogCat
    private final String CICLO_PDM_TAG = "CICLO_PDM_TAG";

    // Constantes de dados de instância
    private final String TELEFONE = "TELEFONE";

    private ActivityMainBinding activityMainBinding;

    // Views dinâmicas
    private TextView telefoneTv;
    private EditText telefoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        // View dinâmicas
        telefoneTv = new TextView(this);
        telefoneTv.setText("Telefone");
        telefoneEt = new EditText(this);
        telefoneEt.setInputType(InputType.TYPE_CLASS_PHONE);

        //Adicionando Views dinâmicas no Layout
        activityMainBinding.linearLayout.addView(telefoneTv);
        activityMainBinding.linearLayout.addView(telefoneEt);

        // Restaurando dados de instância antigos, se necessário
        /*if(savedInstanceState != null){
            telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
        }*/

        Log.v(CICLO_PDM_TAG, "onCreate: Iniciando ciclo COMPLETO");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(CICLO_PDM_TAG, "onStart: Iniciando o ciclo VISÍVEL");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(CICLO_PDM_TAG, "onResume: Iniciando o ciclo em PRIMEIRO PLANO");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(CICLO_PDM_TAG, "onPause: Finalizando ciclo em PRIMEIRO PLANO");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(CICLO_PDM_TAG, "onStop: Finalizando ciclo VISIVEL");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(CICLO_PDM_TAG, "onDestroy: Finalizando ciclo COMPLETO");
    }

    //Opicionalmente
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(CICLO_PDM_TAG, "onRestart: Preparando para chamar onStart");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //Salvando dados do estado dinâmico
        outState.putString(TELEFONE, telefoneEt.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        telefoneEt.setText(savedInstanceState.getString(TELEFONE, ""));
    }
}