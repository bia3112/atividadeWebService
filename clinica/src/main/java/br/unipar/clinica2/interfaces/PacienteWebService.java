/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.model.Paciente;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
@WebService
public interface PacienteWebService {

    @WebMethod
    Paciente inserirPaciente(Paciente paciente) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Paciente> listAllPaciente();
    
    @WebMethod
    Paciente atualizarPaciente(Paciente paciente) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod 
    Paciente deletarPaciente(Paciente paciente) throws ValidacaoException;
    
    @WebMethod
    Paciente findByIdPaciente(int id) throws ValidacaoException, CampoPreenchidoException;
    
}
