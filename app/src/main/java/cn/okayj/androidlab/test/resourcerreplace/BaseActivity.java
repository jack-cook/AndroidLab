package cn.okayj.androidlab.test.resourcerreplace;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jack on 2017/11/14.
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(SkinContext.wrap(newBase));
    }
}
