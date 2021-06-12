package app.mattbrothen.brothenfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListActivity extends AppCompatActivity {
    Button backButton;
    SQLiteDatabase db;
    Cursor constantsCursor;
    int flags = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v->{
            // On click listener with labmda expression
            // Sends user to mainActivity again
            Intent intent = new Intent(v.getContext(), MainActivity.class);
            startActivity(intent);
        });

        // Database and List Adapter
        db=(new DatabaseHelper(this)).getWritableDatabase();
        constantsCursor=db.rawQuery("SELECT _ID, title, value "+
                        "FROM constants ORDER BY title",
                null);

        ListView listView = findViewById(R.id.listView1);
        ListAdapter adapter=new SimpleCursorAdapter(this,
                R.layout.row, constantsCursor, new String[] {"title", "value"},
                new int[] {R.id.title, R.id.value},flags);
        listView.setAdapter(adapter);
    }
}