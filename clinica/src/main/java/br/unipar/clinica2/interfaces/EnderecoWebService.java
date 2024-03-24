/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

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
    Endereco inserir(Endereco endereco) throws ValidacaoException;
    
    @WebMethod
    ArrayList<Endereco> listAll();
    
    @WebMethod 
    Endereco atualizar(Endereco endereco);
    
    @WebMethod
    void deletar(int id);
    
    @WebMethod
    Endereco findById(int id);
 
}
