package com.example.testapp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import com.example.testapp.R;
import com.example.testapp.databinding.ActivityJoystickBinding;
import com.example.testapp.viewModel.ConcreteViewModel;

// This is the app basically. It uses the activity_joystick.xml layout
public class JoystickActivity extends AppCompatActivity {

    private ConcreteViewModel VM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // data binding
        ActivityJoystickBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joystick);
        VM = new ConcreteViewModel();
        binding.setViewModel(VM);
        binding.executePendingBindings();

        // get joystick and inject operations to joystick
        Joystick joystick = findViewById(R.id.joystickView);

        // inject behavior to joystick
        joystick.setEA=(a, e)->{
            VM.setAileron(a);
            VM.setElevator(e);
        };
    }

}