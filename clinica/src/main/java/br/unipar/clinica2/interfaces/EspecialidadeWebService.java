/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.model.Especialidade;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
@WebService
public interface EspecialidadeWebService {
    
    @WebMethod
    Especialidade inserirEspecialidade(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Especialidade> listAllEspecialidade();

    @WebMethod
    Especialidade atualizarEspecialidade(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException;
    
    @WebMethod 
    Especialidade deletarEspecialidade(Especialidade especialidade) throws ValidacaoException;
    
    @WebMethod
    Especialidade findByIdEspecialidade(int id) throws ValidacaoException, CampoPreenchidoException;
    
}
