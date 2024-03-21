/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.interfaces.EnderecoWebService;
import br.unipar.clinica2.model.Endereco;
import br.unipar.clinica2.services.EnderecoService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Beatr
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.EnderecoWebService")
public class EnderecoWebServiceImp implements EnderecoWebService{

    @Override
    public Endereco inserir(String logradouro) throws SQLException  {
         EnderecoService enderecoService = new EnderecoService();
        return enderecoService.inserir(logradouro);
    }

    @Override
        public ArrayList<Endereco> listAll(String logradouro) {
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.listAll(logradouro);
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        EnderecoService enderecoService = new EnderecoService();
        try {
            return enderecoService.atualizar(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
}
