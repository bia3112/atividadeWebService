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
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author vinicius.duarte
 */
public class MedicoRepository {
    
     private static final String INSERT = "INSERT INTO MEDICO(CRM, "
            + "NOME, CPF, EMAIL, TELEFONE, ESPECIALIDADE_ID, ENDERECO_ID, STATUS) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT CRM, NOME, EMAIL, ESPECIALIDADE_ID, STATUS FROM MEDICO";

    private static final String DELETE = "UPDATE MEDICO SET STATUS = ? "
            + "WHERE ID = ?";

    private static final String UPDATE = "UPDATE MEDICO SET NOME = ?, "
            + " TELEFONE = ?, ENDERECO_ID = ? WHERE ID = ?";

    private static final String FIND_BY_ID = "SELECT ID, NOME, CRM, "
            + "ESPECIALIDADE, STATUS FROM MEDICO WHERE ID = ?";

    public ArrayList<Medico> listAllMedico() throws SQLException {

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
                medico.setCrm(rs.getString("CRM"));
                medico.setNome(rs.getString("NOME"));
                medico.setEmail(rs.getString("EMAIL"));
                medico.setEspecialidade(new EspecialidadeRepository().
                        findByIdEspecialidade(rs.getInt("ESPECIALIDADE_ID")));
                medico.setStatus(rs.getString("STATUS"));

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
        
        Collections.sort(retorno, new Comparator<Medico>() {
            @Override
            public int compare(Medico m1, Medico m2) {
                return m1.getNome().compareToIgnoreCase(m2.getNome());
            }
        });

        return retorno;
    }

    public Medico inserirmedico(Medico medico) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT);

            pstmt.setString(1, medico.getCrm());
            pstmt.setString(2, medico.getNome());
            pstmt.setString(3, medico.getCpf());
            pstmt.setString(4, medico.getEmail());
            pstmt.setString(5, medico.getTelefone());
            pstmt.setInt(6, medico.getEspecialidade().getIdEspecialidade());
            pstmt.setInt(7, medico.getEndereco().getIdEndereco());
            pstmt.setString(8, medico.getStatus());

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

    public Medico atualizarmedico(Medico medico) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setString(1, medico.getNome());
            pstmt.setString(2, medico.getTelefone());
            pstmt.setInt(3, medico.getEndereco().getIdEndereco());
            pstmt.setInt(4, medico.getId());

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

    public Medico deletarmedico(Medico medico) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {

            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setInt(1, medico.getId());

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

    public Medico findByIdmedico(int id) throws SQLException {

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
                retorno.setCrm(rs.getString("CRM"));
                retorno.setNome(rs.getString("NOME"));
                retorno.setCpf(rs.getString("CPF"));
                retorno.setEmail(rs.getString("EMAIL"));
                retorno.setTelefone(rs.getString("TELEFONE"));
                retorno.setEspecialidade(new EspecialidadeRepository().findByIdEspecialidade(rs.getInt("ESPECIALIDADE_ID")));
                retorno.setEndereco(new EnderecoRepository().findByIdEndereco(rs.getInt("ENDERECO_ID")));

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

