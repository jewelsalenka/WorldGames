package com.testtask.xyrality.worldgames.ui;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import com.testtask.xyrality.worldgames.R;
import com.testtask.xyrality.worldgames.rest.RestClient;
import com.testtask.xyrality.worldgames.rest.model.WorldsResponse;

import java.util.List;


public class GamesActivity extends ActionBarActivity implements ResponceListener{
    public static final String PASS_KEY="pass_key";
    public static final String EMAIL_KEY="email_key";

    private GameAdapter mAdapter;
    private boolean mIsAuthorized = false;
    private String mPass;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mIsAuthorized = true;
            mEmail = extras.getString(EMAIL_KEY);
            mPass = extras.getString(PASS_KEY);
            String deviceType = String.format("%s %s", android.os.Build.MODEL, android.os.Build.VERSION.RELEASE);
            WifiManager manager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = manager.getConnectionInfo();
            String address = info.getMacAddress();
            RestClient client = new RestClient(this);
            client.getGames(mEmail, mPass, deviceType, address);
            ListView listView = (ListView) findViewById(R.id.games_list);
            mAdapter = new GameAdapter(this);
            listView.setAdapter(mAdapter);
        }
        if (!mIsAuthorized){
            Intent intent = new Intent(this, AuthorizationActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_games, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, AuthorizationActivity.class);
            intent.putExtra(GamesActivity.EMAIL_KEY, mEmail);
            intent.putExtra(GamesActivity.PASS_KEY, mPass);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetData(WorldsResponse worldsResponse) {
        mAdapter.setWords(worldsResponse.getmWorlds());
        mAdapter.notifyDataSetChanged();
    }
}

