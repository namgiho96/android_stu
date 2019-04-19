package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Map;

import static com.example.contact.Index.*;
public class MemberUpdate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_update);
        Context _this = MemberUpdate.this;
        String[] spec = getIntent()
                .getStringExtra("spec")
                .split(",");
        Member m = new Member();
        ImageView photo = findViewById(R.id.profile);
        photo.setImageDrawable(
                getResources()
                        .getDrawable(
                                getResources()
                                        .getIdentifier(
                                                _this.getPackageName()+":drawable/"
                                                        +spec[4],
                                                null,
                                                null),
                                _this.getTheme()
                        )
        );
        EditText name = findViewById(R.id.name);
        name.setText(spec[0]);
        EditText changeEmail = findViewById(R.id.changeEmail);
        changeEmail.setText(spec[1]);
        EditText changePhone = findViewById(R.id.changePhone);
        changePhone.setText(spec[2]);
        EditText changeAddress = findViewById(R.id.changeAddress);
        changeAddress.setText(spec[3]);




    }

    private class UpdateQurey extends QueryFactory{
        SQLiteOpenHelper helper;
        public UpdateQurey(Context _this) {
            super(_this);
            helper = new SQLiteHelper(_this);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getWritableDatabase();
        }
    }

    private class ItemUpdate extends UpdateQurey{
        public ItemUpdate(Context _this) {
            super(_this);
        }
        public Member update(){
            Member m = null;
            Cursor c = this.getDatabase().rawQuery(String.format(""),null);

            return null;
        }

    }
}
