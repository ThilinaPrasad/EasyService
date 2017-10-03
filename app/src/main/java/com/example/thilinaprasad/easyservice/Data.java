package com.example.thilinaprasad.easyservice;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Thilina Prasad on 10/1/2017.
 */

public class Data extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.data, container, false);
        final String dataNum = "7678";
         Button day1 = (Button)rootView.findViewById(R.id.dataBtn1);
        Button day3 = (Button)rootView.findViewById(R.id.dataBtn2);
        Button day7 = (Button)rootView.findViewById(R.id.dataBtn3);
        Button day21 = (Button)rootView.findViewById(R.id.dataBtn4);

        day1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You want to activate 25MB/Rs.5 1Day data package ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendSms(dataNum, "D5");
                        Toast.makeText(getActivity(), "25MB/1Day data Package Activated !", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "Cost is Rs.5.00", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        day3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You want to activate 80MB/Rs.29 3Day data package ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendSms(dataNum, "D29");
                        Toast.makeText(getActivity(), "80MB/3Day Package Activated !", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "Cost is Rs.29.00", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        day7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You want to activate 200MB/Rs.49 7Day data package ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendSms(dataNum, "D49");
                        Toast.makeText(getActivity(), "200MB/7Day Package Activated !", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "Cost is Rs.49.00", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        day21.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("You want to activate 400MB/Rs.99 21Day data package ?").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sendSms(dataNum, "D99");
                        Toast.makeText(getActivity(), "400MB/21Day Package Activated !", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "Cost is Rs.99.00", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("No", null);
                AlertDialog alert = builder.create();
                alert.show();


            }
        });

        return rootView;
    }

     void sendSms(String num,String msg){
        try{
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(num,null,msg,null,null);
        }catch (Exception e){}
    }



}
