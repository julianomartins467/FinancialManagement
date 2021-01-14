package com.example.financial_management.services;

import com.example.financial_management.dto.DtoUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface InterfaceDeServicos {

    @POST("/users")
    Call<DtoUser> insertUser(@Body DtoUser dtoUser);

    @POST("/auth/login")
    Call<DtoUser> login(@Body DtoUser dtoUser);

    @GET("/users")
    Call<List<DtoUser>> findAll();

    @GET("/users/{id}")
    Call<DtoUser> findById(@Body DtoUser user, @Path("id") int id);

    @DELETE("/users/{id}")
    Call<Void> deleteUser(@Path("id") int id);
}
