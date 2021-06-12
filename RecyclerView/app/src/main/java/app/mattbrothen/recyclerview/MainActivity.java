package app.mattbrothen.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayList<String> list = new ArrayList<String>();
        String[] schools = {
                "Wisconsin",
                "Illinois",
                "Purdue",
                "Nebraska",
                "Northwestern",
                "Iowa",
                "Michigan",
                "Michigan State",
                "Ohio State",
                "Penn State",
                "Minnesota",
                "Indiana",
                "Rutgers",
                "Maryland"
        };

        for(int i = 0; i < schools.length; i++ )
            list.add(schools[i]);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,schools );
        listView.setAdapter(adapter);
        Button secondActivityButton = (Button) findViewById(R.id.button);
        secondActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
                startActivity(intent);
            }

        });


    }
}