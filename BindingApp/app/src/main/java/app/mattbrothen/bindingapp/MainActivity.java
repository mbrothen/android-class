package app.mattbrothen.bindingapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import android.util.Log;
import android.view.View;
//import android.databinding.DataBindingUtil;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;

import app.mattbrothen.bindingapp.databinding.ActivityMainBinding;




public class MainActivity extends AppCompatActivity {
    private User user;
    private  int position = 0;
    ArrayList<User> list = new ArrayList<User>();
    private Button btnNext;
    private Button btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActivityBindingBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_binding);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        /*
        user = new User();
        user.setName("yourname");
        user.setEmail("youremail@mail.gtc.edu");
        binding.setUser(user);*/

        createData();
        user = new User();
        user = list.get(0);
        binding.setUser(user);
        // Attach button to button.  I had these before I set the view....  that took awhile
        btnNext = (Button) findViewById(R.id.btnnext);
        btnPrevious = (Button) findViewById(R.id.btnprevious);
        // Button on click listeners
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("In On Click Next", Integer.toString(position));
                if(position + 1 >= list.size())
                    position = 0;
                else
                    position +=1;
                user = list.get(position);
                binding.setUser(user);

            }
        });
        btnPrevious.setOnClickListener(v -> {
            Log.d("In On Click Previous", Integer.toString(position));
            if(position == 0)
                position = list.size() - 1;
            else
                position -= 1;
            Log.d("Previoius BTN newPos", Integer.toString(position));
            user = list.get(position);
            binding.setUser(user);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createData() {
        user = new User();
        user.setName("Allen Pearson");
        user.setEmail("pearsona@gtc.edu");
        list.add(user);

        user = new User();
        user.setName("Jack Pearson");
        user.setEmail("pearsonj@gtc.edu");
        list.add(user);

        user = new User();
        user.setName("Albert Einstein");
        user.setEmail("einsteina@gtc.edu");
        list.add(user);

        user = new User();
        user.setName("Leonardo DaVinci");
        user.setEmail("davincil@gtc.edu");
        list.add(user);

        user = new User();
        user.setName("Walter Payton");
        user.setEmail("paytonw@gtc.edu");
        list.add(user);

    }
}