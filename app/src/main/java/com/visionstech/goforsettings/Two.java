package com.visionstech.goforsettings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;

public class Two extends AppCompatActivity {
    private int SETTINGS_ACTION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String sizechecks = pref.getString("fontsize", "medium");


        if (sizechecks.equals("small")) {
            setTheme(R.style.small);
        }else if (sizechecks.equals("medium")) {
            setTheme(R.style.medium);
        } else if (sizechecks.equals("normal")) {
            setTheme(R.style.normal);
        } else if (sizechecks.equals("large")) {
            setTheme(R.style.large);
        } else if (sizechecks.equals("extra_large")) {
            setTheme(R.style.extra_large);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.setting) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivityForResult(intent, SETTINGS_ACTION);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SETTINGS_ACTION) {

            if (resultCode == Preferences.RESULT_CODE_SIZE_UPDATED) {
                finish();
                startActivity(getIntent());
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
