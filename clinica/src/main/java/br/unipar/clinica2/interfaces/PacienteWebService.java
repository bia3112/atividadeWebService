/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.unipar.clinica2.interfaces;

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
    ArrayList<Paciente> findMedico(String nome);
    
    @WebMethod
    ArrayList<Paciente> listAll();
    
    @WebMethod
    Paciente findById(int id);
    
    @WebMethod
    Paciente inserir(Paciente paciente);
    
    @WebMethod
    Paciente atualizar(Paciente paciente);
    
    @WebMethod 
    void deletar(int id);
    
}
