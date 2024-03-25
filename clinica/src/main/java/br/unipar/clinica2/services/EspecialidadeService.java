/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.services;

import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.Repository.EspecialidadeRepository;
import br.unipar.clinica2.model.Especialidade;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinicius.duarte
 */
public class EspecialidadeService {
    
      public Especialidade inserir(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException{
          
        if(especialidade.getNome().length() <= 8) {
            throw new ValidacaoException("Nome deve possuir"
                    + " mais de 8 caracteres.");
        }
        if(especialidade.getNome() == null) {
            throw new CampoPreenchidoException("nome");
        }
          
        try {
            EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
            return especialidadeRepository.inserir(especialidade);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }

    public ArrayList<Especialidade> listAll() throws SQLException {
        EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
        ArrayList<Especialidade> retorno = especialidadeRepository.listAll();
        return retorno;
    }

    public Especialidade atualizar(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException {
        
        if(especialidade.getNome().length() <= 8) {
            throw new ValidacaoException("Nome deve possuir"
                    + " mais de 8 caracteres.");
        }
        if(especialidade.getNome() == null) {
            throw new CampoPreenchidoException("nome");
        }
        
        try {
            EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
            return especialidadeRepository.atualizar(especialidade);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }

    public void deletar(int id) throws ValidacaoException {
        try {
            EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
            especialidadeRepository.deletar(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
    
    public Especialidade findById(int id) throws ValidacaoException, CampoPreenchidoException {
        
        if(id <= 0) {
            throw new ValidacaoException("Número de caracteres inválido.");
        }
        
        try {
            EspecialidadeRepository especialidadeRepository = new EspecialidadeRepository();
            return especialidadeRepository.findById(id);
        } catch (SQLException ex) {
            throw new ValidacaoException("Erro Interno de Servidor");
        }
    }
}
