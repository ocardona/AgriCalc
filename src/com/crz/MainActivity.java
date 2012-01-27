package com.crz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    private Button btnConvert;
    private EditText txtInputArea;
    private RadioGroup rbgInputUnits;
    private RadioGroup rbgOutputUnits;
    private EditText txtOutputArea;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        txtInputArea = (EditText) findViewById(R.id.txtInputArea);
        txtOutputArea = (EditText) findViewById(R.id.txtOutputArea);
        rbgInputUnits = (RadioGroup) findViewById(R.id.rbgInputUnits);
        rbgOutputUnits = (RadioGroup) findViewById(R.id.rbgOutputUnits);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Calcular el area en la nueva unidad de area
                String strInputArea = txtInputArea.getText().toString();
                double inputArea = Double.parseDouble(strInputArea);
                double outputArea = 0;
                int inputUnit = rbgInputUnits.getCheckedRadioButtonId();
                int outputUnit = rbgOutputUnits.getCheckedRadioButtonId();
                double inputBase = 1.0;
                double outputBase = 1.0;

                switch (inputUnit) {
                    case R.id.rbFromMz:
                        inputBase = 7000.0;
                        break;
                    case R.id.rbFromHa:
                        inputBase = 10000.0;
                        break;
                    case R.id.rbFromVrs2:
                        inputBase = 0.70;
                        break;
                    case R.id.rbFromMts2:
                        inputBase = 1.0;
                        break;
                }

                // Convierte el area ingresada a metros cuadrados
                inputArea = inputArea * inputBase;

                switch (outputUnit) {
                    case R.id.rbToMz:
                        outputBase = 1 / 7000.0;
                        break;
                    case R.id.rbToHa:
                        outputBase = 1 / 10000.0;
                        break;
                    case R.id.rbToVrs2:
                        outputBase = 1 / 0.70;
                        break;
                    case R.id.rbToMts2:
                        outputBase = 1 / 1.0;
                        break;
                }

                outputArea = inputArea * outputBase;

                txtOutputArea.setText(Double.toString(outputArea));
            }
        });
    }
}