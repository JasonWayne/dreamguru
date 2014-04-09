package org.dian.dreamguru.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.dian.dreamguru.support.app.AppManager;

/**
 * Created by Jason on 14-4-9.
 */
public class BaseActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        AppManager.getInstance().finishActivity(this);
    }
}
