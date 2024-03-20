/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;


import br.unipar.clinica2.interfaces.EspecialidadeWebService;
import br.unipar.clinica2.model.Especialidade;
import br.unipar.clinica2.services.EspecialidadeService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.duarte
 */

@WebService(endpointInterface = "br.unipar.clinica2.interfaces.EspecialidadeWebService")
public class EspecialidadeWebServiceImp  implements EspecialidadeWebService{
    
    @Override
    public Especialidade inserir(Especialidade especialidade) {
        EspecialidadeService especialidadeService = new EspecialidadeService() {};
        try {
            return especialidadeService.inserir(especialidade);
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadeWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return especialidade;
    }

    @Override
    public ArrayList<Especialidade> listAll() {
         EspecialidadeService especialidadeWebService = new EspecialidadeService();
         return especialidadeWebService.listAll();
    }

    @Override
    public Especialidade atualizar(Especialidade especialidade) {
        EspecialidadeService especialidadeService = new EspecialidadeService();
        return especialidadeService.atualizar(especialidade);
    }

    @Override
    public void deletar(int id) {
        EspecialidadeService especialidadeService = new EspecialidadeService();
        especialidadeService.deletar(id);
    }

    @Override
    public ArrayList<Especialidade> findEspecialidade(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Especialidade findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}