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
import java.util.Collections;

/**
 *
 * @author vinid
 */
public class PacienteRepository {
    
    private static final String INSERT = "INSERT INTO PACIENTE(NOME, EMAIL, TELEFONE, ENDERECO_ID, CPF) VALUES(?, ?, ?, ?, ?)";

    private static final String LIST_ALL = "SELECT NOME, EMAIL, TELEFONE, ENDERECO_ID, CPF FROM PACIENTE";

    private static final String FIND_BY_ID = "SELECT NOME, EMAIL, TELEFONE, ENDERECO_ID, CPF FROM PACIENTE WHERE ID = ? ";

    private static final String DELETE = "DELETE FROM PACIENTE WHERE ID = ?";

    private static final String UPDATE = "UPDATE PACIENTE SET NOME = ?, TELEFONE = ?, ENDERECO_ID = ? WHERE ID = ?";
    
    public ArrayList<Paciente> listAllPaciente() throws SQLException {
         
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
                paciente.setNome(rs.getString("NOME"));
                paciente.setEmail(rs.getString("EMAIL"));
                paciente.setTelefone(rs.getString("TELEFONE"));
                paciente.setEndereco(new EnderecoRepository().findByIdEndereco(rs.getInt("ENDERECO_ID")));
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
        //listar em ordem alfabética
        Collections.sort(retorno, (Paciente p1, Paciente p2) -> p1.getNome().compareTo(p2.getNome()));

        return retorno;
    }
    
    public Paciente inserirPaciente(Paciente paciente) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            
            pstmt = conn.prepareStatement(INSERT);
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getEmail());
            pstmt.setString(3, paciente.getTelefone());
            pstmt.setInt(4, paciente.getEndereco().getId());
            pstmt.setString(5, paciente.getCpf());

            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
       return paciente;
    }
    
    public Paciente atualizarPaciente(Paciente paciente) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);
            
            pstmt.setInt(1, paciente.getId());
            pstmt.setString(2, paciente.getNome());
            pstmt.setString(3, paciente.getTelefone());
            pstmt.setInt(4, paciente.getEndereco().getId());
            
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return paciente;
    }
    
    public void deletarPaciente(int id) throws SQLException {
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

    public Paciente findByIdPaciente(int id) throws SQLException {

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
                retorno.setEndereco(new EnderecoRepository().findByIdEndereco(rs.getInt("ENDERECO_ID")));
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
