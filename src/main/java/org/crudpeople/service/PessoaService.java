package org.crudpeople.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.crudpeople.dao.PessoaDAO;
import org.crudpeople.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaDAO pessoaDAO;

    private static final Logger LOGGER = Logger.getLogger(PessoaService.class.getName());

    public void create(Pessoa pessoa) {
        LOGGER.log(Level.INFO, "create");
        pessoaDAO.create(pessoa);
    }

    public List<Pessoa> findAll() {
        LOGGER.log(Level.INFO, "findAll");
        return pessoaDAO.findAll();
    }

    public List<Pessoa> find(String nome) {
        LOGGER.log(Level.INFO, "find");
        return pessoaDAO.find(nome);
    }

}
