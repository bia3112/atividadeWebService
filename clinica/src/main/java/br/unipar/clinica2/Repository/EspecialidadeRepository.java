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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class EspecialidadeRepository {
       public Especialidade insert(Especialidade especialidade) throws SQLException {
       String sql = "INSERT INTO Especialidade (nome) VALUES (?)";
       
        try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
        
        
            ps.setString(1, especialidade.getNome());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                especialidade.setId(generatedKeys.getInt(1));
            }
        }
           return especialidade;
       }

    public ArrayList<Especialidade> listAll() {
              ArrayList<Especialidade> especialidades = new ArrayList<>();
        String query = "SELECT * FROM Medico";
 try (Connection conn = new ConnectionFactory().getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nome = ps.getString("nome");
                especialidades.add(new Especialidade(id, nome));
            }
        }
        return especialidades;

    }

    public Especialidade atualizar(Especialidade especialidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

    

