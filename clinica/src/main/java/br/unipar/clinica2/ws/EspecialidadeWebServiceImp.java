/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unipar.clinica2.ws;


import br.unipar.clinica2.Exception.CampoPreenchidoException;
import br.unipar.clinica2.Exception.ValidacaoException;
import br.unipar.clinica2.interfaces.EspecialidadeWebService;
import br.unipar.clinica2.model.Especialidade;
import br.unipar.clinica2.services.EspecialidadeService;
import jakarta.jws.WebService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinicius.duarte
 */

@WebService(endpointInterface = "br.unipar.clinica2.interfaces.EspecialidadeWebService")
public class EspecialidadeWebServiceImp  implements EspecialidadeWebService{
    
    @Override
    public Especialidade inserir(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException {
        EspecialidadeService especialidadeService = new EspecialidadeService() {};
        return especialidadeService.inserir(especialidade);
    }

    @Override
    public ArrayList<Especialidade> listAll() {
        try {
            EspecialidadeService especialidadeWebService = new EspecialidadeService();
            return especialidadeWebService.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadeWebServiceImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Especialidade atualizar(Especialidade especialidade) throws ValidacaoException, CampoPreenchidoException {
        EspecialidadeService especialidadeService = new EspecialidadeService();
        return especialidadeService.atualizar(especialidade);
    }

    @Override
    public void deletar(int id) throws ValidacaoException {
        EspecialidadeService especialidadeService = new EspecialidadeService();
        especialidadeService.deletar(id);
    }
    
    @Override
    public Especialidade findById(int id) throws ValidacaoException, CampoPreenchidoException {
        EspecialidadeService especialidadeService = new EspecialidadeService();
        return especialidadeService.findById(id);
    }
    
}
