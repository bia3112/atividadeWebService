/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.MedicoRepository;
import br.unipar.clinica2.model.Medico;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class MedicoService {
    
     public Medico inserir(Medico medico) throws ValidacaoException, CampoPreenchidoException {

            if(medico.getCRM() == 0) {
                throw new ValidacaoException("CMR inválido.");
            }        
            if(medico.getCpf() == null) {
                throw new CampoPreenchidoException("CPF");
            }
            if(medico.getCpf().length() <= 10) {
                throw new ValidacaoException("CPF deve possuir "
                        + "11 caracteres.");
            }
            if(medico.getNome().length() <= 3) {
                throw new ValidacaoException("Nome deve possuir"
                        + " mais do que 3 caracteres.");
            }
            if(medico.getNome() == null) {
                throw new CampoPreenchidoException("nome");
            }
            if(medico.getEndereco() == null) {
                throw new CampoPreenchidoException("endereço");
            }
            if(medico.getEspecialidade() == null) {
                throw new CampoPreenchidoException("especialidade");
            }
            if(medico.getTelefone() == null) {
                throw new CampoPreenchidoException("telefone");
            }
            if(medico.getEmail() == null) {
                throw new CampoPreenchidoException("email");
            } 
            
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.inserir(medico);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public ArrayList<Medico> listAll() throws SQLException {
        MedicoRepository medicoRepository = new MedicoRepository();
        ArrayList<Medico> retorno = medicoRepository.listAll();
        return retorno;
    }

    public Medico atualizar(Medico medico) throws ValidacaoException, CampoPreenchidoException {

            if(medico.getCRM() == 0) {
                throw new ValidacaoException("CMR inválido.");
            }
            if(medico.getCpf() == null) {
                throw new CampoPreenchidoException("CPF");
            }
            if(medico.getCpf().length() <= 10) {
                throw new ValidacaoException("CPF deve possuir "
                         + "11 caracteres.");
            }
            if(medico.getNome().length() <= 3) {
                throw new ValidacaoException("Nome deve possuir"
                         + " mais do que 3 caracteres.");
            }
            if(medico.getNome() == null) {
                throw new CampoPreenchidoException("nome");
            }
            if(medico.getEndereco() == null) {
                throw new CampoPreenchidoException("endereço");
            }
            if(medico.getEspecialidade() == null) {
                throw new CampoPreenchidoException("especialidade");
            }
            if(medico.getTelefone() == null) {
                throw new CampoPreenchidoException("telefone");
            }
            if(medico.getEmail() == null) {
                throw new CampoPreenchidoException("email");
            }
             
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.atualizar(medico);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public void deletar(int id) throws ValidacaoException {
         try {
             MedicoRepository medicoRepository = new MedicoRepository();
             medicoRepository.deletar(id);
         } catch (SQLException ex) {
             throw new ValidacaoException("Erro Interno de Servidor");
         }
    }
    
    public Medico findById(int id) throws ValidacaoException, CampoPreenchidoException {

             if(id <= 0) {
                 throw new ValidacaoException("Número de caracteres inválido.");
             }
             
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.findById(id);
         } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
         }
    }
    
    
}
