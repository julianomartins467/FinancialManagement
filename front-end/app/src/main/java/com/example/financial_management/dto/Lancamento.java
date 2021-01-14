package com.example.financial_management.dto;

import java.util.Date;

public class Lancamento {

    private Integer id;
    private String descricao;
    private String data;
    private Double valor;
    private Character tipo;

    public Lancamento() {

    }

    public Lancamento(Integer id, String descricao, String data, Double valor, Character tipo) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.valor = valor;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Character getTipo() { return tipo;    }

    public void setTipo(Character tipo) {  this.tipo = tipo;    }
}
