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
    Medico inserir(Medico medico) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Medico> listAll();
    
    @WebMethod
    Medico atualizar(Medico medico) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod 
    void deletar(int id) throws ValidacaoException;
    
    @WebMethod
    Medico findById(int id) throws ValidacaoException, CampoPreenchidoException;
}
