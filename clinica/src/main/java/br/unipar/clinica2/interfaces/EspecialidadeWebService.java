/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

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
    ArrayList<Especialidade> findEspecialidade(String nome);
    
    @WebMethod
    ArrayList<Especialidade> listAll();
    
    @WebMethod
    Especialidade findById(int id);
    
    @WebMethod
    Especialidade inserir(Especialidade especialidade);
    
    @WebMethod
    Especialidade atualizar(Especialidade especialidade);
    
    @WebMethod 
    void deletar(int id);
    
}
