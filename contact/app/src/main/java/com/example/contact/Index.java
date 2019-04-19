package com.example.contact;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Index extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index);
       final Context _this = Index.this;

        findViewById(R.id.moveLogin).setOnClickListener((v)->{
            Toast.makeText(_this,"다음버튼 눌렀다",Toast.LENGTH_LONG).show();
            SQLiteHelper helper = new SQLiteHelper(_this);
            startActivity(new Intent(_this, Login.class));
        });
    }
    static class Member{int seq; String name, pw,email,phone,addr,photo;}
    static interface IRun{public void run();}
    static interface ISupplier{public Object get();}
    static interface IComsumer{public void accept(Object o);}
    static interface IFunction{public Object apply(Object o);}
    static interface IPredicate{public boolean test(Object o);}


    static String DBNAME = "contacts.db";
    static String MEMBERS = "MEMBER";
    static String MSEQ = "SEQ";
    static String MNAME = "NAME";
    static String MPW = "PW";
    static String MEMAIL = "EMAIL";
    static String MPHONE = "PHONE";
    static String MADDR = "ADDR";
    static String MPHOTO = "PHOTO";

    static  abstract class QueryFactory{
        Context _this;

        public QueryFactory(Context _this) {
            this._this = _this;
        }
        public  abstract SQLiteDatabase getDatabase();
    }

    static  class SQLiteHelper extends SQLiteOpenHelper{

        public SQLiteHelper(Context context) {
            super(context, DBNAME,null,1);
            this.getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = String.format(
                    " CREATE TABLE IF NOT EXISTS %s "
                            +"( %s INTEGER PRIMARY KEY AUTOINCREMENT, "
                            +" %s TEXT, "
                            +" %s TEXT, "
                            +" %s TEXT, "
                            +" %s TEXT, "
                            +" %s TEXT, "
                            +" %s TEXT "
                            +")",MEMBERS, MSEQ, MNAME, MPW, MEMAIL, MPHONE, MADDR, MPHOTO
            );
            Log.d("실행할 쿼리 :: ", sql);
            db.execSQL(sql);
            Log.d("==============", "create 쿼리실행완료");
           /* String[] names = {"다현","나연","모모","사나","채영"};
            String[] email = {"da","na","mo","sa","ch"};

            for (int i=0; i<names.length; i++){
                Log.d("입력될 이름 :::", names[i]);
                Log.d("입력될 이메일 :::", email[i]);

                db.execSQL(String.format(" INSERT INTO %s " +
                                "(%s ," +
                                "%s ," +
                                "%s ," +
                                "%s ," +
                                "%s ," +
                                "%s " +
                                " )VALUES( " +
                                " '%s', " +
                                " '%s', " +
                                " '%s', " +
                                " '%s', " +
                                " '%s', " +
                                " '%s' )",
                        MEMBERS, MNAME, MPW, MEMAIL, MPHONE, MADDR, MPHOTO,
                        names[i],
                        "1",
                        email[i]+"@test.com",
                        "010-1234-5678"+(i+1),
                        "신촌"+(i+1)+"길",
                        "photo_"+(i+1)));
            }*/
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}

