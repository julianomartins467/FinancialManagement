package com.example.financial_management.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.financial_management.R;
import com.example.financial_management.dto.DtoUser;

import com.example.financial_management.services.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void btnEntrar(View view) {
           logar(view);
    }

    public void logar(View view) {
        String email = ((EditText)findViewById(R.id.editTextEmailLogin)).getText().toString();
        String senha = ((EditText)findViewById(R.id.editTextSenhaLogin)).getText().toString();

        DtoUser dtoUser = new DtoUser();
        dtoUser.setEmail(email);
        dtoUser.setPassword(senha);

        RetrofitService.getServico(this).login(dtoUser).enqueue(new Callback<DtoUser>() {
            @Override
            public void onResponse(Call<DtoUser> call, Response<DtoUser> response) {
                if(response.body() == null || response.body().getLogado() == false){
                    Toast.makeText(LoginActivity.this,"Usuario e/ou senha incorreta",Toast.LENGTH_LONG).show();
                    return;
                }
                Long id = response.body().getId();
                Toast.makeText(LoginActivity.this, "Usuário logado", Toast.LENGTH_SHORT).show();
                SharedPreferences sp = getSharedPreferences("dados", 0);
                SharedPreferences.Editor editor = sp.edit();
                editor.putLong("user", id);
                editor.apply();
                setContentView(R.layout.activity_home);
                startActivity(new Intent(LoginActivity.this, HistoricoActivity.class));
            }

            @Override
            public void onFailure(Call<DtoUser> call, Throwable t) {
                Log.d(TAG, "onFailure: "+t.getMessage());
            }
        });
    }
}