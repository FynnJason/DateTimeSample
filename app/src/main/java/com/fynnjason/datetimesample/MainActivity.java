package com.fynnjason.datetimesample;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.fynnjason.datetimesample.databinding.ActivityMainBinding;
import com.fynnjason.datetimesample.materialdatetimepicker.FirstActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setClick(new ClickPresenter());
    }

    public class ClickPresenter {
        Intent intent = new Intent();

        private void startActivity(Class<?> cls) {
            intent.setClass(MainActivity.this, cls);
            MainActivity.this.startActivity(intent);
        }

        public void MaterialDateTimePickerClick() {
            startActivity(FirstActivity.class);
        }

    }

}
