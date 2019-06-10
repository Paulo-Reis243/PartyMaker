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

public class PartyMakerResult extends AppCompatActivity {
    private TextView convite;
    ClipboardManager clipboardManager;
    ClipData clipData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partymaker_result);

        convite = (TextView) findViewById(R.id.convite);

        Intent it = getIntent();

        //Recuperei a string da outra activity
        String informacao = it.getStringExtra("Informacao");

        convite.setText(informacao);

    }


    public void onCopy(View view){
        String text = convite.getText().toString();
        clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        clipData = ClipData.newPlainText("text", text);
        clipboardManager.setPrimaryClip(clipData);
        Toast.makeText(PartyMakerResult.this, "Copiado", Toast.LENGTH_SHORT);
    }

    public void onWhats(View view){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, convite.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void onBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
