package app.MattBerothen.multipleactivitieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private Button ok_button;
    private EditText txt_name;
    private String name;
    final String tag = "Logging Events";
    private static final String USER_NAME =
            "com.MattBerothen.multipleactivitieslab";  //Just noticed I spelled my own last name wrong naming the package.  Cool.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(tag,"In onCreate Second Activity");
        ok_button = (Button) findViewById(R.id.btn_OK);
        txt_name = (EditText) findViewById(R.id.txt_username);
        ok_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the data from the EditText Box
                name = txt_name.getText().toString();
                Intent intent = newIntent(SecondActivity.this, name);
                SecondActivity.super.onBackPressed();
            }
        });

    }
    public Intent newIntent(Context packageContext, String text){
        //****************************
        //This should be called after the name has been entered by the user.
        //****************************
        Intent intent = new Intent(packageContext, MainActivity.class);
        intent.putExtra(USER_NAME, text);
        setResult(RESULT_OK, intent);
        return  intent;
    }


}