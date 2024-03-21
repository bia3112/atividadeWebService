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

    public Paciente insert(Paciente paciente) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.insert(paciente);
     }
    
    public Paciente atualizar(Paciente paciente) {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.atualizar(paciente);
    }
    
    public void delete(int id) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.delete(id);
    }

    
}
