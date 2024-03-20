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
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
public class PacienteRepository {
    
   private static final String INSERT = "INSERT INTO PACIENTE(LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO) VALUES(?, ?, ?, ?)";

    private static final String FIND_ALL = "SELECT LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO FROM ENDERECO ";

    private static final String FIND_BY_ID = "SELECT LOGRADOURO, NUMERO, COMPLEMENTO, BAIRRO FROM ENDERECO WHERE LOGRADOURO = ? ";

    private static final String DELETE_BY_ID = "DELETE FROM ENDERECO WHERE LOGRADOURO = ?";

    private static final String UPDATE = "UPDATE ENDERECO SET LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, BAIRRO = ? WHERE LOGRADOURO = ?";
    
    
}
