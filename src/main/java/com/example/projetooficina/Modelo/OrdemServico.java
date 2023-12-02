package com.example.projetooficina.Modelo;

import java.time.LocalDate;

/**
 * @author "Hemmerson Luis Barros da Rosa"
 * on date 02/12/2023
 */
public class OrdemServico {
    private int id;
    private String observacao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private Double valorTotal;
    private Cliente cLiente;
    private Aparelho aparelho;

    public OrdemServico() {
    }

    public OrdemServico(int id, String observacao, LocalDate dataEntrada, LocalDate dataSaida, Double valorTotal) {
        this.id = id;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
    }

    public OrdemServico(int id, String observacao, LocalDate dataEntrada, LocalDate dataSaida, Double valorTotal, Cliente cLiente, Aparelho aparelho) {
        this.id = id;
        this.observacao = observacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.valorTotal = valorTotal;
        this.cLiente = cLiente;
        this.aparelho = aparelho;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getcLiente() {
        return cLiente;
    }

    public void setcLiente(Cliente cLiente) {
        this.cLiente = cLiente;
    }

    public Aparelho getAparelho() {
        return aparelho;
    }

    public void setAparelho(Aparelho aparelho) {
        this.aparelho = aparelho;
    }
}
