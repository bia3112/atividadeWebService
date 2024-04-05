/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
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
    public Medico inserirmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException {
        MedicoService medicoService = new MedicoService();
        return medicoService.inserirmedico(medico);
    }

    @Override
    public ArrayList<Medico> listAllMedico() {
        try {
            MedicoService medicoService = new MedicoService(); 
            return medicoService.listAllMedico();
        } catch (SQLException ex) {
            Logger.getLogger(MedicoWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Medico atualizarmedico(Medico medico) throws ValidacaoException, CampoPreenchidoException {
        MedicoService medicoService = new MedicoService();  
        return medicoService.atualizarmedico(medico);
    }

    @Override
    public Medico deletarmedico(Medico medico) throws ValidacaoException {
        MedicoService medicoService = new MedicoService();
        return medicoService.deletarmedico(medico);
    }
    
    @Override
    public Medico findByIdmedico(int id) throws ValidacaoException {
        MedicoService medicoService = new MedicoService();
        return medicoService.findByIdmedico(id);
    }
    
}
