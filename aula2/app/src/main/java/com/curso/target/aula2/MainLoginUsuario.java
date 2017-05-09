package com.curso.target.aula2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainLoginUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loginusuario);

        Intent intent = getIntent();
        TextView txtNome = (TextView)findViewById(R.id.textView);
        String json = intent.getStringExtra("usuario");
        User usuario = new Gson().fromJson(json,User.class);
        String nUsuario = usuario.getNome();
        txtNome.setText(nUsuario);
    }
}
