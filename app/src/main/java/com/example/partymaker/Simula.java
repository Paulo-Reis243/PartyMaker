package com.example.partymaker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Simula extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText pratoPrincipal;
    private EditText numeroPessoa;
    private EditText preco;
    private Spinner spinner;
    private Double variancia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_calculator);

        spinner = findViewById(R.id.spinner);
        pratoPrincipal = (EditText) findViewById(R.id.pratoPrincipal);
        numeroPessoa = (EditText) findViewById(R.id.numeroPessoa);
        preco = (EditText) findViewById(R.id.preco);

        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.festa, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter1);
        spinner.setOnItemSelectedListener(this);

    }

    public void onBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onCalcula(View view){
        String numPessoa = numeroPessoa.getText().toString();
        String price = preco.getText().toString();
        String sms = "";

        if(numPessoa.trim().isEmpty() || price.trim().isEmpty()){
            sms = "Campos vazio!";
        }else{
            double valor1 = Double.parseDouble(numeroPessoa.getText().toString());
            double valor2 = Double.parseDouble(preco.getText().toString());
            double resultado = (valor1*variancia)*valor2;
            sms = " " + resultado;
        }


        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("O resultado é: " + sms);
        dlg.setNegativeButton("Ok", null);
        dlg.create().show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapter1, View view, int position, long id) {
        int item = spinner.getSelectedItemPosition();
        String value = "";
        String number = "0.0";
        switch (item){
            case 0:
                break;
            case 1:
                value = "Carne";
                number = "17.98";
                variancia = 0.22;
                break;
            case 2:
                value = "Bolo";
                number = "40.00";
                variancia = 0.1;
                break;
            case 3:
                value = "Chá";
                number = "5,50";
                variancia = 0.1;
                break;
            case 4:
                value = "";
                number = "";
                variancia = 0.0;
        }

        pratoPrincipal.setText(value);
        preco.setText(number);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
