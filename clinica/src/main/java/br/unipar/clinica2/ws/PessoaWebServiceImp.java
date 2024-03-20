/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.interfaces.PessoaWebService;
import br.unipar.clinica2.model.Pessoa;
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
        
    }

    @Override
    public ArrayList<Pessoa> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pessoa atualizar(Pessoa pessoa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
