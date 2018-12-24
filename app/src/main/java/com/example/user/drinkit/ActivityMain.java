package com.example.user.drinkit;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityMain extends AppCompatActivity {

    private View.OnClickListener btnMilktea_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
             img1.setImageResource(R.drawable.milktea);
             txtPrice.setText("NT$75");

        }
    };
    private View.OnClickListener btnLatte_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            img1.setImageResource(R.drawable.latte);
            txtPrice.setText("NT$95");
        }
    };
    private View.OnClickListener btnMless_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int countM = Integer.valueOf(txtMcount.getText().toString());

            if(countM==0){
                txtMcount.setText("0");
                Toast.makeText(ActivityMain.this, "數量底限:  0", Toast.LENGTH_SHORT).show();
            }else {
                txtMcount.setText(String.valueOf(countM-1));
                subM = M * Integer.parseInt(txtMcount.getText().toString());
                txtMilkteaSub.setText(String.valueOf(subM));
                Toast.makeText(ActivityMain.this, "數量-1", Toast.LENGTH_SHORT).show();

            }
            CheckTotal();
        }
    };
    private View.OnClickListener btnMadd_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int countM = Integer.parseInt(txtMcount.getText().toString());

            if((countM>=0) && (countM<10)){
                txtMcount.setText(String.valueOf(countM+1));
                subM = M* Integer.parseInt(txtMcount.getText().toString());
                txtMilkteaSub.setText(String.valueOf(subM));
                Toast.makeText(ActivityMain.this, "數量+1", Toast.LENGTH_SHORT).show();
            }
            if(countM==10){
                txtMcount.setText(String.valueOf(countM+0));
                subM = M* Integer.parseInt(txtMcount.getText().toString());
                Toast.makeText(ActivityMain.this, "數量上限: 10", Toast.LENGTH_SHORT).show();
            }
            CheckTotal();
        }
    };

    private View.OnClickListener btnLless_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int countL = Integer.valueOf(txtLcount.getText().toString());

            if(countL==0){
                txtLcount.setText("0");
                Toast.makeText(ActivityMain.this, "數量底限:  0", Toast.LENGTH_SHORT).show();
            }else {
                txtLcount.setText(String.valueOf(countL-1));
                subL = L * Integer.parseInt(txtLcount.getText().toString());
                txtLatteSub.setText(String.valueOf(subL));
                Toast.makeText(ActivityMain.this, "數量-1", Toast.LENGTH_SHORT).show();

            }
            CheckTotal();
        }
    };
    private View.OnClickListener btnLadd_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int countL = Integer.parseInt(txtLcount.getText().toString());

            if((countL>=0) && (countL<10)){
                txtLcount.setText(String.valueOf(countL+1));
                subL = L* Integer.parseInt(txtLcount.getText().toString());
                txtLatteSub.setText(String.valueOf(subL));
                Toast.makeText(ActivityMain.this, "數量+1", Toast.LENGTH_SHORT).show();
            }
            if(countL==10){
                txtLcount.setText(String.valueOf(countL+0));
                Toast.makeText(ActivityMain.this, "數量上限: 10", Toast.LENGTH_SHORT).show();
            }
            CheckTotal();
        }
    };
    private View.OnClickListener btnPay_click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showNormalDialog();
//            //new一個intent物件，並指定Activity切換的class
//            Intent intent = new Intent(ActivityMain.this, ActivityPay.class);
//
//            //new一個Bundle物件，並將要傳遞的資料傳入
//            Bundle bundle = new Bundle();
//            bundle.putString("total",txtTotal.getText().toString() );
//
//            //將Bundle物件assign給intent
//            intent.putExtras(bundle);
//
//            //切換Activity
//            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        InitialComponent();

    }

    private void showNormalDialog(){
        final AlertDialog.Builder payDialog = new AlertDialog.Builder(ActivityMain.this);
        payDialog.setTitle("確認付款");
        payDialog.setMessage("訂單總額 NT$" + txtTotal.getText().toString());
        payDialog.setPositiveButton("確定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtMcount.setText("0");
                        txtMilkteaSub.setText("0");
                        txtLcount.setText("0");
                        txtLatteSub.setText("0");
                        txtTotal.setText("0");

                    }
                });
        payDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtMcount.setText("0");
                        txtMilkteaSub.setText("0");
                        txtLcount.setText("0");
                        txtLatteSub.setText("0");
                        txtTotal.setText("0");

                    }
                });
        // 顯示
        payDialog.show();
    }

    private void CheckTotal() {
        subM = Integer.valueOf(txtMilkteaSub.getText().toString());
        subL = Integer.valueOf(txtLatteSub.getText().toString());
        total = subM + subL;
        txtTotal.setText(String.valueOf(total));
    }

    private void InitialComponent() {
        btnMilktea = findViewById(R.id.btnMilktea);
        btnMilktea.setOnClickListener(btnMilktea_click);
        btnMless = findViewById(R.id.btnMless);
        btnMless.setOnClickListener(btnMless_click);
        btnMadd = findViewById(R.id.btnMadd);
        btnMadd.setOnClickListener(btnMadd_click);
        txtMcount = findViewById(R.id.txtMcount);
        txtMilkteaSub = findViewById(R.id.txtMilkteaSub);

        btnLatte = findViewById(R.id.btnLatte);
        btnLatte.setOnClickListener(btnLatte_click);
        btnLless = findViewById(R.id.btnLless);
        btnLless.setOnClickListener(btnLless_click);
        btnLadd = findViewById(R.id.btnLadd);
        btnLadd.setOnClickListener(btnLadd_click);
        txtLcount = findViewById(R.id.txtLcount);
        txtLatteSub = findViewById(R.id.txtLatteSub);

        txtTotal = findViewById(R.id.txtTotal);
        img1 = findViewById(R.id.img1);
        txtPrice = findViewById(R.id.txtPrice);
        btnPay = findViewById(R.id.btnPay);
        btnPay.setOnClickListener(btnPay_click);

    }



    Button btnMilktea, btnLatte;
    Button btnMless, btnMadd;
    TextView txtMilkteaSub;
    TextView txtMcount;
    Button btnLless, btnLadd;
    TextView txtLatteSub;
    TextView txtLcount;

    TextView txtTotal;
    ImageView img1;
    TextView txtPrice;
    Button btnPay;
    int M = 75;
    int L = 95;
    int subM, subL, total;

}
