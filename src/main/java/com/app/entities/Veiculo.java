package com.app.entities;

import com.app.enums.Status;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    protected String chasi;
    protected Double kilometragem;
    private Status status;
    public abstract Double getTarifa();

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        result = prime * result + ((chasi == null) ? 0 : chasi.hashCode());
        result = prime * result + ((kilometragem == null) ? 0 : kilometragem.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Veiculo other = (Veiculo) obj;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (chasi == null) {
            if (other.chasi != null)
                return false;
        } else if (!chasi.equals(other.chasi))
            return false;
        if (kilometragem == null) {
            if (other.kilometragem != null)
                return false;
        } else if (!kilometragem.equals(other.kilometragem))
            return false;
        if (status != other.status)
            return false;
        return true;
    }

    public abstract boolean contains(Veiculo vei);

}
