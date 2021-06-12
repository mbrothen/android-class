package app.mattbrothen.dbgravity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db";
    private static final String DATABASE_TABLE = "gravities";

    private static final String KEY_TASK_ID = "_id";
    private static final String TITLE = "title";
    private static final String VALUE = "value";


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL("CREATE TABLE constants (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, value REAL);");
            ContentValues cv=new ContentValues();

            cv.put(TITLE, "Gravity, Death Star I");
            cv.put(VALUE, SensorManager.GRAVITY_DEATH_STAR_I);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Earth");
            cv.put(VALUE, SensorManager.GRAVITY_EARTH);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Jupiter");
            cv.put(VALUE, SensorManager.GRAVITY_JUPITER);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Mars");
            cv.put(VALUE, SensorManager.GRAVITY_MARS);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Mercury");
            cv.put(VALUE, SensorManager.GRAVITY_MERCURY);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Moon");
            cv.put(VALUE, SensorManager.GRAVITY_MOON);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Neptune");
            cv.put(VALUE, SensorManager.GRAVITY_NEPTUNE);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Pluto");
            cv.put(VALUE, SensorManager.GRAVITY_PLUTO);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Saturn");
            cv.put(VALUE, SensorManager.GRAVITY_SATURN);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Sun");
            cv.put(VALUE, SensorManager.GRAVITY_SUN);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, The Islant");
            cv.put(VALUE, SensorManager.GRAVITY_THE_ISLAND);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Uranus");
            cv.put(VALUE, SensorManager.GRAVITY_URANUS);
            sqLiteDatabase.insert("constants", TITLE, cv);

            cv.put(TITLE, "Gravity, Venus");
            cv.put(VALUE, SensorManager.GRAVITY_VENUS);
            sqLiteDatabase.insert("constants", TITLE, cv);

        }
        catch (Exception ex) {

        }

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase
            , int oldVersion, int newVersion){
        android.util.Log.w("Constants", "Upgrading database, which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS constants");
        onCreate(sqLiteDatabase);


    }

    public DatabaseHelper (Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
