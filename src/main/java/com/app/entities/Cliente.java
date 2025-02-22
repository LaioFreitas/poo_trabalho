package com.app.entities;

import com.app.utils.Endereco;

public class Cliente extends Pessoa {

    private Endereco endereco;
    private String telefone;
    private String categoriaChn;

    public Cliente(String nome, String cpf, Endereco endereco, String telefone, String cnh) {
        super(nome, cpf);
        setEndereco(endereco);
        setTelefone(telefone);
        setCategoriaChn(cnh);
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCategoriaChn() {
        return categoriaChn;
    }

    public void setCategoriaChn(String cnh) {
        this.categoriaChn = cnh;
    }



}
