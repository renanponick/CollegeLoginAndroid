package com.example.createandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateUser extends AppCompatActivity {
    private String nome, email, login, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        Bundle args = getIntent().getExtras();
        nome = args.getString("nome");
        email = args.getString("email");
        login = args.getString("login");
        senha = args.getString("senha");

        TextView editNome = (TextView) findViewById(R.id.editName);
        TextView editEmail = (TextView) findViewById(R.id.editEmail);

        editNome.setText(nome);
        editEmail.setText(email);

        Button btAlter = (Button) findViewById(R.id.btSave);
        btAlter.setOnClickListener(onClickLogin());
    }
    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tNome = (TextView) findViewById(R.id.editName);
                TextView tEmail = (TextView) findViewById(R.id.editEmail);
                String nome = tNome.getText().toString();
                String email = tEmail.getText().toString();

                // Navega para a próxima tela
                Intent intent = new Intent(CreateUser.this, DataUser.class);
                startActivityForResult(intent, 3);

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
