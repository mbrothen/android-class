package app.mattbrothen.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        String[] schools = {
                "Gateway Technical College",
                "Madison College",
                "MATC",
                "Blackhawk",
                "Chippewa Valley",
                "Fox Valley",
                "Lakeshore",
                "Mid-State",
                "Moraine Park",
                "Nicolet",
                "Northeast",
                "WCTC",
                "Western Tech",
                "Indianhead"
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        CustomAdapter customAdapter = new CustomAdapter(schools);
        recyclerView.setAdapter(customAdapter);

    }

}
