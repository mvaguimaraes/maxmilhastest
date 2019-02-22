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

import com.example.mguimaraes.maxmilhas.Fragments.InboundFragment;
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
    @BindView(R.id.morning_qty)
    TextView morningQty;
    @BindView(R.id.afternoon_qty)
    TextView afternoonQty;
    @BindView(R.id.evening_qty)
    TextView eveningQty;
    @BindView(R.id.late_night_qty)
    TextView lateNightQty;
    @BindView(R.id.straight_flight_qty)
    TextView straightFlightQty;
    @BindView(R.id.one_stop_qty)
    TextView oneStopQty;

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

        setUpLayout();
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

    private void setUpLayout() {
        if (OutboundFragment.comingFromHere != null) {
            if (OutboundFragment.comingFromHere) {
                morningCheck.setChecked(Boolean.parseBoolean(OutboundFragment.morningCheck));
                afternoonCheck.setChecked(Boolean.parseBoolean(OutboundFragment.afternoonCheck));
                eveningCheck.setChecked(Boolean.parseBoolean(OutboundFragment.eveningCheck));
                lateNightCheck.setChecked(Boolean.parseBoolean(OutboundFragment.lateNightCheck));
                straightFlightCheck.setChecked(Boolean.parseBoolean(OutboundFragment.straightFlightCheck));
                oneStopCheck.setChecked(Boolean.parseBoolean(OutboundFragment.oneStopCheck));
                morningQty.setText(OutboundFragment.qtMorning == 1 ? " (" + Integer.toString(OutboundFragment.qtMorning) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtMorning) + " VOOS)");
                afternoonQty.setText(OutboundFragment.qtAfternoon == 1 ? " (" + Integer.toString(OutboundFragment.qtAfternoon) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtAfternoon) + " VOOS)");
                eveningQty.setText(OutboundFragment.qtEvening == 1 ? " (" + Integer.toString(OutboundFragment.qtEvening) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtEvening) + " VOOS)");
                lateNightQty.setText(OutboundFragment.qtLateNight == 1 ? " (" + Integer.toString(OutboundFragment.qtLateNight) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtLateNight) + " VOOS)");
                straightFlightQty.setText(OutboundFragment.qtStraight == 1 ? " (" + Integer.toString(OutboundFragment.qtStraight) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtStraight) + " VOOS)");
                oneStopQty.setText(OutboundFragment.qtOneStop == 1 ? " (" + Integer.toString(OutboundFragment.qtOneStop) + " VOO)" : "(" + Integer.toString(OutboundFragment.qtOneStop) + " VOOS)");

            }
        }
        if (InboundFragment.comingFromHere != null) {
            if (InboundFragment.comingFromHere) {
                morningCheck.setChecked(Boolean.parseBoolean(InboundFragment.morningCheck));
                afternoonCheck.setChecked(Boolean.parseBoolean(InboundFragment.afternoonCheck));
                eveningCheck.setChecked(Boolean.parseBoolean(InboundFragment.eveningCheck));
                lateNightCheck.setChecked(Boolean.parseBoolean(InboundFragment.lateNightCheck));
                straightFlightCheck.setChecked(Boolean.parseBoolean(InboundFragment.straightFlightCheck));
                oneStopCheck.setChecked(Boolean.parseBoolean(InboundFragment.oneStopCheck));
                morningQty.setText(InboundFragment.qtMorning == 1 ? " (" + Integer.toString(InboundFragment.qtMorning) + " VOO)" : "(" + Integer.toString(InboundFragment.qtMorning) + " VOOS)");
                afternoonQty.setText(InboundFragment.qtAfternoon == 1 ? " (" + Integer.toString(InboundFragment.qtAfternoon) + " VOO)" : "(" + Integer.toString(InboundFragment.qtAfternoon) + " VOOS)");
                eveningQty.setText(InboundFragment.qtEvening == 1 ? " (" + Integer.toString(InboundFragment.qtEvening) + " VOO)" : "(" + Integer.toString(InboundFragment.qtEvening) + " VOOS)");
                lateNightQty.setText(InboundFragment.qtLateNight == 1 ? " (" + Integer.toString(InboundFragment.qtLateNight) + " VOO)" : "(" + Integer.toString(InboundFragment.qtLateNight) + " VOOS)");
                straightFlightQty.setText(InboundFragment.qtStraight == 1 ? " (" + Integer.toString(InboundFragment.qtStraight) + " VOO)" : "(" + Integer.toString(InboundFragment.qtStraight) + " VOOS)");
                oneStopQty.setText(InboundFragment.qtOneStop == 1 ? " (" + Integer.toString(InboundFragment.qtOneStop) + " VOO)" : "(" + Integer.toString(InboundFragment.qtOneStop) + " VOOS)");
            }
        }
    }

}
