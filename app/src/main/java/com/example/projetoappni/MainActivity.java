package com.example.projetoappni;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText valorEditText;
    private RadioGroup moedaRadioGroup;
    private Button calcularButton;
    private TextView resultadoTextView;

    private double taxaDolar = 5.07;
    private double taxaEuro = 5.37;

    private double taxaLibra = 6.37;
    private double taxaIene = 0.0038;
    private double taxaPeso = 0.0058;

    // Adicione taxas para outras moedas aqui

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valorEditText = findViewById(R.id.Valor);
        moedaRadioGroup = findViewById(R.id.rdGPs);
        calcularButton = findViewById(R.id.btnConfirmar);
        resultadoTextView = findViewById(R.id.Result);

        calcularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });
    }

    private void calcularResultado() {
        String valorString = valorEditText.getText().toString();
        if (!valorString.isEmpty()) {
            double valor = Double.parseDouble(valorString);
            double resultado = 0;

            int checkedRadioButtonId = moedaRadioGroup.getCheckedRadioButtonId();
            switch (checkedRadioButtonId) {
                case R.id.dolar:
                    resultado = valor * taxaDolar;
                    break;
                case R.id.Moeda:
                    resultado = valor * taxaEuro;
                    break;
                case R.id.peso:
                    resultado = valor * taxaPeso;
                    break;
                case R.id.iene:
                    resultado = valor * taxaIene;
                    break;
                    case R.id.libra:
                        resultado = valor * taxaLibra;
                        break;
            }

            resultadoTextView.setText("Resultado: " + resultado + "R$");
        } else {
            resultadoTextView.setText("Por favor, insira um valor");
        }
    }
}
