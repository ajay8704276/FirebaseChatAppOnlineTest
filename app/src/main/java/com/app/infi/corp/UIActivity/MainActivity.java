package com.app.infi.corp.UIActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.infi.corp.R;
import com.app.infi.corp.adapter.ContactListAdapter;
import com.app.infi.corp.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mContactRecyclerView;
    private List<Contacts> mContactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

    }

    private void initUI() {
        mContactRecyclerView = (RecyclerView) findViewById(R.id.contacts_recyclerview);
        mContactRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mContactRecyclerView.hasFixedSize();

        retrieveAllContacts(this.getContentResolver());
    }

    private  void retrieveAllContacts(ContentResolver cr) {

        mContactsList = new ArrayList<>();
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (phones.moveToNext()) {
            String contactName = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Contacts mContacts = new Contacts(contactName, phoneNumber);
            mContactsList.add(mContacts);
        }


        ContactListAdapter mContactListAdapter = new ContactListAdapter(mContactsList, this);
        mContactRecyclerView.setAdapter(mContactListAdapter);
        phones.close();// close cursor
    }
}
