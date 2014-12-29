package org.crudpeople.external.pessoa;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.crudpeople.entities.Pessoa;
import org.crudpeople.external.Result;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaResult {
    private Result result;
    private Pessoa pessoa;

    public PessoaResult() {
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
