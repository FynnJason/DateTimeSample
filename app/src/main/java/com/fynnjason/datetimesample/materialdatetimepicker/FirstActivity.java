package com.fynnjason.datetimesample.materialdatetimepicker;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.fynnjason.datetimesample.R;
import com.fynnjason.datetimesample.databinding.ActivityFirstBinding;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;

public class FirstActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener, View.OnClickListener {
    private TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityFirstBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_first);
        tvShow = binding.tvShow;

        binding.btnDate.setOnClickListener(this);
        binding.btnTime.setOnClickListener(this);
    }

    /*日期*/
    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = "你选择的日期是: " + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日";
        tvShow.setText(date);
    }

    /*时间*/
    @Override
    public void onTimeSet(TimePickerDialog view, int hourOfDay, int minute, int second) {
        String time = "你选择的时间是: " + hourOfDay + "时" + minute + "分" + second + "秒";
        tvShow.setText(time);
    }

    @Override
    public void onClick(View view) {
        Calendar now = Calendar.getInstance();
        switch (view.getId()) {
            case R.id.btn_date:
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "DatePickerDialog");
                break;
            case R.id.btn_time:
                TimePickerDialog tpd = TimePickerDialog.newInstance(
                        this,
                        now.get(Calendar.HOUR_OF_DAY),
                        now.get(Calendar.MINUTE),
                        now.get(Calendar.SECOND),
                        true
                );
                tpd.show(getFragmentManager(), "TimePickerDialog");
                break;
        }
    }
}
