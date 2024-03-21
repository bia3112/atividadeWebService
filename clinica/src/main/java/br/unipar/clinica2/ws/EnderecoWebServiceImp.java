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
        try {
            EnderecoService enderecoService = new EnderecoService();
            enderecoService.deletar(id);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Endereco inserir(Endereco endereco) {
        try {
            EnderecoService enderecoService = new EnderecoService();
            return enderecoService.inserir(endereco);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Endereco> listAll() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            return enderecoService.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @Override
    public Endereco findById(int id) {
        try {
            EnderecoService enderecoService = new EnderecoService();
            return enderecoService.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
