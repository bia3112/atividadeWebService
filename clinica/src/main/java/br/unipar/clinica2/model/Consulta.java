/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

import java.time.LocalDateTime;
    
public class Consulta {
    private int ConsultaID;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;

    public Consulta(Paciente paciente, Medico medico, LocalDateTime dataHora) {
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
    }

    public Consulta(int ConsultaID) {
        this.ConsultaID = ConsultaID;
    }

    public int getConsultaID() {
        return ConsultaID;
    }

    public void setConsultaID(int ConsultaID) {
        this.ConsultaID = ConsultaID;
    }

   

    public Consulta() {
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    
}
