package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModel;

import android.os.Bundle;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;


import java.io.Serializable;
import java.net.Inet6Address;
import java.net.InetAddress;

import com.example.testapp.R;
import com.example.testapp.model.ConcreteModel;
import com.example.testapp.viewModel.AbstractViewModel;
import com.example.testapp.viewModel.ConcreteViewModel;


public class MainActivity extends AppCompatActivity {

//    AbstractViewModel VM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
//        VM = new ConcreteViewModel();

        /*
        try {
            InetAddress ip = InetAddress.getByAddress(
                    new byte[]{(byte) 192, (byte) 168, (byte) 2, (byte) 107});
            //Inet6Address ips = In

            ConcreteModel model = new ConcreteModel(ip, 5400);
            model.connectToServer();
        } catch(Exception e)
        {

        }

         */
    }

    @Override
    protected void onStart() {
        super.onStart();
//        ConcreteViewModel vm = new ConcreteViewModel();
//        vm.runModel();
        Intent intent = new Intent(this, JoystickActivity.class);
//        intent.putExtra("ViewModel", (Serializable) VM);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, JoystickActivity.class);
//        intent.putExtra("ViewModel", (Serializable) VM);
        startActivity(intent);
    }


}