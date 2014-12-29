package org.crudpeople.external.pessoa;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import org.crudpeople.entities.Pessoa;
import org.crudpeople.external.Result;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PessoaListResult {
    private Result result;
    private List<Pessoa> pessoas;

    public PessoaListResult() {
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
