package net.apkkothon.localdb6;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by joy on 10/11/17.
 */

public class MyDBFunctions extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="mydb";
    public static final String TABLE_NAME="mytable";

    public static final String TAB_ID="id";
    public static final String TAB_NAME="name";
    public static final String TAB_PROFESSION="profession";




    public MyDBFunctions(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String q= "CREATE TABLE "+TABLE_NAME+" ( "+TAB_ID+" INTEGER PRIMARY KEY, "+TAB_NAME+" TEXT, "+TAB_PROFESSION+" TEXT )";

        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //--------add data to table--------
    void addToTable(Model model){

        SQLiteDatabase sql= this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put(TAB_NAME,model.getName());
        cv.put(TAB_PROFESSION,model.getProfession());

        sql.insert(TABLE_NAME,null,cv);
        sql.close();

    }

    //--------array list ----------
    String[] my_data(){

        SQLiteDatabase sq=this.getReadableDatabase();

        String q="SELECT * FROM "+TABLE_NAME;

        Cursor cursor=sq.rawQuery(q,null);

        String[] data =new String[cursor.getCount()];

        cursor.moveToFirst();

        if (cursor.moveToFirst()){
            int counter=0;
            do {
                data[counter]=cursor.getString(cursor.getColumnIndex(TAB_NAME+""));
                counter=counter+1;

            }while (cursor.moveToNext());
        }

        return data;
    }


    //----------------- fetch name-----------

    String fetch_name(int position){

        SQLiteDatabase sqd=this.getReadableDatabase();

        String q="SELECT "+TAB_NAME+" FROM "+TABLE_NAME+" WHERE "+TAB_ID+" = "+position;

        Cursor cursor=sqd.rawQuery(q,null);

        String name="";
        cursor.moveToFirst();
        if (cursor.moveToFirst()){
            name= cursor.getString(cursor.getColumnIndex(TAB_NAME));

        }
        return name;
    }


    //----------name update---------

    int name_update(int position,String name) {


        SQLiteDatabase sqd=this.getWritableDatabase();

        ContentValues cv=new ContentValues();

        cv.put(TAB_NAME,name);

        return  sqd.update(TABLE_NAME,cv,TAB_ID+" = ? ",new String[]{position+""});
    }

    //------- delete name------

    int delete(int position){

        SQLiteDatabase sq=this.getWritableDatabase();

        return sq.delete(TABLE_NAME,TAB_ID+" = ? ",new String[]{position+""});

    }


}
