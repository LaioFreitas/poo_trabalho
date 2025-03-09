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
    public Cliente() {
        super();
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

    public String toCSV() {
        return String.format("%s,%s,%s,%d,%s,%s,%s,%s,%s", getNome(), getCpf(), endereco.getRua(), endereco.getNumero(), endereco.getBairro(),
                                endereco.getCidade(), endereco.getEstado(), getTelefone(), getCategoriaChn());       
    }
    
    @Override
    public String toString() {
        return this.getNome();
    }


}
