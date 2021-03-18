package com.example.createandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataUser extends AppCompatActivity {
    private String nome, email, login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_user);

        Bundle args = getIntent().getExtras();
        nome = args.getString("nome");
        email = args.getString("email");
        login = args.getString("login");
        senha = args.getString("senha");

        TextView txtNome = (TextView) findViewById(R.id.textNome);
        TextView txtemail = (TextView) findViewById(R.id.textEmail);
        TextView txtLogin = (TextView) findViewById(R.id.textLogin);
        TextView txtSenha = (TextView) findViewById(R.id.textSenha);

        txtNome.setText("Nome: " + nome);
        txtemail.setText("E-mail: " + email);
        txtLogin.setText("Login: " + login);
        txtSenha.setText("Senha: " + senha);

        Button btLogin = (Button) findViewById(R.id.btnAlterar);
        btLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataUser.this, CreateUser.class);
                startActivityForResult(intent, 2);
                Bundle params = new Bundle();
                params.putString("nome", nome);
                params.putString("email", email);
                params.putString("login", login);
                params.putString("senha", senha);
                intent.putExtras(params);
                startActivity(intent);
            }
        };
    }
}
