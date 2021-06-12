package app.MobileDev.LifeCycle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String tag = "Events";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(tag, "In OnCreate");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(tag, "in OnStart");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(tag, "In OnRestart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "In OnResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "In OnPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "In OnStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "In OnDestroy");
    }
}