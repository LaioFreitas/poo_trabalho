package com.app.veiculos;

import com.app.entities.Veiculo;

public class Onibus extends Veiculo {

    private Double tarifa;
    
    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public Onibus(String placa, String modelo, String chassi, Double kilometragem) {
        setModelo(modelo);
        setPlaca(placa);
        this.chasi = chassi;
        this.kilometragem = kilometragem;
    }

    public Onibus(String chassi, String modelo) {
        this("", modelo, chassi, 0.0);
    }

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%s", getPlaca(), getModelo(), getChasi(), getKilometragem(), getStatus());
    }

}
