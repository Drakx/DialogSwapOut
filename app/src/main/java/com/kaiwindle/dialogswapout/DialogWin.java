package com.kaiwindle.dialogswapout;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.StyleRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kai Windle on 02/11/2016.
 * DialogSwapOut
 */

public class DialogWin extends Dialog {

    private Context mContext;
    private FrameLayout mFrameLayout;

    public DialogWin(Context context, @StyleRes int themeResId, ViewType viewType) {
        super(context, themeResId);

        this.mContext = context;
        setContentView(R.layout.dialog_window);

        mFrameLayout = (FrameLayout) findViewById(R.id.container);

        Button btnClose = (Button) findViewById(R.id.btn_close);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        init(viewType);

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    private void init(ViewType _viewType) {
        switch (_viewType) {
            case TEXT_VIEW:
                initTextView();
                break;

            case EDIT_VIEW:
                initEditView();
                break;

            case IMAGE_VIEW:
                initImageView();
                break;

            default:
                break;
        }
    }

    private void initTextView() {
        changeLayoutView(R.layout.text_view_layout);
    }

    private void initEditView() {
        changeLayoutView(R.layout.edit_text_layout);
    }

    private void initImageView() {
        changeLayoutView(R.layout.image_view_layout);
    }

    private void changeLayoutView(@LayoutRes int layout) {
        View view = LayoutInflater.from(mContext).inflate(layout, mFrameLayout, true);

        switch (layout) {
            case R.layout.text_view_layout: {
                TextView tv = (TextView) view.findViewById(R.id.text_view);
                tv.setTextColor(Color.RED);

                break;
            }

            case R.layout.edit_text_layout: {
                EditText editText = (EditText) view.findViewById(R.id.edit_text);
                editText.setText("Edit Text");
                break;
            }

            case R.layout.image_view_layout: {
                ImageView img = (ImageView) view.findViewById(R.id.image_view);
                break;
            }

            default:
                break;
        }
    }
}

