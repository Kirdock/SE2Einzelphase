package com.example.klaus.einzelbeispiel;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btnCalcClick(View view) {
        //**würg**
        EditText txtDividend = (EditText) findViewById(R.id.txtDividend);
        EditText txtDivisor = (EditText) findViewById(R.id.txtDivisor);
        TextView lblResult = (TextView) findViewById(R.id.lblResult);
        Boolean valid = true;

        if(StringValid(txtDividend) && StringValid(txtDivisor)){
            //Android is so schiach
            double result = Double.parseDouble(txtDividend.getText().toString()) / Double.parseDouble(txtDivisor.getText().toString());
            String res = result == (long) result ? String.format("%d",(long)result) : String.format("%s", result);
            lblResult.setText(res.equals("NaN") ? getString(R.string.number_invalid) : res.equals("Infinity") ? getString(R.string.infinity) : res);

            //Kemma nit mit Unity  oda sowos in da Ort orbeitn? C# is so vül schena und nit so schiach wie des. Allan de GUI-Erstöllung bei Android is a Zuastond
        }
    }

    private boolean StringValid(EditText editText){
        boolean status = editText.getText().toString().equals("");
        if(status){
            editText.setError(getString(R.string.required));
        }
        return !status;
    }
}
