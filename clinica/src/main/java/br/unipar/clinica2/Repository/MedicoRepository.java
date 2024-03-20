/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.Repository;

import br.unipar.clinica2.model.Medico;
import br.unipar.clinica2.ws.infrainstructure.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinicius.duarte
 */
public class MedicoRepository {
    public Medico insert(Medico medico) throws SQLException {
             String query = "INSERT INTO Medico (CRM, especialidade_id, pessoa_id) VALUES (?, ?, ?)";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, medico.getCRM());
            ps.setInt(2, medico.getespecialidade());
            ps.setInt(3, medico.getPessoaId());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    medico.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o ID gerado para o médico.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return medico;
    }
    

    public ArrayList<Medico> listAll() {
      ArrayList<Medico> medicos = new ArrayList<>();
        String query = "SELECT * FROM Medico";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setCRM(rs.getInt("CRM"));
                medico.getespecialidade(rs.getInt("especialidade_id"));
                medico.setPessoaId(rs.getInt("pessoa_id"));
                medicos.add(medico);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicos;
    }
    

    public Medico atualizar(Medico medico) {
         String query = "UPDATE Medico SET CRM = ?, especialidade_id = ?, pessoa_id = ? WHERE id = ?";

        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setInt(1, medico.getCRM());
            ps.setInt(2, medico.getespecialidade());
            ps.setInt(3, medico.getPessoaId());
            ps.setInt(4, medico.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new SQLException("Nenhum registro atualizado para o médico com ID: " + medico.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medico;
    }



    public void deletar(int id) {
        //teoricamente não e deveser possivel deletar um dado sendo assim ver um jeito de apenas ocultar a merda do dado aaaaaaaaaaaaaaaaaaaaa FOME
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

