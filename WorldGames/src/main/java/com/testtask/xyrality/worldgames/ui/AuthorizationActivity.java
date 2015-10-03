package com.testtask.xyrality.worldgames.ui;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.EditText;
import com.testtask.xyrality.worldgames.R;

/**
 * Created by Olena Bezuhla(jewelsalenka@gmail.com) on 10/3/15 12:08 PM .
 */
public class AuthorizationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authorization_layout);
        View button = findViewById(R.id.button_sign_in);
        final EditText email = (EditText) findViewById(R.id.email);
        final EditText pass = (EditText) findViewById(R.id.pass);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String emailText = extras.getString(GamesActivity.EMAIL_KEY);
            String passText = extras.getString(GamesActivity.PASS_KEY);
            email.setText(emailText);
            pass.setText(passText);
        }
        final View error = findViewById(R.id.connection_error);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailText = email.getText().toString();
                String passText = pass.getText().toString();
                if (isNetworkConnected()){
                    error.setVisibility(View.GONE);
                    Intent intent = new Intent(AuthorizationActivity.this, GamesActivity.class);
                    intent.putExtra(GamesActivity.EMAIL_KEY, emailText);
                    intent.putExtra(GamesActivity.PASS_KEY, passText);
                    startActivity(intent);
                } else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return (!(ni == null));
    }
}
