/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.model.Pessoa;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
@WebService
public interface PessoaWebService {
    
    @WebMethod
    Pessoa inserir (Pessoa pessoa);
    
    @WebMethod
    ArrayList<Pessoa> listAll();
    
    @WebMethod
    Pessoa atualizar(Pessoa pessoa);
    
    @WebMethod
    void deletar(int id);

}
