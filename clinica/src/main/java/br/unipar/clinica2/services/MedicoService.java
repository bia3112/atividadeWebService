/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Repository.MedicoRepository;
import br.unipar.clinica2.model.Medico;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class MedicoService {
     public Medico inserir(Medico medico) {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.insert(medico);
    }

    public ArrayList<Medico> listAll() {
        MedicoRepository medicoRepository = new MedicoRepository();
        ArrayList<Medico> retorno = medicoRepository.listAll();
        return retorno;
    }

    public Medico atualizar(Medico medico) {
        MedicoRepository medicoRepository = new MedicoRepository();
        return medicoRepository.atualizar(medico);
    }

    public void deletar(int id) {
        MedicoRepository medicoRepository = new MedicoRepository();
        medicoRepository.deletar(id);
    }
}
