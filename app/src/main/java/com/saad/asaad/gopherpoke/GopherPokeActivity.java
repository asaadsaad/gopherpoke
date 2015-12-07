package com.saad.asaad.gopherpoke;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

public class GopherPokeActivity extends Activity
{
    private GopherPokeView gpv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        gpv = new GopherPokeView(this);

        FrameLayout outerLayout = new FrameLayout(this);
        outerLayout.addView(gpv);

        setContentView(outerLayout);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        gpv.killThread();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        gpv.onDestroy();
    }
}
