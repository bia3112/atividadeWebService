/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.repositories;

import br.unipar.clinica2.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PessoaRepository {
     public PessoaRepository(){
        
    }
    
    public ArrayList<Pessoa> findLivro(String nome){
        return null;
    }
    
    public ArrayList<Pessoa> listAll() throws SQLException{
        return null;
    }
    
    public Pessoa findById(int id){
        return null;
    }
   
    public Pessoa insert(Pessoa pessoa) throws SQLException {
        
       
        return pessoa;
    }

    public Pessoa update(Pessoa pessoa) throws SQLException {
        return pessoa;
    }
            
    
    public void delete(int pessoaid) throws SQLException {
        
    }
    
}
