/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.EnderecoRepository;
import br.unipar.clinica2.model.Endereco;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Beatr
 */
public class EnderecoService {

    public Endereco inserir(Endereco endereco) throws ValidacaoException, CampoPreenchidoException {
       
        if(endereco.getBairro().length() <= 3) {
            throw new ValidacaoException("Bairro deve possuir"
                   + " mais do que 3 caracteres.");
        }
        if(endereco.getBairro() == null) {
            throw new CampoPreenchidoException("bairro");
        }
        
        if(endereco.getLogradouro().length() <= 3) {
            throw new ValidacaoException("Logradouro deve possuir"
                    + " mais do que 3 caracteres.");
        }
        if(endereco.getLogradouro() == null) {
            throw new CampoPreenchidoException("logradouro");
        }
         
        if(endereco.getComplemento().length() <= 3) {
            throw new ValidacaoException("Complemento deve possuir"
                    + " mais do que 3 caracteres.");
        }
  
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.inserir(endereco);
        } catch(SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public ArrayList<Endereco> listAll() throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        ArrayList<Endereco> retorno = enderecoRepository.listAll();
        return retorno;
    }

    public Endereco atualizar(Endereco endereco) throws ValidacaoException, CampoPreenchidoException {
        
        if(endereco.getBairro().length() <= 3) {
            throw new ValidacaoException("Bairro deve possuir"
                   + " mais do que 3 caracteres.");
        }
        if(endereco.getBairro() == null) {
            throw new CampoPreenchidoException("bairro");
        }
        
        if(endereco.getLogradouro().length() <= 3) {
            throw new ValidacaoException("Logradouro deve possuir"
                    + " mais do que 3 caracteres.");
        }
        if(endereco.getLogradouro() == null) {
            throw new CampoPreenchidoException("logradouro");
        }
         
        if(endereco.getComplemento().length() <= 3) {
            throw new ValidacaoException("Complemento deve possuir"
                    + " mais do que 3 caracteres.");
        }
        
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.atualizar(endereco);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
  
    }

    public void deletar(int id) throws ValidacaoException {

        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            enderecoRepository.deletar(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
    public Endereco findById(int id) throws ValidacaoException, CampoPreenchidoException {
        
//        if(id == null) {
//            throw new CampoPreenchidoException("id");
//        } 

        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
            
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.findById(id);
        } catch (SQLException ex) {
            throw new CampoPreenchidoException("Erro Interno de Servidor");
        }
    }
    
}
