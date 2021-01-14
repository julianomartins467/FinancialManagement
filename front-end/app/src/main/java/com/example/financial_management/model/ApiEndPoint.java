package com.example.financial_management.model;

import com.example.financial_management.dto.Lancamento;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {

        @GET("users")
        Call<List<Usuario>> obterUsuarios();

        @GET("inputs")
        Call<List<Lancamento>> obterEntradas();

        @GET("outputs")
        Call<List<Lancamento>> obterSaidas();

}
