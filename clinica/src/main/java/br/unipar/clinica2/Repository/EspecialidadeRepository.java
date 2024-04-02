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

/**
 *
 * @author vinicius.duarte
 */
public class EspecialidadeRepository {
    
    private static final String INSERIR = "INSERT INTO ESPECIALIDADE(NOME) VALUES(?)";

    private static final String LIST_ALL = "SELECT * FROM ESPECIALIDADE";

    private static final String DELETAR = "DELETE FROM ESPECIALIDADE WHERE ID = ?";

    private static final String ATUALIZAR = "UPDATE ESPECIALIDADE SET NOME = ? WHERE ID = ?";
    
    private static final String FIND_BY_ID = "SELECT ID, NOME FROM ESPECIALIDADE WHERE ID = ?";
    
    
    public ArrayList<Especialidade> listAllEspecialidade() throws SQLException {
         
        ArrayList<Especialidade> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(LIST_ALL);
            
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
     
    public Especialidade inserirEspecialidade(Especialidade especialidade) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(INSERIR);
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
        return especialidade;
    }
     
    public Especialidade atualizarEspecialidade(Especialidade especialidade) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(ATUALIZAR);
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
        return especialidade;
    }
      
    public void deletarEspecialidade(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETAR);
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

    public Especialidade findByIdEspecialidade(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Especialidade retorno = null;

        try {
            
             conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Especialidade();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME")); 
               
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


    

