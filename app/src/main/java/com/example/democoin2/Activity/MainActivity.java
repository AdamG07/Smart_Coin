package com.example.democoin2.Activity;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.constraintlayout.widget.ConstraintLayout;
////import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.democoin2.R;

//import java.lang.reflect.Array;
//import java.util.ArrayList;
import android.view.View;
//import android.widget.Toast;

//import BluetoothConnect.BluetoothCon;
//import Connect_SQL.Connection;
//import Domain.Category;

public class MainActivity extends AppCompatActivity {

    LinearLayout notificationBtn;
//    ConstraintLayout constraintLayout;
//    private BluetoothCon bluetoothCon;
//    private RecyclerView.Adapter adapter;
//    private RecyclerView recyclerViewCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationBtn = findViewById(R.id.notificationBtn);
        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
            }
        });

//        bluetoothCon = new BluetoothCon("9D:DA:50:02:C3:CE");
//        bluetoothCon.connect();
//
//        constraintLayout.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                bluetoothCon.sendData("1");
//                Toast.makeText(getBaseContext(), "Подключение устройства", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        bluetoothCon.disconnect();
    }
}