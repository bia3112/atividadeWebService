/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.model.Pessoa;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
public class PessoaService {

    public Pessoa inserir(Pessoa pessoa) {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.insert(pessoa);
    }

    public ArrayList<Pessoa> listAll() {
        PessoaRepository pessoaRepository = new PessoaRepository();
        ArrayList<Pessoa> retorno = pessoaRepository.listAll();
        return retorno;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        PessoaRepository pessoaRepository = new PessoaRepository();
        return pessoaRepository.atualizar(pessoa);
    }

    public void deletar(int id) {
        PessoaRepository pessoaRepository = new PessoaRepository();
        pessoaRepository.deletar(id);
    }
    
}
