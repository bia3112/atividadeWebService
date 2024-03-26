/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
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
    public Endereco atualizarEndereco(Endereco endereco) throws ValidacaoException, CampoPreenchidoException{
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.atualizarEndereco(endereco);
    }

    @Override
    public void deletarEndereco(int id) throws ValidacaoException {
        EnderecoService enderecoService = new EnderecoService();
        enderecoService.deletarEndereco(id);
    }

    @Override
    public Endereco inserirEndereco(Endereco endereco) throws ValidacaoException, CampoPreenchidoException {
            EnderecoService enderecoService = new EnderecoService();
            return enderecoService.inserirEndereco(endereco);
    }

    @Override
    public ArrayList<Endereco> listAllEndereco() {
        try {
            EnderecoService enderecoService = new EnderecoService();
            return enderecoService.listAllEndereco();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
   
    @Override
    public Endereco findByIdEndereco(int id) throws ValidacaoException, CampoPreenchidoException{
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.findByIdEndereco(id);
    }
    
}
