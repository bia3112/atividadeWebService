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
    
     public Medico inserirmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException {
//
//            if(medico.getCrm() == null) {
//                throw new ValidacaoException("CRM inválido.");
//            }        
//            if(medico.getCpf() == null) {
//                throw new CampoPreenchidoException("CPF");
//            }
//            if(medico.getCpf().length() <= 10) {
//                throw new ValidacaoException("CPF deve possuir "
//                        + "11 caracteres.");
//            }
//            if(medico.getNome().length() <= 3) {
//                throw new ValidacaoException("Nome deve possuir"
//                        + " mais do que 3 caracteres.");
//            }
//            if(medico.getNome() == null) {
//                throw new CampoPreenchidoException("nome");
//            }
//            if(medico.getEndereco() == null) {
//                throw new CampoPreenchidoException("endereço");
//            }
//            if(medico.getEspecialidade() == null) {
//                throw new CampoPreenchidoException("especialidade");
//            }
//            if(medico.getTelefone() == null) {
//                throw new CampoPreenchidoException("telefone");
//            }
//            if(medico.getEmail() == null) {
//                throw new CampoPreenchidoException("email");
//            } 
            
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.inserirmedico(medico);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public ArrayList<Medico> listAllMedico() throws SQLException {
        MedicoRepository medicoRepository = new MedicoRepository();
        ArrayList<Medico> retorno = medicoRepository.listAllMedico();
        return retorno;
    }

    public Medico atualizarmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException {

//            if(medico.getCpf() == null) {
//                throw new CampoPreenchidoException("CPF");
//            }
//            if(medico.getCpf().length() <= 10) {
//                throw new ValidacaoException("CPF deve possuir "
//                         + "11 caracteres.");
//            }
//            if(medico.getNome().length() <= 3) {
//                throw new ValidacaoException("Nome deve possuir"
//                         + " mais do que 3 caracteres.");
//            }
//            if(medico.getNome() == null) {
//                throw new CampoPreenchidoException("nome");
//            }
//            if(medico.getEndereco() == null) {
//                throw new CampoPreenchidoException("endereço");
//            }
//
//            if(medico.getTelefone() == null) {
//                throw new CampoPreenchidoException("telefone");
//            }
//            if(medico.getEmail() == null) {
//                throw new CampoPreenchidoException("email");
//            }
//            
//            Medico medicoExistente = findByIdmedico(medico.getId());
//            if (!medico.getCrm().equals(medicoExistente.getCrm())) {
//                throw new ValidacaoException("CRM não pode ser alterado.");
//            }
//            if (!medico.getEmail().equals(medicoExistente.getEmail())) {
//                throw new ValidacaoException("E-mail não pode ser alterado.");
//            }
//            if (!medico.getEspecialidade().equals(medicoExistente.getEspecialidade())) {
//                throw new ValidacaoException("Especialidade não pode ser alterado");
//            }
             
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.atualizarmedico(medico);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public Medico deletarmedico(Medico medico) throws ValidacaoException {
         try {
             MedicoRepository medicoRepository = new MedicoRepository();
             return medicoRepository.deletarmedico(medico);
         } catch (SQLException ex) {
             throw new ValidacaoException("Erro Interno de Servidor");
         }
    }
    
    public Medico findByIdmedico(int id) throws ValidacaoException {

//             if(id <= 0) {
//                 throw new ValidacaoException("Número de caracteres inválido.");
//             }
//             
        try {     
            MedicoRepository medicoRepository = new MedicoRepository();
            return medicoRepository.findByIdmedico(id);
         } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
         }
    }
    
    
}
