package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Calculadora extends AppCompatActivity {
    private double num, num2, res;
    private int op ;
    private TextView textView;
    private boolean esRad = false;
    private boolean numeroIngresado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ClickbtnCl(View view) {
        num = 0.0;
        num2 = 0.0;
        op = 0;
        textView = findViewById(R.id.Operacion);
        textView.setText("");
    }

    public void ClickbtnSum(View view) {
        op = 1;
        textView = findViewById(R.id.Operacion);
        num = Double.parseDouble(textView.getText().toString());
        textView.setText("");
    }

    public void ClickbtnRes(View view) {
        op = 2;
        textView = findViewById(R.id.Operacion);
        num = Double.parseDouble(textView.getText().toString());
        textView.setText("");
    }

    public void ClickbtnMul(View view) {
        op = 3;
        textView = findViewById(R.id.Operacion);
        num = Double.parseDouble(textView.getText().toString());
        textView.setText("");
    }

    public void ClickbtnDiv(View view) {
        op = 4;
        textView = findViewById(R.id.Operacion);
        num = Double.parseDouble(textView.getText().toString());
        textView.setText("");
    }

    public void ClickbtnSin(View view) {
        op = 5;
        textView = findViewById(R.id.Operacion);
        String numero = textView.getText().toString().replace("TextView", "");
        if (!numero.isEmpty()) {
            try {
                num = Double.parseDouble(numero);
                numeroIngresado = true;
                textView.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Número no válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }

    public void ClickbtnCos(View view) {
        op = 6;
        textView = findViewById(R.id.Operacion);
        String numero = textView.getText().toString().replace("TextView", "");
        if (!numero.isEmpty()) {
            try {
                num = Double.parseDouble(numero);
                numeroIngresado = true;
                textView.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Número no válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "ingrese un número", Toast.LENGTH_SHORT).show();
        }
    }

    public void ClickbtnNum(View view) {
        textView = findViewById(R.id.Operacion);
        Button button = (Button) view;
        String buttonText = button.getText().toString();
        textView.append(buttonText);
    }

    public void ClickbtnEq(View view) {
        textView = findViewById(R.id.Operacion);
        String texto = textView.getText().toString();

        if (TextUtils.isEmpty(texto)) {
            Toast.makeText(this, "Ingrese un número antes de calcular", Toast.LENGTH_SHORT).show();
            return;
        }

        num2 = Double.parseDouble(texto);

        switch (op) {
            case 1:
                res = num + num2;
                break;
            case 2:
                res = num - num2;
                break;
            case 3:
                res = num * num2;
                break;
            case 4:
                if (num2 != 0) {
                    res = num / num2;
                } else {
                    Toast.makeText(this, "Math Error", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            case 5:
                res = Math.sin(num);
                break;
            case 6:
                res = Math.cos(num);
                break;
            default:
                Toast.makeText(this, "Operador no válido", Toast.LENGTH_SHORT).show();
                return;
        }

        // Mostrar el resultado
        textView.setText(String.format(Locale.getDefault(), "%.2f", res));
    }
}