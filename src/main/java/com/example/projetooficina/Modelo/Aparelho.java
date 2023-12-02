package com.example.projetooficina.Modelo;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class Aparelho {
    private int id;
    private String nome;
    private String modelo;
    private String marca;
    private String numeroSerie;

    private List<OrdemServico> ordemServicos;

    public Aparelho() {
    }

    public Aparelho(int id, String nome, String modelo, String marca, String numeroSerie) {
        this.id = id;
        this.nome = nome;
        this.modelo = modelo;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public List<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }
}
