package com.app.veiculos;

import com.app.entities.Veiculo;
import com.app.enums.Status;

public class Carro extends Veiculo {

    private Double tarifa;

    public Carro(String placa, String modelo, String chassi, Double kilometragem, Status status) {
        setModelo(modelo);
        setPlaca(placa);
        setStatus(status); 
        this.chasi = chassi;
        this.kilometragem = kilometragem;
    }

    public Carro(String chassi, String modelo) {
        this("", modelo, chassi, 0.0, Status.ALUGADO);
    }
    
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%s", getPlaca(), getModelo(), getChasi(), getKilometragem(), getStatus());
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

}
