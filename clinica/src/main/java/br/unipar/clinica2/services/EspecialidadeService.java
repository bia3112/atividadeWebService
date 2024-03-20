/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Repository.EspecialidadeRepository;
import br.unipar.clinica2.model.Especialidade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class EspecialidadeService {
      public Especialidade inserir(Especialidade especialidade) throws SQLException {
        EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
        return especialidadeRepository.insert(especialidade);
    }

    public ArrayList<Especialidade> listAll() {
        EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
        ArrayList<Especialidade> retorno = especialidadeRepository.listAll();
        return retorno;
    }

    public Especialidade atualizar(Especialidade especialidade) {
        EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
        return especialidadeRepository.atualizar(especialidade);
    }

    public void deletar(int id) {
        EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
        especialidadeRepository.deletar(id);
    }
    
    
}
