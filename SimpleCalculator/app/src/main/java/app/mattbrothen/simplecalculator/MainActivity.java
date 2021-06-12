package app.mattbrothen.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText number1;
    private EditText number2;
    private Integer value1;
    private Integer value2;
    private RadioGroup operators;
    private TextView results;
    private char currentOperator = '+';
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Attach to view
        number1 = (EditText) findViewById(R.id.editTextNumber1);
        number2 = (EditText) findViewById(R.id.editTextNumber2);
        operators = (RadioGroup) findViewById(R.id.operatorGroup);
        results = (TextView) findViewById(R.id.resultsTextView);
        calculateButton = (Button) findViewById(R.id.calculateButton);

        // Number 1 saves to value1
        number1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text1 = number1.getText().toString();
                if (text1.length() != 0)
                    value1 =  Integer.parseInt(text1);

                Log.d("Value1 Changed", Integer.toString(value1));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        number2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Store changes to the text field
                String text2 = number2.getText().toString();
                if (text2.length() != 0)
                    value2 =  Integer.parseInt(text2);
                Log.d("value1 changed", Integer.toString(value2));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        operators.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int checkedOperator = operators.getCheckedRadioButtonId();
                Log.d("Checked Changed", Integer.toString(checkedOperator));
                // Store changes to the operator radio buttons
                switch (checkedOperator){
                case R.id.plusButton:
                    currentOperator = '+';
                    break;
                case R.id.minusButton:
                    currentOperator = '-';
                    break;
                case R.id.multiplyButton:
                    currentOperator = '*';
                    break;
                case R.id.divideButton:
                    currentOperator = '/';
                    break;
                }
            }
        });

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // I could have just checked and retrieved text values here but I originally had it
                // set to dynamically update without clicking the button

                calculateTotal();
            }
        });
    }
    public void calculateTotal(){
        int resultValue = 0;
        if ((value1 != null) && (value2!= null)){
            switch(currentOperator){
                // Do the calculations based on operator.
                case '+':
                    resultValue = value1 + value2;
                    Log.d("Calculated + : ", Integer.toString(resultValue));
                    break;
                case '-':
                    resultValue = value1 - value2;
                    Log.d("Calculated - : ", Integer.toString(resultValue));
                    break;
                case '*':
                    resultValue = value1 * value2;
                    Log.d("Calculated * : ", Integer.toString(resultValue));
                    break;
                case '/':
                    if(value2 != 0)
                        resultValue = value1 / value2;
                    else
                        resultValue = 0;
                    Log.d("Calculated / : ", Integer.toString(resultValue));
                    break;
            }
            results.setText(Integer.toString(resultValue));
        }
    }
}