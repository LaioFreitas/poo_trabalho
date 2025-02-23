package com.app.servises;

import java.time.LocalDateTime;

import com.app.entities.Cliente;
import com.app.entities.OrdemDeServiso;
import com.app.entities.Veiculo;

public class Alugar implements OrdemDeServiso {

    private Cliente cliente;
    private LocalDateTime dataEmisao;
    private LocalDateTime dataDevolucao;
    private Veiculo veiculo;

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
    public void DataEvimisao() {
    }

    @Override
    public void DataDevolucao() {

    }

    @Override
    public void valorTotal() {
    }


}
