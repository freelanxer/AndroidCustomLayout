package com.example.androidcustomlayout.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.androidcustomlayout.R;
import com.example.androidcustomlayout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.function_01:
                Toast.makeText(this, R.string.func_01, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_02:
                Toast.makeText(this, R.string.func_02, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_03:
                Toast.makeText(this, R.string.func_03, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_04:
                Toast.makeText(this, R.string.func_04, Toast.LENGTH_SHORT).show();
                break;
            case R.id.function_05:
                Toast.makeText(this, R.string.func_05, Toast.LENGTH_SHORT).show();
                break;
        }
    }

}