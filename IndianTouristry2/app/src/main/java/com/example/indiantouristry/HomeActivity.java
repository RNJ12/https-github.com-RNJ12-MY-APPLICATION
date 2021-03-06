package com.example.indiantouristry;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.indiantouristry.databinding.ActivityHomeBinding;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth auth;
    ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);
        auth = FirebaseAuth.getInstance();
        binding.textView.setText("Welcome "+auth.getCurrentUser().getEmail());
    }

    public void signout(View view) {
        auth.signOut();
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}