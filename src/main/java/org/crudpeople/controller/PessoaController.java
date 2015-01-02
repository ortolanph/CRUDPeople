package org.crudpeople.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.crudpeople.entities.Pessoa;
import org.crudpeople.external.Result;
import org.crudpeople.external.ResultStatus;
import org.crudpeople.external.pessoa.PessoaListResult;
import org.crudpeople.external.pessoa.PessoaResult;
import org.crudpeople.external.simple.SimpleResult;
import org.crudpeople.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/crudpeople/peopleservice/*",
        produces = {"application/json;charset=UTF-8"})
public class PessoaController {

    @Autowired
    private PessoaService service;

    private static final Logger LOGGER = Logger.getLogger(PessoaController.class.getName());

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
    public @ResponseBody
    SimpleResult create(@RequestBody Pessoa pessoa) {
        LOGGER.log(Level.INFO, "Serviço /create");
        service.create(pessoa);

        SimpleResult result = new SimpleResult();
        result.setResult("Pessoa cadastrada com sucesso!");

        return result;
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public @ResponseBody
    PessoaListResult findAll() {
        LOGGER.log(Level.INFO, "Serviço /findAll");

        return renderResult(service.findAll());
    }

    @RequestMapping(value = "/find/{nome}", method = RequestMethod.GET)
    public @ResponseBody
    PessoaListResult find(@PathVariable String nome) {
        LOGGER.log(Level.INFO, "Serviço /find/{0}", nome);

        List<Pessoa> pessoas = service.find(nome);

        return renderResult(pessoas);
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public @ResponseBody
    PessoaResult findById(@PathVariable String id) {
        LOGGER.log(Level.INFO, "Serviço /findById/{0}", id);

        Pessoa pessoa = service.findById(id);

        PessoaResult result = new PessoaResult();

        result.setPessoa(pessoa);

        Result innerResult = new Result();

        if (pessoa != null) {
            innerResult.setMessage("Pessoa recuperada com sucesso!");
            innerResult.setStatus(ResultStatus.SUCCESS);
        } else {
            innerResult.setMessage("Houve um erro ao recuperar a pessoa");
            innerResult.setStatus(ResultStatus.FAIL);
        }

        result.setResult(innerResult);

        return result;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = {"application/json;charset=UTF-8"})
    public @ResponseBody
    PessoaResult update(@RequestBody Pessoa pessoa) {
        LOGGER.log(Level.INFO, "Serviço /update");
        Pessoa pessoaAtualizada = service.update(pessoa);

        PessoaResult result = new PessoaResult();

        result.setPessoa(pessoaAtualizada);

        Result innerResult = new Result();

        if (pessoa != null) {
            innerResult.setMessage("Pessoa atualizada com sucesso!");
            innerResult.setStatus(ResultStatus.SUCCESS);
        } else {
            innerResult.setMessage("Houve um erro ao atualizar a pessoa");
            innerResult.setStatus(ResultStatus.FAIL);
        }

        result.setResult(innerResult);

        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public @ResponseBody
    SimpleResult delete(@PathVariable String id) {
        LOGGER.log(Level.INFO, "Serviço /delete/{0}", id);

        SimpleResult result = new SimpleResult();

        service.delete(id);
        result.setResult("Deletado com sucesso");

        return result;
    }

    private PessoaListResult renderResult(List<Pessoa> pessoas) {
        PessoaListResult result = new PessoaListResult();

        result.setPessoas(pessoas);

        Result internalResult = new Result();

        if (pessoas.isEmpty()) {
            internalResult.setMessage("Nenhum registro encontrado!");
            internalResult.setStatus(ResultStatus.WARNING);
        } else {
            internalResult.setMessage(String.format("%d registro(s) encontrado(s)", pessoas.size()));
            internalResult.setStatus(ResultStatus.SUCCESS);
        }

        result.setResult(internalResult);

        return result;
    }

}
