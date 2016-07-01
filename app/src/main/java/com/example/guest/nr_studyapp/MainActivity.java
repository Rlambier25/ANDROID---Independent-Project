package com.example.guest.nr_studyapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
//    @Bind(R.id.logInButton) Button mLogInButton;
    @Bind(R.id. appNameTextView) TextView mAppNameTextView;
    @Bind(R.id.aboutButton) Button mAboutButton;
//    @Bind(R.id.flashCardButton) Button mFlashCardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface captureFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it.ttf");
        mAppNameTextView.setTypeface(captureFont);

        mAboutButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == mAboutButton) {
            Toast.makeText(MainActivity.this, "Hey there lil fella!", Toast.LENGTH_LONG).show();
        }
    }
}
