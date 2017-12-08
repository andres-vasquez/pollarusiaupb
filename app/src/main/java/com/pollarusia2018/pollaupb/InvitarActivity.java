package com.pollarusia2018.pollaupb;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

import com.pollarusia2018.pollaupb.adapters.InvitarAdapter;
import com.pollarusia2018.pollaupb.models.Contacto;
import com.pollarusia2018.pollaupb.models.OnContactClickListener;

public class InvitarActivity extends AppCompatActivity {

    private static final String LOG = InvitarActivity.class.getSimpleName();
    private Context context;

    private RecyclerView invitarRecyclerView;
    private InvitarAdapter invitarAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitar);
        context = this;

        invitarRecyclerView = findViewById(R.id.invitarRecyclerView);
        invitarRecyclerView.setHasFixedSize(true);
        invitarRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        invitarAdapter = new InvitarAdapter(this);
        invitarRecyclerView.setAdapter(invitarAdapter);
        invitarAdapter.setOnContactClickListener(new OnContactClickListener() {
            @Override
            public void onContactClick(Contacto contacto) {
                Toast.makeText(context,contacto.getNombre()+" "+contacto.getNumero(),Toast.LENGTH_SHORT).show();
                String mensaje = "Ven y participa de la Polla Rusia 2018 que estoy organizando, por favor";

                /*Uri uri = Uri.parse("smsto:"+contacto.getNumero());
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
                it.putExtra("sms_body", mensaje);
                startActivity(it);*/

                //sendSMS(contacto.getNumero(),mensaje);
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
                try {
                    startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Log.e(LOG,"Whatsapp no instalado.");
                }
            }
        });

        getContacts();
    }

    public void sendSMS(String phoneNo, String msg) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
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
