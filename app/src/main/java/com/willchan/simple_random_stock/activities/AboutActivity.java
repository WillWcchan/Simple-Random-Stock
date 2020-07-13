package com.willchan.simple_random_stock.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.willchan.simple_random_stock.R;

public class AboutActivity extends AppCompatActivity {
    private final String MAILTO = "mailto:";
    private final String TYPE = "text/plain";
    private final String SUBJECT = "Greetings Will from Simple-Random-Stock";
    private final String CHOOSE_MAIL_APP = "Choose Mail App";
    private final String NO_EMAIL_CLIENT_INSTALLED = "There is no email client installed.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Source: https://developer.android.com/training/appbar/up-action
        Toolbar toolBar = findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        // Get a support Actionbar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up Button
        if (ab != null) {
            try {
                ab.setDisplayHomeAsUpEnabled(true);
            } catch (NullPointerException e) {
                Log.e(AboutActivity.this.getLocalClassName(), "Unable to set Up Action");
            }
        }
    }

    // Source: https://www.tutorialspoint.com/android/android_sending_email.htm#:~:text=Intent%20Object%20-%20Extra%20to%20send%20Email%20,that%20i%20...%20%203%20more%20rows%20
    // Email link in the About Activity was clicked
    @SuppressLint("all")
    public void sendEmail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType(TYPE);
        emailIntent.setData(Uri.parse(MAILTO));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, SUBJECT);
        try {
            startActivity(Intent.createChooser(emailIntent, CHOOSE_MAIL_APP));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, NO_EMAIL_CLIENT_INSTALLED, Toast.LENGTH_SHORT).show();
        }
    }
}
