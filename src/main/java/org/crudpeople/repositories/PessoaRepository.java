package org.crudpeople.repositories;

import org.crudpeople.entities.Pessoa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(
    domainClass=org.crudpeople.entities.Pessoa.class,
    idClass=java.lang.String.class)
public interface PessoaRepository extends MongoRepository<Pessoa, String>{
    
}
