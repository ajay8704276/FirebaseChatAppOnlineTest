package com.app.infi.corp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.infi.corp.R;
import com.app.infi.corp.UIActivity.ChatActivity;
import com.app.infi.corp.model.Contacts;

import java.util.List;

/**
 * Created by adyro on 19-02-2017.
 */

public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ContactViewHoler> {

    List<Contacts> mContactsList;
    private Context mContext;
    public static final String CONTACT_NAME = "CONTACT_NAME";
    public static final String CONTACT_NUMBER = "CONTACT_NUMBER";

    @Override
    public ContactViewHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_item_cardview,parent,false);
        return new ContactViewHoler(view);
    }

    @Override
    public void onBindViewHolder(ContactViewHoler holder, final int position) {

        holder.mContactNumber.setText(mContactsList.get(position).getContactNumber());
        holder.mContactName.setText(mContactsList.get(position).getContactName());
        holder.mContactCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start activity here for chat
                Intent intent = new Intent(mContext, ChatActivity.class);
                intent.putExtra(CONTACT_NAME ,mContactsList.get(position).getContactName());
                intent.putExtra(CONTACT_NUMBER,mContactsList.get(position).getContactNumber());
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mContactsList.size();
    }

    public class ContactViewHoler extends RecyclerView.ViewHolder {

        private TextView mContactName;
        private TextView mContactNumber;
        private CardView mContactCardView;

        public ContactViewHoler(View itemView) {
            super(itemView);

            mContactName = (TextView) itemView.findViewById(R.id.contact_name);
            mContactNumber = (TextView) itemView.findViewById(R.id.contact_number);
            mContactCardView = (CardView) itemView.findViewById(R.id.contact_cardview);
        }
    }

    public ContactListAdapter(List<Contacts> mContactsList, Context mContext){
        this.mContactsList = mContactsList;
        this.mContext = mContext;
    }
}
