package app.MattBerothen.multipleactivitieslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final String tag = "Logging Events";
    private Button secondActivityButton;
    private TextView textView;
    private static final int REQUEST_CODE = 0;
    private static final String USER_NAME = "com.MattBerothen.multipleactivitieslab";

/*    public MainActivity(Button secondActivityButton) {
        this.secondActivityButton = secondActivityButton;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        secondActivityButton = findViewById(R.id.SecondActivityButton);

        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "onCreate for Main Activity");
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        textView = findViewById(R.id.name_text_view);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        //super.onActivityResult(requestCode, resultCode, data);
        String dataReturned;
        dataReturned = data.getStringExtra(USER_NAME);
        textView.setText(dataReturned);
    }

}