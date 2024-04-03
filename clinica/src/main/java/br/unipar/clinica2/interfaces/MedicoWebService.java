/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.model.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
@WebService
public interface MedicoWebService {
    
    @WebMethod
    Medico inserirmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Medico> listAllMedico();
    
    @WebMethod
    Medico atualizarmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod 
    Medico deletarmedico(Medico medico) throws ValidacaoException;
    
    @WebMethod
    Medico findByIdmedico(int id) throws ValidacaoException, CampoPreenchidoException;
}
