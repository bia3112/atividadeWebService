/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Repository.EnderecoRepository;
import br.unipar.clinica2.model.Endereco;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class EnderecoService {

    public Endereco inserir(Endereco endereco) throws SQLException {
       
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.inserir(endereco);
        return endereco;
    }

//    public ArrayList<Endereco> listAll() throws SQLException {
//<<<<<<< HEAD
//        EnderecoRepository enderecoRepository = new EnderecoRepository();
//        ArrayList<Endereco> retorno = enderecoRepository.listAll();
//        return retorno;
//=======
//         EnderecoService enderecoService = new EnderecoService();
//        return enderecoService.listAll();
//>>>>>>> 50241eb058ed048c700c8a2fd875e63f62849f91
//    }

    public Endereco atualizar(Endereco endereco) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.update(endereco);
        return endereco;
        
    }

    public void deletar(String logradouro) throws SQLException {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.delete(logradouro);
    }
    
}
