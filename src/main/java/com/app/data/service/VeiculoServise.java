package com.app.data.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.app.entities.Cliente;
import com.app.entities.Veiculo;
import com.app.enums.Status;
import com.app.utils.Utils;
import com.app.veiculos.Carro;

public class VeiculoServise {

     private List<Veiculo> veiculos = new ArrayList<>();

     public VeiculoServise() {

     }

     public void save(Veiculo veiculo) {
        
       try( FileWriter writer = new FileWriter("src/main/java/com/app/data/veiculosDisponiveis.csv", true)) {
            writer.write(veiculo.toCSV());
            writer.write("\n");
       }
       catch(IOException e) {
            e.printStackTrace();
       }

     }

     public List<Veiculo> findAllDisponiveis() {
          List<String> list = readCSVList("src/main/java/com/app/data/veiculosDisponiveis.csv");
          veiculos = convertVeicolo(list);
          return veiculos;
     }

     private List<String> readCSVList(String path) {

          List<String> list = new ArrayList<>();
          try (BufferedReader br = new BufferedReader(new FileReader(path))) {
               String line = br.readLine();
               while (line != null) {
                    list.add(line);
                    line = br.readLine();
               }
               
          }
          catch (IOException e) {
               System.out.println("Error: " + e.getMessage());
          }
          return list;
     }

     private List<Veiculo> convertVeicolo(List<String> list) {
          List<Veiculo> veiculos = new ArrayList<>();
          for (String s : list) {
               String[] fields = s.split(",");
               Veiculo veiculo = new Carro(fields[0], fields[1], fields[2], Utils.tryParseToDouble(fields[3]), Status.valueOf(fields[4]));
               veiculos.add(veiculo);
          }
          return veiculos;
     }

     private void atualizarDadosDisponiveis(String path, Veiculo vei) {
          List<String> listString = readCSVList(path);
          List<Veiculo> list = convertVeicolo(listString);

          list.remove(vei);
          listString = convertToCSV(list);
          try(FileWriter writer = new FileWriter(path)) {
               for (String linha : listString) {
                    writer.write(linha);
                    writer.write("\n");
               }
          }
          catch(IOException e) {
               e.printStackTrace();
          }
     }

     private List<String> convertToCSV(List<Veiculo> list) {
          List <String> listString = new ArrayList<>();
          for (Veiculo v : list) {
               listString.add(v.toCSV());
          }
          return listString;
     }

     private void salvaVeiculoAlugado(String path, Veiculo vei, Cliente cliente) {
          try( FileWriter writer = new FileWriter(path, true)) {
               writer.write(vei.toCSV() + "," + cliente.toCSV());
               writer.write("\n");
          }
          catch(IOException e) {
               e.printStackTrace();
          } 
     }



     public void alugar(Veiculo vei, Cliente cliente) {
          atualizarDadosDisponiveis("src/main/java/com/app/data/veiculosDisponiveis.csv", vei);
          vei.setStatus(Status.ALUGADO);
          salvaVeiculoAlugado("src/main/java/com/app/data/veiculosAlugados.csv", vei, cliente);
     }



}
