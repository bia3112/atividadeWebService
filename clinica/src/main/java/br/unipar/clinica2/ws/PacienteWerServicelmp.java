/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
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
    public ArrayList<Paciente> listAllPaciente() {
        try {
            PacienteService pacienteService = new PacienteService();
            return pacienteService.listAllPaciente();
        } catch (SQLException ex) {
            Logger.getLogger(PacienteWerServicelmp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Paciente inserirPaciente(Paciente paciente) throws ValidacaoException, CampoPreenchidoException{
        PacienteService pacienteService = new PacienteService();
        return pacienteService.inserirPaciente(paciente);
    }

    @Override
    public Paciente atualizarPaciente(Paciente paciente) throws ValidacaoException, CampoPreenchidoException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.atualizarPaciente(paciente);
    }

    @Override
    public Paciente deletarPaciente(Paciente paciente) throws ValidacaoException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.deletarPaciente(paciente);
    }

    @Override
    public Paciente findByIdPaciente(int id) throws ValidacaoException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.findByIdPaciente(id);
    }
    
}
