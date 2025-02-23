package com.app.entities;

import com.app.enums.Status;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    protected String chasi;
    protected Double kilometragem;
    private Status status;


    public String getChasi() {
        return chasi;
    }

    public Double getKilometragem() {
        return kilometragem;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public boolean disponivel() {
        return status == Status.DISPONIVEL;
    }

    public abstract String toCSV();

}
