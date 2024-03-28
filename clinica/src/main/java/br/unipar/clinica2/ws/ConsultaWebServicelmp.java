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
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.ConsultaWebService")
public class ConsultaWebServicelmp implements ConsultaWebService {
    

    @Override
    public Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.inserirConsulta(consulta);
    }

    @Override
    public ArrayList<Consulta> listAllConsulta() throws ValidacaoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.listAllConsulta();
    }
    

    @Override
    public Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException {
         ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.atualizarConsulta(consulta);
    }

    @Override
    public void deletarConsulta(int id) throws ValidacaoException {
       ConsultaRepository consultaRepository = new ConsultaRepository();
        consultaRepository.deletarConsulta(id);
    }

    @Override
    public Consulta findByIdConsulta(int id) throws ValidacaoException {
        ConsultaRepository consultaRepository = new ConsultaRepository();
        return consultaRepository.findByIdConsulta(id);
    }
    
    
    
}
