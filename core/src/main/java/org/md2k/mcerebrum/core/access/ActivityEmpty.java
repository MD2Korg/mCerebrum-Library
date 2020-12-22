package org.md2k.mcerebrum.core.access;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import org.md2k.mcerebrum.core.access.appinfo.AppAccess;

public class ActivityEmpty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedpreferences = getSharedPreferences("mcerebrum", MODE_PRIVATE);
        String init=sharedpreferences.getString("init",null);
        if(init!=null)
            AppAccess.setFuncUpdateInfo(this, getPackageName(), init);
        finish();
    }
}
