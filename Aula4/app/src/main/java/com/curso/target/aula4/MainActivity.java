package com.curso.target.aula4;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ViewPropertyAnimatorCompatSet;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    Button textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (Button) findViewById(R.id.button);
    }

    public void buttonClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                //botão 1
                dialogDefault();
                break;
            case R.id.button2:
                listDialog();
                break;
            case R.id.button3:
                //botão 3
                customDialog();
                break;
        }
    }

    private void dialogDefault() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.title)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                }).create();
        builder.show();
    }


    private void materialDialog() {
        new MaterialDialog.Builder(this)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                })
                .onNeutral(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        // TODO
                    }
                })
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        // TODO
                    }
                });
    }


    private void listDialog() {
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .items(R.array.mArray)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        String[] mArray = getResources().getStringArray(R.array.mArray);
                        textView.setText(mArray[which]);
                    }
                })
                .show();
    }

    private void customDialog(){
        new MaterialDialog.Builder(this)
                .title(R.string.title)
                .customView(R.layout.dialog,true)
                .positiveText(R.string.yes)
                .show();
    }

}

