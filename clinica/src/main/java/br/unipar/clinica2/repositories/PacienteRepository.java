/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.repositories;

import br.unipar.clinica2.model.Paciente;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacienteRepository {
    
     public PacienteRepository(){
        
    }
    
    public ArrayList<Paciente> findLivro(String nome){
        return null;
    }
    
    public ArrayList<Paciente> listAll() throws SQLException{
        return null;
    }
    
    public Paciente findById(int id){
        return null;
    }
   
    public Paciente insert(Paciente paciente) throws SQLException {
        
       
        return paciente;
    }

    public Paciente update(Paciente paciente) throws SQLException {
        return paciente;
    }
            
    
    public void delete(int pacienteid) throws SQLException {
        
    }
    
}
