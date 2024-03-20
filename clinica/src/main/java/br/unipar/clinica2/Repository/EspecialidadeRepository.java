/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;

import br.unipar.clinica2.model.Especialidade;
import br.unipar.clinica2.ws.infrainstructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius.duarte
 */
public class EspecialidadeRepository {
     private static final String INSERT = "INSERT INTO ESPECIALIDADE(NOME) VALUES(?)";

    private static final String FIND_ALL = "SELECT NOME FROM ESPECIALIDADE ";

    private static final String FIND_BY_ID = "SELECT NOME FROM ESPECIALIDADE WHERE NOME = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM ESPECIALIDADE WHERE NOME = ?";

    private static final String UPDATE = "UPDATE ESPECIALIDADE SET NOME = ? WHERE NOME = ?";
    
     public List<Especialidade> findAll() throws SQLException {
        ArrayList<Especialidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();

            pstmt = conn.prepareStatement(FIND_ALL);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Especialidade especialidade = new Especialidade();
                especialidade.setNome(rs.getString("NOME"));
                
                retorno.add(especialidade);
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
     public void insert(Especialidade especialidade) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, especialidade.getNome());

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
      public void update(Especialidade especialidade) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
             conn = new ConnectionFactory().getConnection();
           
            pstmt = conn.prepareStatement(UPDATE);
           pstmt.setString(1, especialidade.getNome());
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
       public void delete(String nome) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

           conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE_BY_ID);

            pstmt.setString(1, nome);

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
         public Especialidade findById(String nome) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Especialidade retorno = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setString(1, nome);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Especialidade();
                retorno.setNome(rs.getString("nome"));
   
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


    

