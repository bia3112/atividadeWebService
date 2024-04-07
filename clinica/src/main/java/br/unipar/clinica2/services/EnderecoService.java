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

    public Endereco inserirEndereco(Endereco endereco) throws ValidacaoException, CampoPreenchidoException {
       
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
        
        if(endereco.getCidade() == null) {
            throw new CampoPreenchidoException("cidade");
        }
        
        if(endereco.getUf() == null) {
            throw new CampoPreenchidoException("uf");
        }
        
        if(endereco.getCep() == null) {
            throw new CampoPreenchidoException("cep");
        }
  
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.inserirEndereco(endereco);
        } catch(SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
        
    }

    public ArrayList<Endereco> listAllEndereco()throws ValidacaoException {
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            ArrayList<Endereco> retorno = enderecoRepository.listAllEndereco();
            return retorno;
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }

    public Endereco atualizarEndereco(Endereco endereco) throws ValidacaoException, CampoPreenchidoException {
        
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
        
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.atualizarEndereco(endereco);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
  
    }

    public Endereco deletarEndereco(Endereco endereco) throws ValidacaoException {

        if(endereco.getIdEndereco() <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
        
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.deletarEndereco(endereco);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }

    }
    
    public Endereco findByIdEndereco(int id) throws ValidacaoException {

        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
            
        try {
            EnderecoRepository enderecoRepository = new EnderecoRepository();
            return enderecoRepository.findByIdEndereco(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
}
