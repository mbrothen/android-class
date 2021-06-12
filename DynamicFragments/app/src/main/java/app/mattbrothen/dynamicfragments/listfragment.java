package app.mattbrothen.dynamicfragments;
/*
public class listfragment {
}
*/
import android.*;
import android.R;
import android.annotation.TargetApi;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


public class listfragment extends ListFragment {
    ListView listview;
    View view;
    String[] array=new String[]{"Android","BlackBerry","Windows","Iphone"};
    int mCurCheckPosition = 0;
    public View onCreateView(LayoutInflater i,ViewGroup container,Bundle savedInstanceState)
    {

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1,R.id.text1,array);

        setListAdapter(adapter);
        return super.onCreateView(i,container,savedInstanceState);
    }
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        listview=getListView();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Display a toast with the current list item
                Toast.makeText(getActivity(), (CharSequence) listview.getItemAtPosition(i),Toast.LENGTH_LONG).show();
                // Call the show details on list click with the current position
                showDetails(i);
            }
            void showDetails(int index){
                mCurCheckPosition = index;
                // Create an intent for starting the DetailsActivity
                Intent intent = new Intent();

                // Set the activity context and class
                intent.setClass(getActivity(), MainActivity.DetailsActivity.class);

                // pass the current position
                intent.putExtra("index", index);

                startActivity(intent);
            }
        });
    }
}