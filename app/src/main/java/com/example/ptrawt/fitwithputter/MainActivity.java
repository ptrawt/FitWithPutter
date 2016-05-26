package com.example.ptrawt.fitwithputter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import app.akexorcist.bluetotohspp.library.BluetoothSPP;
import app.akexorcist.bluetotohspp.library.BluetoothState;
import app.akexorcist.bluetotohspp.library.DeviceList;

public class MainActivity extends AppCompatActivity {
    BluetoothSPP bt = new BluetoothSPP(this);
    Button btnChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChoose = (Button) findViewById(R.id.btnChoose);
        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DeviceList.class);
                startActivityForResult(intent, BluetoothState.REQUEST_CONNECT_DEVICE);
            }
        });

    }

    public void onStart() {
        super.onStart();
        if(!bt.isBluetoothEnabled()) {
            Toast.makeText(this, "Bluetooth is not connected.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bluetooth is connected.", Toast.LENGTH_SHORT).show();
        }
    }
}
