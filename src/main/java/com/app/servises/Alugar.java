package com.app.servises;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.OrdemDeServiso;
import com.app.entities.Veiculo;
public class Alugar implements OrdemDeServiso {

    private static Integer ID;
    private Cliente cliente;
    private LocalDate dataEmisao;
    private LocalDate dataDevolucao;
    private Veiculo veiculo;

    public Alugar(Cliente cliente, LocalDate dataDevolucao, Veiculo veiculo) {
        this.cliente = cliente;
        this.dataEmisao = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
        this.veiculo = veiculo;
    }

    @Override
    public void alugar(VeiculoServise servise) {

        servise.alugar(this);
    }

    @Override
    public void devolver(Cliente cl, Veiculo vei) {

    }

    @Override
    public void listar() {
    }

    @Override
    public LocalDate DataEmisao() {
        this.dataEmisao = LocalDate.now();
        return dataEmisao;
    }

    @Override
    public LocalDate DataDevolucao() {
        this.dataDevolucao = LocalDate.now();
        return dataDevolucao;
    }

    @Override
    public void valorTotal(Veiculo v) {
        double total = 0.0;
        long dias = ChronoUnit.DAYS.between(dataEmisao, dataDevolucao);
        total += v.getTarifa() * dias;
        System.out.println("Valor total do aluguel: R$" + total);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente clientes) {
        this.cliente = clientes;
    }

    public LocalDate getDataEmisao() {
        return dataEmisao;
    }

    public void setDataEmisao(LocalDate dataEmisao) {
        this.dataEmisao = dataEmisao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculos) {
        this.veiculo = veiculos;
    }

    public String toCSV() {
        return cliente.toCSV() + "," + veiculo.toCSV() + "," + dataDevolucao.toString();
    }



}
