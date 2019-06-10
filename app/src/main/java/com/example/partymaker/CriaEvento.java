package com.example.partymaker;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class CriaEvento  extends AppCompatActivity {
    private EditText nome;
    private EditText data;
    private EditText horario;
    private EditText endereco;
    private EditText obs;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_maker);

        nome = (EditText) findViewById(R.id.nome);
        data = (EditText) findViewById(R.id.data);
        horario = (EditText) findViewById(R.id.horario);
        endereco = (EditText) findViewById(R.id.endereco);
        obs = (EditText) findViewById(R.id.obs);

    }

    public void onBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCria(View view){
        String convite = nome.getText() + "\n" + data.getText() + "\n" + horario.getText() + "\n" + endereco.getText() + "\n" + obs.getText();
        Intent it = new Intent(this, PartyMakerResult.class);
        it.putExtra("Informacao", convite);
        startActivity(it);
        //convite = nome.getText() + "\n" + data.getText() + "\n" + horario.getText() + "\n" + endereco.getText() + "\n" + obs.getText();
        //resultado = (TextView) findViewById(R.id.convite);
        //resultado.setText(convite);

    }


}
