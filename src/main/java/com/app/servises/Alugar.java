package com.app.servises;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

import com.app.data.exceptions.ClienteInexistenteException;
import com.app.data.exceptions.VeiculoIndisponivelException;
import com.app.data.exceptions.VeiculoInexistenteException;
import com.app.data.service.VeiculoServise;
import com.app.entities.Cliente;
import com.app.entities.OrdemDeServiso;
import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.veiculos.Carro;
import com.app.data.exceptions.*;
public class Alugar implements OrdemDeServiso {

    private static Integer ID;
    private Cliente clientes;
    private LocalDate dataEmisao;
    private LocalDate dataDevolucao;
    private Veiculo veiculos;

    public Alugar(Cliente cliente, LocalDate dataDevolucao, Veiculo veiculo) {
        this.clientes = cliente;
        this.dataEmisao = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
        this.veiculos = veiculo;
    }

    @Override
    public void alugar(Cliente cl, Veiculo vei, VeiculoServise servise) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException {
        // if (clientes.contains(cl)) {
        //     if (veiculos.contains(vei)){
        //         if (vei.getStatus() == Status.DISPONIVEL){
        //                 System.out.println("Veículo Alugado"); // implementar com a GUI
        //                 vei.setStatus(Status.ALUGADO);
        //                 this.DataEmisao(); // Conseguir a data de Emissão
        //         } else {
        //             throw new VeiculoIndisponivelException();
        //         }
        //     } else {
        //         throw new VeiculoInexistenteException();
        //     }
        // } else {
        //     throw new ClienteInexistenteException();
        // }o

        //((Carro)vei).setStatus(Status.ALUGADO);
        servise.alugar(vei, cl);
    }

    @Override
    public void devolver(Cliente cl, Veiculo vei) throws ClienteInexistenteException, VeiculoInexistenteException, VeiculoIndisponivelException {
        if (clientes.contains(cl)) {
            if (veiculos.contains(vei)){
                if (vei.getStatus() == Status.ALUGADO){
                        System.out.println("Veículo Devolvido"); // implementar com a GUI
                        vei.setStatus(Status.DISPONIVEL);
                        this.DataDevolucao(); // Conseguir a data de devolução;
                        this.valorTotal(vei);
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


}
