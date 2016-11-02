package com.kaiwindle.dialogswapout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Kai Windle on 02/11/2016.
 * DialogSwapOut
 */

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTextView = (Button) findViewById(R.id.btnShowTextView);
        Button btnEditView = (Button) findViewById(R.id.btnShowEditText);
        Button btnImageView = (Button) findViewById(R.id.btnShowImageView);

        btnTextView.setOnClickListener(this);
        btnEditView.setOnClickListener(this);
        btnImageView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ViewType type = null;

        switch (v.getId()) {
            case R.id.btnShowTextView:
                type = ViewType.TEXT_VIEW;
                break;

            case R.id.btnShowEditText:
                type = ViewType.EDIT_VIEW;
                break;

            case R.id.btnShowImageView:
                type = ViewType.IMAGE_VIEW;
                break;

            default:
                break;
        }

        DialogWin dialog = new DialogWin(this,
                android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen,
                type);
        dialog.show();
    }
}


