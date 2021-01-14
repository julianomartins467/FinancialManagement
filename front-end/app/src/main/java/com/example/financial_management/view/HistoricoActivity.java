package com.example.financial_management.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.financial_management.R;
import com.example.financial_management.dto.Lancamento;
import com.example.financial_management.helpers.LancamentoAdapter;
import com.example.financial_management.model.RetrofitService;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoricoActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;
    private List<Lancamento> listaGeral = new ArrayList<Lancamento>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
        buscarEntradas();
        buscarSaidas();
       //preencherRecyclerview(listaGeral);
    }

    private void preencherRecyclerview(List<Lancamento> lista)
    {
        RecyclerView mRecyclerView = findViewById(R.id.rv_historico);
        LancamentoAdapter mAdapter = new LancamentoAdapter(this, lista);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_historico: {
                Intent intent = new Intent(this, HistoricoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.navigation_grafico: {
                Intent intent = new Intent(this, GraficoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.navigation_entrada: {
                Intent intent = new Intent(this, EntradaActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.navigation_despesa: {
                Intent intent = new Intent(this, DespesaActivity.class);
                startActivity(intent);
                break;
            }

            case R.id.navigation_conta: {
                Intent intent = new Intent(this, AlteraUsuarioActivity.class);
                startActivity(intent);
                break;
            }
        }

        return true;
    }

    private void buscarEntradas() {
        RetrofitService.getServico().obterEntradas().enqueue(new Callback<List<Lancamento>>() {

            @Override
            public void onResponse(Call<List<Lancamento>> call, Response<List<Lancamento>> response) {
                List<Lancamento> lista = response.body();
                for (Lancamento l : lista ) {
                    l.setTipo('C');
                }
                listaGeral.addAll(lista);
                //preencherRecyclerview(lista);
            }

            @Override
            public void onFailure(Call<List<Lancamento>> call, Throwable t) {

            }
        });
    }

    private void buscarSaidas() {
        RetrofitService.getServico().obterSaidas().enqueue(new Callback<List<Lancamento>>() {

            @Override
            public void onResponse(Call<List<Lancamento>> call, Response<List<Lancamento>> response) {
                List<Lancamento> lista = response.body();
                for (Lancamento l : lista ) {
                    l.setTipo('D');
                }
                listaGeral.addAll(lista);
                preencherRecyclerview(listaGeral);
            }

            @Override
            public void onFailure(Call<List<Lancamento>> call, Throwable t) {

            }
        });
    }
}