package com.example.mguimaraes.maxmilhas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mguimaraes.maxmilhas.Fragments.OutboundFragment;
import com.example.mguimaraes.maxmilhas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FilterActivity extends AppCompatActivity {

    @BindView(R.id.morning_check)
    CheckBox morningCheck;
    @BindView(R.id.afternoon_check)
    CheckBox afternoonCheck;
    @BindView(R.id.evening_check)
    CheckBox eveningCheck;
    @BindView(R.id.late_night_check)
    CheckBox lateNightCheck;
    @BindView(R.id.straight_flight_check)
    CheckBox straightFlightCheck;
    @BindView(R.id.one_stop_check)
    CheckBox oneStopCheck;
    @BindView(R.id.apply_filter_button)
    Button applyFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ImageView backButton = (ImageView) toolbar.findViewById(R.id.back_arrow);
        TextView cleanFilters = (TextView) toolbar.findViewById(R.id.clean);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        cleanFilters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendBackFilterData(true);
            }
        });

        morningCheck.setChecked(Boolean.parseBoolean(OutboundFragment.morningCheck));
        afternoonCheck.setChecked(Boolean.parseBoolean(OutboundFragment.afternoonCheck));
        eveningCheck.setChecked(Boolean.parseBoolean(OutboundFragment.eveningCheck));
        lateNightCheck.setChecked(Boolean.parseBoolean(OutboundFragment.lateNightCheck));
        straightFlightCheck.setChecked(Boolean.parseBoolean(OutboundFragment.straightFlightCheck));
        oneStopCheck.setChecked(Boolean.parseBoolean(OutboundFragment.oneStopCheck));
    }

    @OnClick(R.id.apply_filter_button)
    public void applyFilter() {
        sendBackFilterData(false);
    }

    public void sendBackFilterData(Boolean clean) {
        Intent intent = getIntent();
        intent.putExtra("morning", String.valueOf(morningCheck.isChecked()));
        intent.putExtra("afternoon", String.valueOf(afternoonCheck.isChecked()));
        intent.putExtra("evening", String.valueOf(eveningCheck.isChecked()));
        intent.putExtra("lateNight", String.valueOf(lateNightCheck.isChecked()));
        intent.putExtra("straight", String.valueOf(straightFlightCheck.isChecked()));
        intent.putExtra("oneStop", String.valueOf(oneStopCheck.isChecked()));
        if (clean) {
            intent.putExtra("isClean", String.valueOf(clean));
        } else {
            intent.putExtra("isClean", "false");
        }

        setResult(RESULT_OK, intent);
        finish();
    }

}
