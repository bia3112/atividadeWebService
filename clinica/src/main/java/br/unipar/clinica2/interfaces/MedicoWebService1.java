/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

import br.unipar.clinica2.model.Medico;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
@WebService
public interface MedicoWebService1 {
    @WebMethod
    ArrayList<Medico> findMedico(String nome);
    
    @WebMethod
    ArrayList<Medico> listAll();
    
    @WebMethod
    Medico inserir(Medico medico);
    
    @WebMethod
    Medico atualizar(Medico medico);
    
    @WebMethod 
    void deletar(int id);
    
}
