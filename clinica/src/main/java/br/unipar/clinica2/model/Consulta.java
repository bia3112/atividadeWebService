/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.model;

import Enum.StatusConsultaEnum;
import java.time.LocalDateTime;
    
public class Consulta {
    
    private int idConsulta;
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataHora;
    private StatusConsultaEnum status;

    public Consulta(int idConsulta, Paciente paciente, Medico medico, LocalDateTime dataHora, StatusConsultaEnum status) {
        this.idConsulta = idConsulta;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = status;
    }  

    public Consulta() {
    }

    public Consulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
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

    public StatusConsultaEnum getStatus() {
        return status;
    }

    public void setStatus(StatusConsultaEnum status) {
        this.status = status;
    }
 
}
