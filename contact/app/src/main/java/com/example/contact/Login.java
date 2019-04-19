package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Context _this = Login.this;
        findViewById(R.id.loginBtn).setOnClickListener((v)->{
            EditText userID = findViewById(R.id.userID);
            EditText password = findViewById(R.id.password);
            ItemExist exist = new ItemExist(_this);

            if (exist.test(userID.getText().toString(),password.getText().toString())){
                startActivity(new Intent(_this, MemberList.class));
            }else{
                Toast.makeText(_this,"아이디 비밀번호 틀렸다",Toast.LENGTH_LONG).show();
            }
        });
    }
    private class  LoinQuery extends Index.QueryFactory{
        SQLiteOpenHelper helper;
        public LoinQuery(Context _this) {
            super(_this);
            helper = new Index.SQLiteHelper(_this);
        }
        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase();
        }
    }
    private class ItemExist extends LoinQuery{
        public ItemExist(Context _this) {
            super(_this);
        }
        public boolean test(String id,String pw){
            return  super.getDatabase().rawQuery(String.format(
                             " SELECT * FROM %s "+
                             " WHERE %s LIKE '%s' AND %s LIKE '%s' ",
                    Index.MEMBERS,
                    Index.MSEQ,
                    id,
                    Index.MPW,
                    pw
            ), null)
                    .moveToNext();
        }
    }
}
