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
import java.util.Comparator;

/**
 *
 * @author vinid
 */
public class PacienteRepository {
    
    private static final String INSERT = "INSERT INTO PACIENTE(NOME, EMAIL, "
            + "TELEFONE, ENDERECO_ID, CPF, STATUS) VALUES(?, ?, ?, ?, ?, ?)";

    private static final String LIST_ALL = "SELECT NOME, EMAIL, CPF, STATUS FROM PACIENTE";

    private static final String FIND_BY_ID = "SELECT NOME, EMAIL"
            + ", CPF, STATUS FROM PACIENTE WHERE ID = ? ";

    private static final String DELETE = "UPDATE PACIENTE SET STATUS = ? "
            + " WHERE ID = ?";

    private static final String UPDATE = "UPDATE PACIENTE SET NOME = ?, "
            + "TELEFONE = ?, ENDERECO_ID = ? WHERE ID = ?";
    
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
                paciente.setCpf(rs.getString("CPF"));
                paciente.setStatus(rs.getString("STATUS"));
                
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
        
        Collections.sort(retorno, new Comparator<Paciente>() {
            @Override
            public int compare(Paciente p1, Paciente p2) {
                return p1.getNome().compareToIgnoreCase(p2.getNome());
            }
        });

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
            pstmt.setInt(4, paciente.getEndereco().getIdEndereco());
            pstmt.setString(5, paciente.getCpf());
            pstmt.setString(6, paciente.getStatus());

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
                       
            pstmt.setString(1, paciente.getNome());
            pstmt.setString(2, paciente.getTelefone());
            pstmt.setInt(3, paciente.getEndereco().getIdEndereco());
            pstmt.setInt(4, paciente.getId());
            
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
    
    public Paciente deletarPaciente(Paciente paciente) throws SQLException {
        
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setString(1, paciente.getStatus());
            pstmt.setInt(2, paciente.getId());

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
                
                retorno.setNome(rs.getString("NOME")); 
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setCpf(rs.getString("CPF"));
                retorno.setStatus(rs.getString("STATUS"));

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
