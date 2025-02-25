package com.app.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.app.data.exceptions.ClienteInexistenteException;
import com.app.data.exceptions.VeiculoIndisponivelException;
import com.app.data.exceptions.VeiculoInexistenteException;
import com.app.data.service.VeiculoServise;

public interface OrdemDeServiso {
    
    public void alugar(Cliente cliente, Veiculo veiculom, VeiculoServise servise) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException;
    public void devolver(Cliente cliente, Veiculo veiculo) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException;
    public void listar();
    public LocalDate DataEmisao();
    public LocalDate DataDevolucao();
    public void valorTotal(Veiculo V);

}
