/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.ConsultaRepository;
import br.unipar.clinica2.model.Consulta;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class ConsultaService {
    public Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
  
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.inserirConsulta(consulta);
        } catch(SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }
       public ArrayList<Consulta> listAllConsulta()throws ValidacaoException {
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            ArrayList<Consulta> retorno = consultaRepository.listAllConsulta();
            return retorno;
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
        public Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
       
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.atualizarConsulta(consulta);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
  
    }
        public void deletarConsulta(int id) throws ValidacaoException {

        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
        
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            consultaRepository.deletarConsulta(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }

    }
          public Consulta findByIdConsulta(int id) throws ValidacaoException {

        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
            
        try {
            ConsultaRepository consultaRepository = new ConsultaRepository();
            return consultaRepository.findByIdConsulta(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
}
