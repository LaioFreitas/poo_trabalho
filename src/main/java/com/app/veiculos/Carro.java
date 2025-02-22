package com.app.veiculos;

import com.app.entities.Veiculo;
import com.app.enums.Status;

public class Carro extends Veiculo {

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


}
