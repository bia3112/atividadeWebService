/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.model.Paciente;
import br.unipar.clinica2.repositories.PacienteRepository;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacientesService {
     public ArrayList<Paciente> listAll()throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        return PacienteRepository.listAll();
    }
    
    public Paciente findById(int id)throws SQLException {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.findById(id);
    }
    public ArrayList<Paciente> findPaciente(String nome) throws SQLException{
        PacienteRepository livroRepository = new PacienteRepository();
        return PacienteRepository.findPaciente(nome);
    }
    
    public Paciente insert(Paciente paciente){
    }
    
    public Paciente update(Paciente paciente) throws SQLException  {
        PacienteRepository pacienteRepository = new PacienteRepository();
        return pacienteRepository.update(paciente);
    }
    
    public void delete(int id) throws SQLException{
        PacienteRepository pacienteRepository = new PacienteRepository();
        pacienteRepository.delete(id);
    }

    
}
