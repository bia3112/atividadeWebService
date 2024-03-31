/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.interfaces.ConsultaWebService;
import br.unipar.clinica2.model.Consulta;
import br.unipar.clinica2.services.ConsultaService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.ConsultaWebService")
public class ConsultaWebServicelmp implements ConsultaWebService {

    @Override
    public Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.inserirConsulta(consulta);
    }

    @Override
    public ArrayList<Consulta> listAllConsulta() throws SQLException {
         ConsultaService consultaService = new ConsultaService();
        return consultaService.listAllConsulta();
    }

    @Override
    public Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.atualizarConsulta(consulta);
    }

    @Override
    public void deletarConsulta(int id) throws ValidacaoException {
        ConsultaService consultaService = new ConsultaService();
        consultaService.deletarConsulta(id);
    }

    @Override
    public Consulta findByIdConsulta(int id) throws ValidacaoException {
        ConsultaService consultaService = new ConsultaService();
        return consultaService.findByIdConsulta(id);
    }
    
}
