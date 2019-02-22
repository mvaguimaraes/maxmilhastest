package com.example.mguimaraes.maxmilhas.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.example.mguimaraes.maxmilhas.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SortActivity extends AppCompatActivity {

    @BindView(R.id.myRadioGroup)
    RadioGroup radioGroup;
    private int returnValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);
        ButterKnife.setDebug(true);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        ImageView backButton = (ImageView) toolbar.findViewById(R.id.back_arrow);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.greatestPrice) {
                    returnValue = 0;
                } else if (checkedId == R.id.cheapest) {
                    returnValue = 1;
                } else {
                    returnValue = 2;
                }
            }
        });
    }

    @OnClick(R.id.apply_sorting_button)
    public void sortList() {
        Intent intent = getIntent();
        intent.putExtra("sortingOption", Integer.toString(returnValue));
        setResult(RESULT_OK, intent);
        finish();
    }

}
