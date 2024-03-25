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
    public Paciente inserir(Paciente paciente) throws ValidacaoException, CampoPreenchidoException{
        PacienteService pacienteService = new PacienteService();
        return pacienteService.inserir(paciente);
    }

    @Override
    public Paciente atualizar(Paciente paciente) throws ValidacaoException, CampoPreenchidoException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.atualizar(paciente);
    }

    @Override
    public void deletar(int id) throws ValidacaoException {
        PacienteService pacienteService = new PacienteService();
        pacienteService.deletar(id);
    }

    @Override
    public Paciente findById(int id) throws ValidacaoException, CampoPreenchidoException {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.findById(id);
    }
    
}
