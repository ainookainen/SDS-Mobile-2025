package com.example.sds2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sds2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.SecondActivityButton.setOnClickListener(v -> {
            Intent startIntent = new Intent(getApplicationContext(), SecondActivity.class);
            startIntent.putExtra("com.example.sds2.SOMETHING","HELLO WORLD!");
            startActivity(startIntent);
        });
        binding.GoogleButton.setOnClickListener(v -> {
            String google = "http://www.google.com";
            Uri webAddress = Uri.parse(google);
            Intent goToGoogle = new Intent(Intent.ACTION_VIEW,webAddress);
            if (goToGoogle.resolveActivity(getPackageManager())!=null){
                startActivity(goToGoogle);
            } else {
                Log.d("tagi", "on null");
            }
        });

    }
}