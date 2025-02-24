package com.app.data.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.app.entities.Veiculo;

public class VeiculoServise {

    private List<Veiculo> veiculos;

    public VeiculoServise() {

    }

    public void save(Veiculo veiculo) {
        
       try( FileWriter writer = new FileWriter("src/main/java/com/app/data/veiculosAlugados.csv", true)) {
            writer.write(veiculo.toCSV());
            writer.write("\n");
            writer.close();
       }
       catch(IOException e) {
            e.printStackTrace();
       }

    }

}
