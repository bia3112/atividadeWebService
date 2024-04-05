/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;

import br.unipar.clinica2.model.Endereco;
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
public class EnderecoRepository {
    
    private static final String INSERT = "INSERT INTO ENDERECO(LOGRADOURO, "
            + "NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF, CEP, STATUS) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT * FROM ENDERECO";

    private static final String FIND_BY_ID = "SELECT ID_ENDERECO, LOGRADOURO, NUMERO, "
            + "COMPLEMENTO, BAIRRO, CIDADE, UF, CEP FROM ENDERECO WHERE ID_ENDERECO = ?";

    private static final String DELETE = "UPDATE ENDERECO SET STATUS = ? "
            + "WHERE ID_ENDERECO = ?";

    private static final String UPDATE = "UPDATE ENDERECO SET LOGRADOURO = ?, "
            + "NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ?, CIDADE = ?, "
            + "UF = ?, CEP = ? WHERE ID_ENDERECO = ?";
     
    
    public ArrayList<Endereco> listAllEndereco() throws SQLException{
        
        ArrayList<Endereco> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setLogradouro(rs.getString("LOGRADOURO"));
                endereco.setNumero(rs.getInt("NUMERO"));
                endereco.setComplemento(rs.getString("COMPLEMENTO"));
                endereco.setBairro(rs.getString("BAIRRO"));
                endereco.setCidade(rs.getString("CIDADE"));
                endereco.setUf(rs.getString("UF"));
                endereco.setCep(rs.getString("CEP"));
                endereco.setStatus(rs.getString("STATUS"));
                endereco.setIdEndereco(rs.getInt("ID_ENDERECO"));
                retorno.add(endereco);
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
    
       public Endereco inserirEndereco(Endereco endereco) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getComplemento());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getUf());
            pstmt.setString(7, endereco.getCep());
            pstmt.setString(8, endereco.getStatus());

            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return endereco;
    }
       
    public Endereco atualizarEndereco(Endereco endereco) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, endereco.getLogradouro());
            pstmt.setInt(2, endereco.getNumero());
            pstmt.setString(3, endereco.getComplemento());
            pstmt.setString(4, endereco.getBairro());
            pstmt.setString(5, endereco.getCidade());
            pstmt.setString(6, endereco.getUf());
            pstmt.setString(7, endereco.getCep());
            pstmt.setInt(8, endereco.getIdEndereco()); // id no final pq no sql ta no final 

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return endereco;
    }
    
      public Endereco deletarEndereco(Endereco endereco) throws SQLException {
          
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            
            pstmt.setString(1, endereco.getStatus());
            pstmt.setInt(2, endereco.getIdEndereco());
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return endereco;
    }
     
    public Endereco findByIdEndereco(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Endereco retorno = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                
                retorno = new Endereco();
                retorno.setLogradouro(rs.getString("LOGRADOURO"));
                retorno.setNumero(rs.getInt("NUMERO"));
                retorno.setComplemento(rs.getString("COMPLEMENTO"));
                retorno.setBairro(rs.getString("BAIRRO"));
                retorno.setCidade(rs.getString("CIDADE"));
                retorno.setUf(rs.getString("UF"));
                retorno.setCep(rs.getString("CEP"));
               
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
