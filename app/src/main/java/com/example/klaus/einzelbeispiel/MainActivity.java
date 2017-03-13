package com.example.klaus.einzelbeispiel;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtDividend, txtDivisor;
    private TextView lblResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
    }

    private void setControls(){
        txtDividend = (EditText) findViewById(R.id.txtDividend);
        txtDivisor = (EditText) findViewById(R.id.txtDivisor);
        lblResult = (TextView) findViewById(R.id.lblResult);
    }

    public void btnCalcClick(View view) {
        try {
            if (StringValid(txtDividend) && StringValid(txtDivisor)) {
                double result = Double.parseDouble(txtDividend.getText().toString()) / Double.parseDouble(txtDivisor.getText().toString());
                String res = result == (long) result ? String.format("%d", (long) result) : String.format("%s", result);
                lblResult.setText(res.equals("NaN") ? getString(R.string.number_invalid) : res.equals("Infinity") ? getString(R.string.infinity) : res);
            } else {
                lblResult.setText("");
            }
        }
        catch (Exception ex){
            lblResult.setText(ex.getMessage());
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
