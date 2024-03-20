/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.interfaces.MedicoWebService1;
import br.unipar.clinica2.model.Medico;
import br.unipar.clinica2.services.MedicoService;
import jakarta.jws.WebService;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.MedicoWebService1")
public class MedicoWebServiceImp  implements MedicoWebService1 {

    @Override
    public ArrayList<Medico> findMedico(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Medico> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String logar(String login, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico inserir(Medico medico) {
        MedicoService medicoService = new MedicoService();
        return medicoService.inserir(medico);
        return medico;
    }

    @Override
    public Medico atualizar(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(int id) {
        MedicoService medicoService = new MedicoService();
        medicoService.deletar(id);
    }

    
    

//
//    @Override
//    public Medico atualizar(Medico medico) {
//        MedicoService medicoService = new MedicoService();
//        return medicoService.atualizar(medico);
//    }
/
//
//    @Override
//    public ArrayList<Medico> findMedico(String nome) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public Medico findById(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String logar(String login, String senha) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public ArrayList<Medico> listAll() {
//        MedicoService medicoService = new MedicoService();
//         return medicoService.listAll();
//    }
    
}
