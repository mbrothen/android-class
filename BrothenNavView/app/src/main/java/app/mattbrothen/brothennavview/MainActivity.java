package app.mattbrothen.brothennavview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Our Toolbar");
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view_left);
        drawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new
                ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.openDrawer, R.string.closeDrawer);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                String newTitle = "title";
                menuItem.setChecked(!menuItem.isChecked());
                switch(menuItem.getItemId()){
                    case R.id.inbox:
                        newTitle = "Inbox";
                        break;
                    case R.id.starred:
                        newTitle = "Starred";
                        break;
                    case R.id.sent_mail:
                        newTitle = "Sent Mail";
                        break;
                    case R.id.drafts:
                        newTitle = "Drafts";
                        break;
                    case R.id.allmail:
                        newTitle = "All Mail";
                        break;
                    case R.id.trash:
                        newTitle = "Trash";
                        break;
                    case R.id.spam:
                        newTitle = "Spam";
                        break;
                }
                SelectedFragment selectedFragment =  new SelectedFragment();
                selectedFragment.setTitle(newTitle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, selectedFragment);
                fragmentTransaction.commit();
                drawerLayout.closeDrawers();
                Log.d("Logging", "On Nav Select");
                return true;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.menuAbout:
                Toast.makeText(this, "You clicked about", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuSettings:
                Toast.makeText(this, "You clicked settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuLogout:
                Toast.makeText(this, "You clicked logout", Toast.LENGTH_SHORT).show();
                break;

        }
        return true;
    }

}