package org.crudpeople.entities;

import java.util.Objects;
import javax.persistence.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pessoas")
public class Pessoa {

    private String id;
    private String nome;
    private String endereco;
    private String telefone;
    
    @Transient
    private static final String TO_STRING = "Pessoa {id=%s, nome=%s, endereco=%s, telefone=%s }";

    public Pessoa() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(TO_STRING, id, nome, endereco, telefone);
    }
    
    
}
