package com.example.contact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import static com.example.contact.Index.*;

public class MemberDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_detail);
        final Context _this = MemberDetail.this;
        Intent intent = this.getIntent();
        String seq = intent.getExtras().getInt("seq")+"";
        ImageView imageView = findViewById(R.id.profile);
        TextView name = findViewById(R.id.name);
        TextView email = findViewById(R.id.email);
        TextView  phone = findViewById(R.id.phone);
        TextView addr = findViewById(R.id.addr);
        ItemDtail itemDtail = new ItemDtail(_this);
        itemDtail.seq = seq;
        Member m = new Member();

        name.setText((String) new ISupplier() {
            @Override
            public Object get() {
                return itemDtail.get().name;
            }
        }.get());
        email.setText((String) new ISupplier() {
            @Override
            public Object get() {
                return itemDtail.get().email;
            }
        }.get());
        phone.setText((String) new ISupplier() {
            @Override
            public Object get() {
                return itemDtail.get().phone;
            }
        }.get());
        addr.setText((String) new ISupplier() {
            @Override
            public Object get() {
                return itemDtail.get().addr;
            }
        }.get());

        imageView.setImageDrawable(
                getResources()
                        .getDrawable(
                                getResources()
                                        .getIdentifier(
                                                _this.getPackageName()+":drawable/"+
                                                        (String) new Index.ISupplier() {
                                                            @Override
                                                            public Object get() {
                                                                return itemDtail.get().photo;
                                                            }
                                                        }.get(),
                                                null,
                                                null),
                                _this.getTheme()
                        )
        );
        findViewById(R.id.callBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.dialBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.smsBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.emailBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.albumBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.movieBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.mapBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.musicBtn).setOnClickListener(
                (v)->{}
        );
        findViewById(R.id.updateBtn).setOnClickListener(
                (v)->{
                    Intent intent2 = new Intent(_this, MemberUpdate.class);
                    intent2.putExtra("spec",
                            itemDtail.get().name+","+
                                    itemDtail.get().email+","+
                                    itemDtail.get().phone+","+
                                    itemDtail.get().addr+","+
                                     itemDtail.get().photo
                    );
                    startActivity(intent2);
                });
        findViewById(R.id.listBtn).setOnClickListener(
                (v)-> {
                    startActivity(new Intent(_this, MemberList.class));
                }
        );
    }
    private class MemberDetailQuery extends QueryFactory{
        SQLiteOpenHelper helper;
        public MemberDetailQuery(Context _this) {
            super(_this);
            helper = new SQLiteHelper(_this);
        }

        @Override
        public SQLiteDatabase getDatabase() {
            return helper.getReadableDatabase();
        }
    }
    private class ItemDtail extends MemberDetailQuery{
        String seq;
        public ItemDtail(Context _this) {
            super(_this);
        }
        public Member get(){
            Member member = null;
            Cursor c = this.getDatabase().rawQuery(String.format("" +
                    "SELECT * FROM %s WHERE %s LIKE '%s' ",MEMBERS,MSEQ,seq),
            null);

            if (c != null){
                while (c.moveToNext()){
                    member = new Member();
                    member.seq = Integer.parseInt(c.getString(c.getColumnIndex(MSEQ)));
                    member.name = c.getString(c.getColumnIndex(MNAME));
                    member.email = c.getString(c.getColumnIndex(MEMAIL));
                    member.phone = c.getString(c.getColumnIndex(MPHONE));
                    member.addr = c.getString(c.getColumnIndex(MEMAIL));
                    member.photo = c.getString(c.getColumnIndex(MPHOTO));
                }
            }else {
                Toast.makeText(_this, "등록된 회원이 없음",Toast.LENGTH_LONG).show();
            }
            return member;
        }

    }


}
