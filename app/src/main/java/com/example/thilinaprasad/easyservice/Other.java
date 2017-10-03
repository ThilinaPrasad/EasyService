package com.example.thilinaprasad.easyservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Thilina Prasad on 10/1/2017.
 */

public class Other extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.other, container, false);
        Button balanceBtn = (Button)rootView.findViewById(R.id.balanceBtn);
        Button loanBtn = (Button)rootView.findViewById(R.id.loanBtn);
        Button myInfoBtn = (Button)rootView.findViewById(R.id.myInfoBtn);
        Button customerCareBtn = (Button)rootView.findViewById(R.id.customerCareBtn);
        balanceBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+"*100"+Uri.encode("#")));
                startActivity(intent);
                Toast.makeText(getActivity(),"Request Sent !",Toast.LENGTH_SHORT).show();
            }
        });

        loanBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You want to activate a Smart Loan ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:"+Uri.encode("#")+"247"+Uri.encode("#")));
                        startActivity(intent);
                        Toast.makeText(getActivity(),"Request Sent !",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        myInfoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+Uri.encode("#")+"132"+Uri.encode("#")));
                startActivity(intent);
                Toast.makeText(getActivity(),"Request Sent !",Toast.LENGTH_SHORT).show();
            }
        });

        customerCareBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+"141"));
                startActivity(intent);
            }
        });

        return rootView;
    }
}
