package com.example.user.drinkit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ActivityPay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        txtBills = findViewById(R.id.txtBills);


        //取的intent中的bundle物件
        Bundle bundle =this.getIntent().getExtras();

        String total = bundle.getString("total");
        txtBills.setText(total);

    }

    public void Ok(){
        Intent intent = new Intent(ActivityPay.this, ActivityMain.class);
        ActivityPay.this.setResult(RESULT_OK, intent);
        ActivityPay.this.finish();
    }

    public void Cancel(){
        Intent intent = new Intent(ActivityPay.this, ActivityMain.class);
        ActivityPay.this.setResult(RESULT_CANCELED, intent);
        ActivityPay.this.finish();
    }
    TextView txtBills;
}
