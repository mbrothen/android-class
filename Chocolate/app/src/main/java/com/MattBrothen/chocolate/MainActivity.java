package com.MattBrothen.chocolate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickFindChocolate(View view){
        String selected;
        Spinner spinner = findViewById(R.id.spinner);
        TextView textView = findViewById(R.id.chocolates);
        selected = spinner.getSelectedItem().toString();
        textView.setText(selected);
    }

}