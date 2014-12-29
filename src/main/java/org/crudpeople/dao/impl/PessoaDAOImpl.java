package org.crudpeople.dao.impl;

import com.google.common.collect.Lists;
import java.util.List;
import org.crudpeople.dao.PessoaDAO;
import org.crudpeople.entities.Pessoa;

public class PessoaDAOImpl implements PessoaDAO {

    private final List<Pessoa> pessoas = Lists.newArrayList();
    private Integer lastId = 0;
    
    @Override
    public void create(Pessoa pessoa) {
        lastId++;
        pessoa.setId(lastId);
        pessoas.add(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        return Lists.newArrayList(pessoas);
    }
    
    @Override
    public List<Pessoa> find(String nome) {
        List<Pessoa> results = Lists.newArrayList();
        
        for(Pessoa pessoa : pessoas) {
            if(pessoa.getNome().contains(nome)) {
                results.add(pessoa);
            }
        }
        
        return results;
    }

    @Override
    public Pessoa findById(Integer id) {
        for(Pessoa pessoa : pessoas) {
            if(pessoa.getId().equals(id)) {
                return pessoa;
            }
        }
        
        return null;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        for(int index = 0; index < pessoas.size(); index++) {
            if(pessoas.get(index).getId().equals(pessoa.getId())) {
                pessoas.set(index, pessoa);
                return pessoa;
            }
        }
        
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        for(Pessoa pessoa : pessoas) {
            if(pessoa.getId().equals(id)) {
                return pessoas.remove(pessoa);
            }
        }
        
        return false;
    }
    
}
