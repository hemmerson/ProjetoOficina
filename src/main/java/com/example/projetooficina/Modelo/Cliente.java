package com.example.projetooficina.Modelo;

import java.util.List;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private int numero;
    private List<OrdemServico> ordemServicos;

    public Cliente() {
    }

    public Cliente(String nome, String telefone, String endereco, String bairro, String cidade, String estado, String complemento, int numero) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.numero = numero;
    }

    public Cliente(int id, String nome, String telefone, String endereco, String bairro, String cidade, String estado, String complemento, int numero) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.complemento = complemento;
        this.numero = numero;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public List<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }
}
