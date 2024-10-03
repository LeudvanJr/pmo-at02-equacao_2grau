/*
 *@author:<Leudvan Guedes>
 */

package br.edu.fateczl.equacao_2grau;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText et1Termo;
    private EditText et2Termo;
    private EditText et3Termo;
    private TextView tvResposta1;
    private TextView tvResposta2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et1Termo = findViewById(R.id.et1Termo);
        et2Termo = findViewById(R.id.et2Termo);
        et3Termo = findViewById(R.id.et3Termo);
        tvResposta1 = findViewById(R.id.tvResposta1);
        tvResposta2 = findViewById(R.id.tvResposta2);
        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(op -> calcular());
    }

    private void calcular() {
        float a = Float.parseFloat(et1Termo.getText().toString());
        float b = Float.parseFloat(et2Termo.getText().toString());
        float c = Float.parseFloat(et3Termo.getText().toString());
        tvResposta1.setText("");
        tvResposta2.setText("");

        float delta = (b*b) - (4*a*c);

        if(delta < 0){
            tvResposta1.setText(R.string.semRaizReal);
            return;
        }
        if(delta == 0){
            float x = (-b)/(2*a);
            String res = getString(R.string.umaRaizReal) + " " + x;
            tvResposta1.setText(res);
            return;
        }
        delta = (float) Math.sqrt(delta);
        float x1 = ((-b) + delta)/(2*a);
        float x2 = ((-b) - delta)/(2*a);
        String res1 = getString(R.string.primeiraRaiz) + " " + x1;
        String res2 = getString(R.string.segundaRaiz) + " " + x2;

        tvResposta1.setText(res1);
        tvResposta2.setText(res2);
    }
}