package com.app.veiculos;

import com.app.entities.Veiculo;
import com.app.enums.Status;

public class Carro extends Veiculo {

    private Double tarifa;
  

  

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((tarifa == null) ? 0 : tarifa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Carro other = (Carro) obj;
        if (tarifa == null) {
            if (other.tarifa != null)
                return false;
        } else if (!tarifa.equals(other.tarifa))
            return false;
        return true;
    }

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

    @Override
    public String toString() {
        return this.getModelo();
    }



}
