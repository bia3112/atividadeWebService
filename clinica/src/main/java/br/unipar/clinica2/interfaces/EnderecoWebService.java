/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.model.Endereco;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
@WebService
public interface EnderecoWebService {
    
    @WebMethod
    Endereco inserirEndereco(Endereco endereco) throws ValidacaoException, 
            CampoPreenchidoException;
    
    @WebMethod
    ArrayList<Endereco> listAllEndereco() throws ValidacaoException;
    
    @WebMethod 
    Endereco atualizarEndereco(Endereco endereco) throws ValidacaoException, 
            CampoPreenchidoException;
    
    @WebMethod
    Endereco deletarEndereco(Endereco endereco) throws ValidacaoException;
    
    @WebMethod
    Endereco findByIdEndereco(int id) throws ValidacaoException;
 
}
