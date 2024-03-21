/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;

import br.unipar.clinica2.model.Paciente;
import br.unipar.clinica2.ws.infrainstructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacienteRepository {
    
   private static final String INSERT = "INSERT INTO PACIENTE(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO) VALUES(?, ?, ?, ?)";

    private static final String LIST_ALL = "SELECT LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO FROM ENDERECO ";

    private static final String FIND_BY_ID = "SELECT LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO FROM ENDERECO WHERE LOGRADOURO = ? ";

    private static final String DELETE = "DELETE FROM ENDERECO WHERE LOGRADOURO = ?";

    private static final String UPDATE = "UPDATE ENDERECO SET LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ? WHERE LOGRADOURO = ?";
    
    public ArrayList<Paciente> listAll() throws SQLException {
         
        ArrayList<Paciente> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(LIST_ALL);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("ID"));
                paciente.setNome(rs.getString("NOME"));
                paciente.setEmail(rs.getString("EMAIL"));
                paciente.setTelefone(rs.getString("TELEFONE"));
                paciente.setEndereco(new EnderecoRepository().findById(rs.getInt("ENDERECO_ID")));
                paciente.setCpf(rs.getString("CPF"));
                
                retorno.add(paciente);
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
    
    public void inserir(Paciente paciente) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setInt(1, paciente.getId());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getTelefone());
            pstmt.setInt(5, paciente.getEndereco().getId());
            pstmt.setString(6, paciente.getCpf());

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
    
    public void atualizar(Paciente paciente) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, paciente.getId());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getEmail());
            pstmt.setString(4, paciente.getTelefone());
            pstmt.setInt(5, paciente.getEndereco().getId());
            pstmt.setString(6, paciente.getCpf());
            
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

    public Paciente findById(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Paciente retorno = null;

        try {
            
             conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                retorno = new Paciente();
                retorno.setId(rs.getInt("ID"));
                retorno.setNome(rs.getString("NOME")); 
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setTelefone(rs.getString("TELEFONE"));
                retorno.setEndereco(new EnderecoRepository().findById(rs.getInt("ENDERECO_ID")));
                retorno.setCpf(rs.getString("CPF"));
               
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
