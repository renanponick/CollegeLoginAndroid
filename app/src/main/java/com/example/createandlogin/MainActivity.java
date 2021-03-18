package com.example.createandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.btnLogar);
        btLogin.setOnClickListener(onClickLogin());
    }
    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.editLogin);
                TextView tPass = (TextView) findViewById(R.id.editPass);
                String login = tLogin.getText().toString();
                String senha = tPass.getText().toString();

                // Realiza o login e manda para a outra tela com os parametros
                if ("adm".equals(login) && "123".equals(senha)) {
                    // Navega para a próxima tela
                    Intent intent = new Intent(MainActivity.this, DataUser.class);
                    startActivityForResult(intent, 2);
                    Bundle params = new Bundle();
                    params.putString("nome", "Nome");
                    params.putString("email", "email@gmail.com");
                    params.putString("login", login);
                    params.putString("senha", senha);
                    intent.putExtras(params);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(MainActivity.this, CreateUser.class);
                    startActivityForResult(intent, 2);
                    Bundle params = new Bundle();
                    params.putString("login", login);
                    params.putString("senha", senha);
                    intent.putExtras(params);
                    startActivity(intent);
                }
            }
        };
    }
}
