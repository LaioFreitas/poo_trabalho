package com.app.entities;

import java.time.LocalDateTime;

import com.app.data.exceptions.ClienteInexistenteException;
import com.app.data.exceptions.VeiculoIndisponivelException;
import com.app.data.exceptions.VeiculoInexistenteException;

public interface OrdemDeServiso<T> {
    
    public void alugar(Cliente cliente, Veiculo veiculo) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException;
    public void devolver();
    public void listar();
    public LocalDateTime DataEmisao();
    public LocalDateTime DataDevolucao();
    public void valorTotal();

}
