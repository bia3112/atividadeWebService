/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.model.Endereco;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class EnderecoService {

    public Endereco inserir(Endereco endereco) {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        return enderecoRepository.inserir(endereco);
    }

    public ArrayList<Endereco> listAll() {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        ArrayList<Endereco> retorno = enderecoRepository.listAll();
        return retorno;
    }

    public Endereco atualizar(Endereco endereco) {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        return enderecoRepository.atualizar(endereco);
    }

    public void deletar(int id) {
        EnderecoRepository enderecoRepository = new EnderecoRepository();
        enderecoRepository.deletar(id);
    }
    
}
