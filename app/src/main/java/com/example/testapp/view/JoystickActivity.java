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

public class JoystickActivity extends AppCompatActivity {

    private double throttle;
    private double elevator;
    private double aileron;
    private double rudder;
    private ConcreteViewModel VM;
    private Joystick view;

    @BindingAdapter({"toastMessage"})
    public static void runMe(View view, String message) {
        Log.d("myTag", "runme message");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // add view
//        Joystick joystick = new Joystick(this).build();
//        Joystick joystick = new Joystick(this, attrs);


        // data binding
        ActivityJoystickBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_joystick);
        VM = new ConcreteViewModel();
        VM.runModel();
        binding.setViewModel(VM);
        binding.executePendingBindings();

        view = new Joystick(this);
        setContentView(view);
    }

}