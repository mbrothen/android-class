package app.mattberothen.BasicLayouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    String[] schoolsArray = {"Gateway","Milwaukee","Waukesha","Madison",
            "Blackhawk","Chippewa Valley","Nicolet","Southwest Wisconsin"};
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.tree1, R.drawable.tree2,
            R.drawable.tree3, R.drawable.tree4,
            R.drawable.tree5, R.drawable.tree6,
            R.drawable.tree7, R.drawable.tree8,
            R.drawable.tree9, R.drawable.tree10,
            R.drawable.tree11, R.drawable.tree1,
            R.drawable.tree2, R.drawable.tree3,
            R.drawable.tree4, R.drawable.tree5,
            R.drawable.tree6, R.drawable.tree7,
            R.drawable.tree8, R.drawable.tree9,
            R.drawable.tree10, R.drawable.tree11,
            R.drawable.tree1, R.drawable.tree2
    };

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_layout);
    /*
    //Converts school array to listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, schoolsArray);
        ListView listView = (ListView) findViewById(R.id.schools_list);
        listView.setAdapter(adapter);*/

    //Creates image adapter for gridview
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

    }
}