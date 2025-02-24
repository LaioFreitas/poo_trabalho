package com.app.servises;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

import com.app.data.exceptions.ClienteInexistenteException;
import com.app.data.exceptions.VeiculoIndisponivelException;
import com.app.data.exceptions.VeiculoInexistenteException;
import com.app.entities.Cliente;
import com.app.entities.OrdemDeServiso;
import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.data.exceptions.*;
public class Alugar implements OrdemDeServiso {

    private static Integer ID;
    private ArrayList<Cliente> cliente;
    private LocalDate dataEmisao;
    private LocalDate dataDevolucao;
    private ArrayList<Veiculo> veiculo;

    public Alugar(ArrayList<Cliente> cliente, LocalDate dataDevolucao, ArrayList<Veiculo> veiculo) {
        this.cliente = cliente;
        this.dataEmisao = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
        this.veiculo = veiculo;
    }

    @Override
    public void alugar(Cliente cl, Veiculo vei) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException{
        if (cliente.contains(cl)) {
            if (veiculo.contains(vei)){
                if (vei.getStatus() == Status.DISPONIVEL){
                        System.out.println("Veículo Alugado"); // implementar com a GUI
                        vei.setStatus(Status.ALUGADO);
                } else {
                    throw new VeiculoIndisponivelException();
                }
            } else {
                throw new VeiculoInexistenteException();
            }
        } else {
            throw new ClienteInexistenteException();
        }
    }
    @Override
    public void devolver() {
    }

    @Override
    public void listar() {
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
