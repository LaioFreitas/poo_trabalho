package com.app.entities;

import java.time.LocalDateTime;

public interface OrdemDeServiso<T> {
    
    public Void alugar();
    public Void devolver();
    public Void listar();
    public LocalDateTime DataEmisao();
    public LocalDateTime DataDevolucao();
    public void valorTotal();

}
