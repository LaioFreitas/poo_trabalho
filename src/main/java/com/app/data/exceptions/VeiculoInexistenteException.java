package com.app.data.exceptions;

public class VeiculoInexistenteException extends Exception{
    public VeiculoInexistenteException(){
        super("O Veículo não foi encontrado no banco de dados"); // implementar com a GUI
    }
}
