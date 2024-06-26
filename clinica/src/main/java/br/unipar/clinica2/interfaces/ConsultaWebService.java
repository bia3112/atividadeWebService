    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import Enum.StatusConsultaEnum;
import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.model.Consulta;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
@WebService
public interface ConsultaWebService {
    @WebMethod
    Consulta inserirConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Consulta> listAllConsulta() throws SQLException;
    
    @WebMethod 
    Consulta atualizarConsulta(Consulta consulta) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    Consulta cancelarConsulta(Consulta consulta) throws ValidacaoException;
    
    @WebMethod
    Consulta findByIdConsulta(int id) throws ValidacaoException;
    
}
