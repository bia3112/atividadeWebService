/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.model.Medico;
import br.unipar.clinica2.services.MedicoService;
import jakarta.jws.WebService;
import java.util.ArrayList;
import br.unipar.clinica2.interfaces.MedicoWebService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.duarte
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.MedicoWebService")
public class MedicoWebServiceImp  implements MedicoWebService {

    @Override
    public Medico inserir(Medico medico) {
        try {
            MedicoService medicoService = new MedicoService();
            return medicoService.inserir(medico);
        } catch (SQLException ex) {
            Logger.getLogger(MedicoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public ArrayList<Medico> listAll() {
       MedicoService medicoService = new MedicoService();
        return medicoService.listAll(); 
    }

    @Override
    public Medico atualizar(Medico medico) {
       MedicoService medicoService = new MedicoService();
        return medicoService.atualizar(medico);  
    }

    @Override
    public void deletar(int id) {
        MedicoService medicoService = new MedicoService();
        medicoService.deletar(id);
    }
    
}
