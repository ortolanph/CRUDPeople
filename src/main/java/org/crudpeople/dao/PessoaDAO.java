package org.crudpeople.dao;

import java.util.List;
import org.crudpeople.entities.Pessoa;

public interface PessoaDAO {
    void create(Pessoa pessoa);
    
    List<Pessoa> findAll();
    
    List<Pessoa> find(String nome);
    
    Pessoa findById(Integer id);
    
    Pessoa update(Pessoa pessoa);
    
    boolean delete(Integer id);
}
