package com.example.princedeep.myapplication;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;



import static com.example.princedeep.myapplication.database.Entry.COLUMN_NAME_TITLE;
import static com.example.princedeep.myapplication.database.Entry.TABLE_NAME;



class database extends SQLiteOpenHelper {

    /* Inner class that defines the table contents */
    public static class Entry implements BaseColumns {
        public static final String TABLE_NAME = "livingroomentry";
        public static final String COLUMN_NAME_STRINGID = "stringid";
        public static final String COLUMN_NAME_ACCESSCOUNT = "accesscount";
        public static final String COLUMN_NAME_TITLE = "title";
    }

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 5;
    public static final String DATABASE_NAME = "LivingRoom.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    Entry._ID + " INTEGER PRIMARY KEY," +
                    Entry.COLUMN_NAME_STRINGID + INT_TYPE + COMMA_SEP +
                    Entry.COLUMN_NAME_ACCESSCOUNT + INT_TYPE + COMMA_SEP +
                    Entry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP
                    + "unique(" + COLUMN_NAME_TITLE + "))";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;


    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

        db.execSQL("insert into " + TABLE_NAME + " values ( null, ?, ?, ?)",
                new String[]{String.valueOf(R.string.livingroom_television), "0", "Television"});
        db.execSQL("insert into " + TABLE_NAME + " values ( null, ?, ?, ?)",
                new String[]{String.valueOf(R.string.livingroom_lights), "0", "Lights"});
        db.execSQL("insert into " + TABLE_NAME + " values ( null, ?, ?, ?)",
                new String[]{String.valueOf(R.string.livingroom_blinds), "0", "Blinds"});
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
