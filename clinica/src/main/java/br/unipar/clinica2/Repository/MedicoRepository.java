/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;

import br.unipar.clinica2.model.Medico;
import br.unipar.clinica2.ws.infrainstructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinicius.duarte
 */
public class MedicoRepository {
    
    private static final String INSERT = "INSERT INTO MEDICO(CRM, ESPECIALIDADE_ID, PESSOA_ID) VALUES(?, ?, ?)";

    private static final String FIND_ALL = "SELECT CRM, ESPECIALIDADE_ID, PESSOA_ID FROM MEDICO ";

    private static final String DELETE = "DELETE FROM MEDICO WHERE CRM = ?";

    private static final String UPDATE = "UPDATE MEDICO SET CRM = ?, ESPECIALIDADE_ID = ?, PESSOA_ID = ? WHERE CRM = ?";
    
    private static final String FIND_BY_ID = "SELECT FROM MEDICO WHERE ID = ?";
    
    public ArrayList<Medico> listAll() throws SQLException {
        
        ArrayList<Medico> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setCRM(rs.getInt("CRM"));
                medico.setEspecialidade(new EspecialidadeRepository().findById(rs.getInt("ESPECIALIDADE_ID")));
                retorno.add(medico);
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (conn != null) {
                conn.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
        }

        return retorno;
    }
    
   public Medico inserir(Medico medico) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, medico.getCRM());
            pstmt.setInt(2, medico.getEspecialidade().getId());
          
            pstmt.executeUpdate();
            
        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        
        return medico;
        
    }
   
   
   public Medico atualizar(Medico medico) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
             conn = new ConnectionFactory().getConnection();
           
            pstmt = conn.prepareStatement(UPDATE);
            
                
            pstmt.setInt(1, medico.getCRM());
            pstmt.setInt(2, medico.getEspecialidade().getId());
            
            pstmt.executeUpdate();

        } finally {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return medico;

    }
   
     public void deletar(int id) throws SQLException {
         
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, id);

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
   public Medico findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Medico retorno = null;

        try {
            
             conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Medico();
                retorno.setCRM(rs.getInt("CRM"));
                 retorno.setEspecialidade(new EspecialidadeRepository().findById(rs.getInt("ESPECIALIDADE_ID")));
                
               
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return retorno;
    }
   
}

