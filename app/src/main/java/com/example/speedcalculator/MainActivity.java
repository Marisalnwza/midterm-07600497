package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    double dnum;
    double tnum;
    double average;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cal_button = findViewById(R.id.cal_button);
        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText distanceEdittext = findViewById(R.id.distance_edittext);
                final EditText timeEdittext = findViewById(R.id.time_edittext);
                final TextView averageTextView = findViewById(R.id.average_textview);
                String distanceNumText = distanceEdittext.getText().toString();
                String timeNumText = timeEdittext.getText().toString();
                if(distanceNumText.isEmpty() || timeNumText.isEmpty()){
                    Toast t = Toast.makeText(MainActivity.this, R.string.required, Toast.LENGTH_LONG);
                    t.show();
                }
                else if(distanceNumText.length()>0||timeNumText.length()>0){
                    if(timeNumText.equalsIgnoreCase("0")){
                        Toast t = Toast.makeText(MainActivity.this, R.string.timenotzero, Toast.LENGTH_LONG);
                        t.show();
                    }
                    else{
                        dnum = Double.parseDouble(distanceNumText);
                        tnum = Double.parseDouble(timeNumText);
                        average = (dnum/tnum)*3.6;
                        String str = String.format(
                                Locale.getDefault(),"%.2f",average
                        );
                        averageTextView.setText(str);
                        if(average>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("speed calculator");
                            dialog.setMessage(R.string.speedover);
                            dialog.setNegativeButton("OK", null);
                            dialog.show();
                        }
                    }

                }


                Button clearButton = findViewById(R.id.clear_button);
                clearButton.setOnClickListener(new View.OnClickListener(){

                    public void onClick(View view){
                        
                    }
                });


            }
        }


        );
    }
}