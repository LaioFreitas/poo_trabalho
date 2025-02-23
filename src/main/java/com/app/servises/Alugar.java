package com.app.servises;

import java.time.LocalDate;
import java.util.List;

import com.app.entities.Cliente;
import com.app.entities.OrdemDeServiso;
import com.app.entities.Veiculo;

public class Alugar implements OrdemDeServiso {

    private static final Integer ID;
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
    public Void alugar() {

    }
    
    @Override
    public Void devolver() {
    }

    @Override
    public Void listar() {
    }

    @Override
    public LocalDateTime DataEmisao() {
    }

    @Override
    public LocalDateTime DataDevolucao() {

    }

    @Override
    public void valorTotal() {
    }


}
