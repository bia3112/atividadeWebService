/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.ConsultaRepository;
import br.unipar.clinica2.interfaces.ConsultaWebService;
import br.unipar.clinica2.model.Consulta;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.duarte
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.ConsultaWebService")
public class ConsultaWebServicelmp implements ConsultaWebService {
    

    @Override
    public Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        try {
            return consultaRepository.inserirConsulta(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaWebServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }

    @Override
    public ArrayList<Consulta> listAllConsulta() throws ValidacaoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        try {
            return consultaRepository.listAllConsulta();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaWebServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    @Override
    public Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        try {
            return consultaRepository.atualizarConsulta(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaWebServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deletarConsulta(int id) throws ValidacaoException {
       ConsultaRepository consultaRepository = new ConsultaRepository();
        try {
            consultaRepository.deletarConsulta(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaWebServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Consulta findByIdConsulta(int id) throws ValidacaoException {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        try {
            return consultaRepository.findByIdConsulta(id);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaWebServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
