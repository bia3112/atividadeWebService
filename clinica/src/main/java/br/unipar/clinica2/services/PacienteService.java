/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.PacienteRepository;
import br.unipar.clinica2.model.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacienteService {
    
    public ArrayList<Paciente> listAllPaciente()throws SQLException{
       PacienteRepository pacienteRepository = new PacienteRepository();
       ArrayList<Paciente> retorno = pacienteRepository.listAllPaciente();
       return retorno;
    }

    public Paciente inserirPaciente(Paciente paciente) throws ValidacaoException, CampoPreenchidoException {
        
        if(paciente.getNome().length() <= 3) {
            throw new ValidacaoException("Nome deve possuir"
                   + " mais do que 3 caracteres.");
        }
        if(paciente.getNome() == null) {
            throw new CampoPreenchidoException("nome");
        }
        if(paciente.getEmail().length() <= 12) {
            throw new ValidacaoException("Email deve possuir"
                   + " mais do que 12 caracteres.");
        }
        if(paciente.getEmail() == null) {
            throw new CampoPreenchidoException("email");
        }
        if(paciente.getTelefone().length() <= 8) {
            throw new ValidacaoException("Telefone deve possuir"
                   + " mais do que 8 caracteres.");
        }
        if(paciente.getTelefone() == null) {
            throw new CampoPreenchidoException("telefone");
        }
        if(paciente.getCpf().length() <= 10) {
            throw new ValidacaoException("CPF deve possuir"
                   + " mais do que 10 caracteres.");
        }
        if(paciente.getCpf() == null) {
            throw new CampoPreenchidoException("CPF");
        }
        if(paciente.getEndereco() == null) {
            throw new CampoPreenchidoException("endereço");
        }
        
        try {
            PacienteRepository pacienteRepository = new PacienteRepository();
            return pacienteRepository.inserirPaciente(paciente);
        } catch (SQLException ex) {
           throw new ValidacaoException("Erro Interno de Servidor");
        }
     }
    
    public Paciente atualizarPaciente(Paciente paciente) throws ValidacaoException, 
            CampoPreenchidoException {
        
        if(paciente.getNome().length() <= 3) {
            throw new ValidacaoException("Nome deve possuir"
                   + " mais do que 3 caracteres.");
        }
        if(paciente.getTelefone().length() <= 8) {
            throw new ValidacaoException("Telefone deve possuir"
                   + " mais do que 8 caracteres.");
        }
        
        Paciente pacienteExistente = findByIdPaciente(paciente.getId());
            if (pacienteExistente != null) {
                paciente.setCpf(pacienteExistente.getCpf());
                paciente.setEmail(pacienteExistente.getEmail());
            }
        
        try {
            PacienteRepository pacienteRepository = new PacienteRepository();
            return pacienteRepository.atualizarPaciente(paciente);
        } catch (SQLException ex) {
           throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
    public Paciente deletarPaciente(Paciente paciente) throws ValidacaoException {

        try {
            PacienteRepository pacienteRepository = new PacienteRepository();
            return pacienteRepository.deletarPaciente(paciente);
        } catch (SQLException ex) {
           throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
    public Paciente findByIdPaciente(int id) throws ValidacaoException {
        
        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
        
        try {
            PacienteRepository pacienteRepository = new PacienteRepository();
            return pacienteRepository.findByIdPaciente(id);
        } catch (SQLException ex) {
           throw new ValidacaoException("Erro Interno de Servidor");
        }
    }

}
