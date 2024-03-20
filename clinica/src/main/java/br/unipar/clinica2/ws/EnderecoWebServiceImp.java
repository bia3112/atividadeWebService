/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.interfaces.EnderecoWebService;
import br.unipar.clinica2.model.Endereco;
import br.unipar.clinica2.services.EnderecoService;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author Beatr
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.EnderecoWebService")
public class EnderecoWebServiceImp implements EnderecoWebService{

    @Override
    public Endereco inserir(Endereco endereco) {
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.inserir(endereco);
    }

    @Override
    public ArrayList<Endereco> listAll() {
         EnderecoService enderecoService = new EnderecoService();
        return enderecoService.listAll();
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        EnderecoService enderecoService = new EnderecoService();
        return enderecoService.atualizar(endereco);
    }

    @Override
    public void deletar(int id) {
        EnderecoService enderecoService = new EnderecoService();
        enderecoService.deletar(id);
    }
    
}
