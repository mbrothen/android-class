package app.mattbrothen.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    String tag = "Debug Tag";
/*    String[] schools = {
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
            "Indiana"
    };*/
    String[] schools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        schools = getResources().getStringArray(R.array.schools_array);
        setContentView(R.layout.activity_main);
        /////////////////
        //  Add click listener to list, display toast
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                Toast.makeText(getApplicationContext(),schools[position], Toast.LENGTH_LONG).show();
                Log.d(tag, "Listeners");
            }
        };
        /////////////////
        ListView listView = (ListView) findViewById(R.id.list_schools);
        TextView textView = (TextView) findViewById(R.id.textView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, android.R.id.text1,schools);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(itemClickListener);  //Took too long to remember to add this line
        Log.d(tag, "in On Create");

    }

}