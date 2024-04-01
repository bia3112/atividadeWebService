/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

import java.time.LocalTime;

/**
 *
 * @author Beatr
 */
public class HorarioFuncionamento {
    
    private LocalTime abertura;
    private LocalTime fechamento;

    public HorarioFuncionamento(LocalTime abertura, LocalTime fechamento) {
        this.abertura = abertura;
        this.fechamento = fechamento;
    }
    
    public boolean estaNoIntervalo(LocalTime horario) {
        return !horario.isBefore(abertura) && !horario.isAfter(fechamento);
    }
    
}
