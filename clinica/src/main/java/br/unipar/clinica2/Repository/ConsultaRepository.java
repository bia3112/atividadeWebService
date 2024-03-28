/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;


import br.unipar.clinica2.model.Consulta;
import br.unipar.clinica2.ws.infrainstructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
//SQL DA CONSULTA
//CREATE TABLE CONSULTAS (
//    CONSULTAID INT PRIMARY KEY,
//    PACIENTEID INT,
//    MEDICOID INT,
//    DATAHORA DATETIME,
//    FOREIGN KEY (PACIENTEID) REFERENCES PACIENTES(PACIENTEID),
//    FOREIGN KEY (MEDICOID) REFERENCES MEDICOS(MEDICOID)
//);

public class ConsultaRepository {
    
    private static final String FIND_ALL = "SELECT * FROM CONSULTAS ";
    
    private static final String INSERT = "INSERT INTO CONSULTAS(PACIENTEID , "
            + "MEDICOID, DATAHORA ) VALUES(?, ?, ?)";
    
    private static final String FIND_BY_ID = "SELECT CONSULTAID , PACIENTEID, MEDICOID, "
            + "DATAHORA  FROM CONSULTAS  WHERE CONSULTAID = ?";

    private static final String DELETE = "UPDATE CONSULTAS  SET STATUS = ? "
            + "WHERE CONSULTAID  = ?";

    private static final String UPDATE = "UPDATE CONSULTAS  SET PACIENTEID  = ?, "
            + "MEDICOID = ?, DATAHORA = ? WHERE CONSULTAID = ?";
     
    
    public ArrayList<Consulta> listAllConsulta() throws SQLException{
        
        ArrayList<Consulta> retorno = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_ALL);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setPaciente(new PacienteRepository().findByIdPaciente(rs.getInt("PACIENTEID")));
                consulta.setMedico(new MedicoRepository().findByIdmedico(rs.getInt("MEDICOID")));
                LocalDateTime dataHora = rs.getTimestamp("DATAHORA").toLocalDateTime();        
                retorno.add(consulta);
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
    
       public Consulta inserirConsulta(Consulta consulta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(INSERT);
            
            pstmt.setInt(1, consulta.getPaciente().getId());
            pstmt.setInt(2, consulta.getMedico().getId());
            pstmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));

            pstmt.executeUpdate();
            
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return consulta;
    }
       
      public Consulta atualizarConsulta(Consulta consulta) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(UPDATE);

            pstmt.setInt(1, consulta.getConsultaID());
            pstmt.setInt(1, consulta.getPaciente().getId());
            pstmt.setInt(2, consulta.getMedico().getId());
            pstmt.setTimestamp(3, Timestamp.valueOf(consulta.getDataHora()));
            pstmt.executeUpdate();

        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return consulta;

    }
      public void deletarConsulta(int id) throws SQLException {
          
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(DELETE);
            pstmt.setBoolean(1, false);
            pstmt.setInt(2, id);
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
     
    public Consulta findByIdConsulta(int id) throws SQLException {

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Consulta retorno = null;

        try {
            
            conn = new ConnectionFactory().getConnection();
            pstmt = conn.prepareStatement(FIND_BY_ID);

            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                retorno = new Consulta();
                retorno.setConsultaID(rs.getInt("CONSULTAID"));
                retorno.setPaciente(new PacienteRepository().findByIdPaciente(rs.getInt("PACIENTEID")));
                retorno.setMedico(new MedicoRepository().findByIdmedico(rs.getInt("MEDICOID")));
                retorno.setDataHora(rs.getTimestamp("DATAHORA").toLocalDateTime()); 
                     
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
