package com.app.veiculos;

import com.app.entities.Veiculo;

public class Onibus extends Veiculo {

    public Onibus(String placa, String modelo, String chassi, Double kilometragem) {
        setModelo(modelo);
        setPlaca(placa);
        this.chasi = chassi;
        this.kilometragem = kilometragem;
    }

    public Onibus(String chassi, String modelo) {
        this("", modelo, chassi, 0.0);
    }

}
