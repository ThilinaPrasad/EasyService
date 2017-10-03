package com.example.thilinaprasad.easyservice;

/**
 * Created by Thilina Prasad on 10/1/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TopUp extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.topup, container, false);

        Button topupBtn = (Button)rootView.findViewById(R.id.topupbtn);
        final EditText topuppin = (EditText) rootView.findViewById(R.id.topuppin);

        topupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String pin = topuppin.getText().toString();
                if(pin.length()==14 && pin.matches("[0-9]+")) {
                    String diallerNum = "*102*" + pin + Uri.encode("#");
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + diallerNum));
                    startActivity(intent);
                }else{
                    Toast.makeText(getActivity(),"Invalid top up pin number !",Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}
