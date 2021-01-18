package com.hansoft.trysendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextPhoneNumber;
    private EditText editTextMessage;
    private boolean success;
    private boolean fail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextPhoneNumber = (EditText)this.findViewById(R.id.editTextPhoneNumber);
        editTextMessage = (EditText)this.findViewById(R.id.editTextMessage);

    }

    public void sendsms(View view)
    {
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String message = editTextMessage.getText().toString();
        if ((phoneNumber != "") && (message != ""))
        {
            SendSMSTo(phoneNumber, message);
        }
    }

    public void SendSMSTo(String phoneNumber,String message){

        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){

            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+phoneNumber));
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }
    }
}