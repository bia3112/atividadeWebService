/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;

import jakarta.jws.WebService;
import br.unipar.clinica2.interfaces.PacienteWebService;
import br.unipar.clinica2.model.Paciente;
import br.unipar.clinica2.services.PacienteService;
import java.util.ArrayList;

/**
 *
 * @author vinid
 */
@WebService(endpointInterface = "br.unipar.clinica2.interfaces.PacienteWebService")
public class PacienteWerServicelmp implements PacienteWebService{

    @Override
    public ArrayList<Paciente> listAll() {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.listAll();
    }

    @Override
    public Paciente inserir(Paciente paciente) {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.inserir(paciente);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.atualizar(paciente);
    }

    @Override
    public void deletar(int id) {
        PacienteService pacienteService = new PacienteService();
        return pacienteService.deletar(id);
    }
    
}
