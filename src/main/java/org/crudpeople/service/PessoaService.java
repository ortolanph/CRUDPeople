package org.crudpeople.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.crudpeople.entities.Pessoa;
import org.crudpeople.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    private static final Logger LOGGER = Logger.getLogger(PessoaService.class.getName());

    public void create(Pessoa pessoa) {
        LOGGER.log(Level.INFO, "create");
        repository.insert(pessoa);
    }

    public List<Pessoa> find(String nome) {
        LOGGER.log(Level.INFO, "find");
        
        Query query = new Query();
        query.addCriteria(Criteria.where("nome").regex(nome));
        
        return mongoTemplate.find(query, Pessoa.class);
    }

    public List<Pessoa> findAll() {
        LOGGER.log(Level.INFO, "findAll");
        return repository.findAll();
    }
    
    public Pessoa findById(String id) {
        LOGGER.log(Level.INFO, "findById");
        return repository.findOne(id);
    }

    public void delete(String id) {
        LOGGER.log(Level.INFO, "delete");
        repository.delete(id);
    }

    public Pessoa update(Pessoa pessoa) {
        LOGGER.log(Level.INFO, "update");
        return repository.save(pessoa);
    }



}
