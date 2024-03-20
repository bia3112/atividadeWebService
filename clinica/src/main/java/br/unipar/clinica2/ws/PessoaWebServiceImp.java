/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.interfaces.PessoaWebService;
import br.unipar.clinica2.model.Pessoa;
import br.unipar.clinica2.services.PessoaService;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */

@WebService(endpointInterface = "br.unipar.clinica2.interfaces.PessoaWebService")
public class PessoaWebServiceImp implements PessoaWebService {

    @Override
    public Pessoa inserir(Pessoa pessoa) {
        PessoaService pessoaService = new PessoaService();
        return pessoaService.inserir(pessoa);
    }

    @Override
    public ArrayList<Pessoa> listAll() {
         PessoaService pessoaService = new PessoaService();
         return pessoaService.listAll();
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        PessoaService pessoaService = new PessoaService();
        return pessoaService.atualizar(pessoa);
    }

    @Override
    public void deletar(int id) {
        PessoaService pessoaService = new PessoaService();
        pessoaService.deletar(id);
    }
    
}
