package com.example.whatsappclone.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.whatsappclone.MainActivity;
import com.example.whatsappclone.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void abrirTelaCadastro(View view)
    {
        Intent intent = new Intent(getBaseContext(), CadastroAcitivity.class);
        startActivity(intent);
    }

    public void abrirTelaPrincipal(View view)
    {
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }
}
