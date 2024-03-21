/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Repository.PacienteRepository;
import br.unipar.clinica2.model.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacienteService {
    
     public ArrayList<Paciente> listAll()throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        ArrayList<Paciente> retorno = pacienteRepository.listAll();
        return retorno;
    }

    public Paciente inserir(Paciente paciente) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.inserir(paciente);
        return paciente;
     }
    
    public Paciente atualizar(Paciente paciente) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.atualizar(paciente);
        return paciente;
    }
    
    public void deletar(int id) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.deletar(id);
    }
    
    public Paciente findById(int id) throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.findById(id);
    }

}
