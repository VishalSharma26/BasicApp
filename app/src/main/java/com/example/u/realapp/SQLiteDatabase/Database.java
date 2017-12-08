package com.example.u.realapp.SQLiteDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLDataException;
public class Database {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "person_Name";
    public static final String KEY_REG = "person_Reg";
    public static final String KEY_EMAIL = "person_Emails";
    public static final String KEY_PHONE = "person_Phonet";
    public static final String KEY_GENDER = "person_Gender";

    private static final String DATABASE_NAME = "DataBase_name";
    private static final String DATABASE_TABLE = "person_Table";
    private static final int DATABASE_VERSION = 1;

    private DbHelper ourHelper;
    private final Context ourContext;
    private SQLiteDatabase ourDatabase;



    public static class DbHelper extends SQLiteOpenHelper {

        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                            KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                            KEY_NAME + " TEXT NOT NULL, " +
                            KEY_REG + " TEXT NOT NULL, " +
                            KEY_EMAIL + " TEXT NOT NULL, " +
                            KEY_PHONE + " TEXT NOT NULL, " +
                            KEY_GENDER + " TEXT NOT NULL); "
            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
            onCreate(db);
        }
    }

    public Database(Context ct) {
        ourContext = ct;
    }
    public Database open() throws SQLDataException {
        ourHelper = new DbHelper(ourContext);
        ourDatabase = ourHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        ourHelper.close();
    }
    public long createEntry(String name, String age, String add, String con,String gen) throws SQLDataException {
        ContentValues cv = new ContentValues();
        cv.put(KEY_NAME, name);
        cv.put(KEY_REG, age);
        cv.put(KEY_EMAIL,add);
        cv.put(KEY_PHONE,con);
        cv.put(KEY_GENDER, gen);
        return ourDatabase.insert(DATABASE_TABLE,null,cv);
    }
    public String getData() throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,null,null,null,null,null);
        String result = "";
        int irow = c.getColumnIndex(KEY_ROWID);
        int iname = c.getColumnIndex(KEY_NAME);
        int iage = c.getColumnIndex(KEY_REG);
        int iadd = c.getColumnIndex(KEY_EMAIL);
        int icon = c.getColumnIndex(KEY_PHONE);
        int igen = c.getColumnIndex(KEY_GENDER);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            result  = result + c.getString(irow) + " , " + c.getString(iname) + " , " + c.getString(iage)+ " , " + c.getString(iadd)
                    + " , " + c.getString(icon)+ " , "+ c.getString(igen)+ " , " + "\n\n";
        }

        return result;
    }

    public String returnName(long ln) throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,KEY_ROWID + "=" + ln,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
            String name = c.getString(1);
            return name;
        }
        return null;
    }

    public String returnAge(long ln) throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,KEY_ROWID + "=" + ln,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
            String age = c.getString(2);
            return age;
        }
        return null;
    }

    public String returnAdd(long ln) throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,KEY_ROWID + "=" + ln,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
            String add = c.getString(3);
            return add;
        }
        return null;
    }

    public String returnCon(long ln) throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,KEY_ROWID + "=" + ln,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
            String con = c.getString(4);
            return con;
        }
        return null;
    }

    public String returnGen(long ln) throws SQLDataException {
        String[] coloum = new String[]{KEY_ROWID,KEY_NAME,KEY_REG,KEY_EMAIL,KEY_PHONE,KEY_GENDER};
        Cursor c = ourDatabase.query(DATABASE_TABLE,coloum,KEY_ROWID + "=" + ln,null,null,null,null);
        if(c!=null){
            c.moveToFirst();
            String gen = c.getString(5);
            return gen;
        }
        return null;
    }

    public void updateEntry (long lng, String n, String r, String e, String p, String g) throws SQLDataException {
        ContentValues updateAll = new ContentValues();
        updateAll.put(KEY_NAME,n);
        updateAll.put(KEY_REG,r);
        updateAll.put(KEY_EMAIL,e);
        updateAll.put(KEY_PHONE,p);
        updateAll.put(KEY_GENDER,g);
        ourDatabase.update(DATABASE_TABLE,updateAll,KEY_ROWID + "=" + lng,null);
    }
    public void deleteEntry(long lg) {
        ourDatabase.delete(DATABASE_TABLE , KEY_ROWID + "=" + lg,null);
    }

}
