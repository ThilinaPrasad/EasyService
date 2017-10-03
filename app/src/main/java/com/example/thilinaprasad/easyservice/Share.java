package com.example.thilinaprasad.easyservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Thilina Prasad on 10/1/2017./
 */

public class Share extends Fragment {
    String num, amount;
    EditText shareNum, shareAmount;
    TextView contactName;
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.share, container, false);
        Button shareBtn = (Button) rootView.findViewById(R.id.shareBtn);
        Button contactBtn = (Button) rootView.findViewById(R.id.contactBtn);
        shareNum = (EditText) rootView.findViewById(R.id.shareNum);
        shareAmount = (EditText) rootView.findViewById(R.id.shareAmount);
        contactName = (TextView) rootView.findViewById(R.id.contactName);

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = shareNum.getText().toString();
                amount = shareAmount.getText().toString();
                boolean numCheck = false;
                boolean amountCheck = false;
                if (num.length() == 10 && num.matches("[0-9]+")) {
                    numCheck = true;
                } else {
                    numCheck = false;
                    Toast.makeText(getActivity(), "Invalid mobile number!", Toast.LENGTH_SHORT).show();
                }
                int amountInt = 0;
                try {
                    amountInt = Integer.parseInt(amount);
                } catch (Exception e) {
                    Toast.makeText(getActivity(), "Invalid amount!", Toast.LENGTH_SHORT).show();
                }

                if (amountInt >= 10 && amountInt <= 500) {
                    amountCheck = true;
                } else {
                    amountCheck = false;
                    Toast.makeText(getActivity(), "Your amount must between Rs.10.00 - Rs.500.00 !", Toast.LENGTH_LONG).show();
                }
                if (numCheck && amountCheck) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    builder.setMessage("You want to share Rs." + amount + " to " + num + " ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String dilingNum = "*448*" + num + "*" + amount + Uri.encode("#");
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            intent.setData(Uri.parse("tel:" + dilingNum));
                            startActivity(intent);
                        }
                    }).setNegativeButton("No", null);
                    AlertDialog alert = builder.create();
                    alert.show();
                }

            }
        });


        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                startActivityForResult(intent, 1);
            }
        });

        return rootView;

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == MainActivity.RESULT_OK){
                Uri contactData = data.getData();
                Cursor cursor =  getActivity().managedQuery(contactData, null, null, null, null);
                cursor.moveToFirst();

                String number =       cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER));
                String name =       cursor.getString(cursor.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                contactName.setText(name);
                shareNum.setText(number);
                //contactEmail.setText(email);
            }
        }
    }
}

