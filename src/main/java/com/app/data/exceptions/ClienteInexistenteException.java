package com.app.data.exceptions;

public class ClienteInexistenteException extends Exception {
    public ClienteInexistenteException() {
        super("Cliente Não Cadastrado"); // implementar com a GUI
    }
}