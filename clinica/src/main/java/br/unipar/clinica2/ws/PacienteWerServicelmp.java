/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import jakarta.jws.WebService;
import br.unipar.clinica2.interfaces.PacienteWebService;
import br.unipar.clinica2.model.Paciente;
import br.unipar.clinica2.services.PacienteService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinid
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.PacienteWebService")
public class PacienteWerServicelmp implements PacienteWebService{

    @Override
    public ArrayList<Paciente> listAll() {
        try {
            PacienteService pacienteService = new PacienteService();
            return pacienteService.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Paciente inserir(Paciente paciente) {
        try {
            PacienteService pacienteService = new PacienteService();
            return pacienteService.inserir(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        try {
            PacienteService pacienteService = new PacienteService();
            return pacienteService.atualizar(paciente);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deletar(int id) {
        try {
            PacienteService pacienteService = new PacienteService();
            pacienteService.deletar(id);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Paciente findById(int id) {
        try {
            PacienteService pacienteService = new PacienteService();
            return pacienteService.findById(id);
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
