package com.curso.target.aula2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);

        Button button = (Button)findViewById(R.id.button3);
        final EditText editText = (EditText) findViewById(R.id.editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainLoginUsuario.class);
                User usuario = new User();
                usuario.setNome("Paulo Severo");
                usuario.setDescricao("Projetista");
                ////intent.putExtra("Nome",editText.getText().toString());
                intent.putExtra("usuario", new Gson().toJson(usuario));
                startActivity(intent);
            }
        });

    }
}
