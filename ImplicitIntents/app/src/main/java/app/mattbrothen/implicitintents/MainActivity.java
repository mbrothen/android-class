package app.mattbrothen.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button gatewayButton;
    private static final int REQUEST_CONTACT = 1;
    private Button contactButton;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gatewayButton = (Button) findViewById(R.id.gateway);
        gatewayButton.setOnClickListener(v -> {
            Intent intentObj = new Intent(Intent.ACTION_VIEW);
            intentObj.setData(Uri.parse("https://www.gtc.edu"));
            startActivity(intentObj);
        });

        contactButton = (Button) findViewById(R.id.contacts);
        textView = findViewById(R.id.textView);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CONTACT && data != null)
        {
            Uri contactUri = data.getData();
// Specify which fields you want your query to return
// values for.
            String[] queryFields = new String[]{
                    ContactsContract.Contacts.DISPLAY_NAME
            };

            Cursor c = getContentResolver()
                    .query(contactUri, queryFields, null, null, null);
            try {
                // Double-check that you actually got results
                if (c.getCount() == 0) {
                    return;
                }
                // Pull out the first column of the first row of data -
                // that is your suspect's name.
                c.moveToFirst();
                String name = c.getString(0);
                textView.setText(name);
            } finally {
                c.close();
            }


        }

    }

}