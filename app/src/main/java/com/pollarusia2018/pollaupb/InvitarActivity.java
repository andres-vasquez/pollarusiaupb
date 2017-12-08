package com.pollarusia2018.pollaupb;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.pollarusia2018.pollaupb.adapters.InvitarAdapter;
import com.pollarusia2018.pollaupb.models.Contacto;

public class InvitarActivity extends AppCompatActivity {

    private static final String LOG = InvitarActivity.class.getSimpleName();

    private RecyclerView invitarRecyclerView;
    private InvitarAdapter invitarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitar);

        invitarRecyclerView = findViewById(R.id.invitarRecyclerView);
        invitarRecyclerView.setHasFixedSize(true);
        invitarRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        invitarAdapter = new InvitarAdapter(this);
        invitarRecyclerView.setAdapter(invitarAdapter);

        getContacts();
    }

    public void getContacts() {
        ContentResolver cr = getContentResolver();
        Cursor cur = cr.query(ContactsContract.Contacts.CONTENT_URI,
                null, null, null, null);

        invitarAdapter.clear();

        if ((cur != null ? cur.getCount() : 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                String id = cur.getString(
                        cur.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cur.getString(cur.getColumnIndex(
                        ContactsContract.Contacts.DISPLAY_NAME));

                if (cur.getInt(cur.getColumnIndex(
                        ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    Cursor pCur = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                            null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                            new String[]{id}, null);
                    while (pCur.moveToNext()) {
                        String phoneNo = pCur.getString(pCur.getColumnIndex(
                                ContactsContract.CommonDataKinds.Phone.NUMBER));
                        //Log.i(LOG, "Name: " + name);
                        //Log.i(LOG, "Phone Number: " + phoneNo);
                        invitarAdapter.addContact(new Contacto(name, phoneNo));
                    }
                    pCur.close();
                }
            }
        }
        if(cur!=null){
            cur.close();
        }
    }
}
