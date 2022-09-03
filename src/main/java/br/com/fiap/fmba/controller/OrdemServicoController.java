package br.com.fiap.fmba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.fmba.controller.payload.OrdemServicoPayload;
import br.com.fiap.fmba.resources.exception.DaoException;
import br.com.fiap.fmba.service.OrdemServicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/")
public class OrdemServicoController {

	@Autowired
	private OrdemServicoService service;
	
	@ApiOperation(value = "Pesquisa todas as Ordens de Servico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna lista de Ordens de Servico"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(produces="application/json")
	public ResponseEntity<List<OrdemServicoPayload>> findAll() throws DaoException {
		return new ResponseEntity<>(this.service.findAll(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Pesquisa Ordem de Servico por ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna OrdemServico"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@GetMapping(value = "/{id}", produces="application/json", consumes="application/json")
	public ResponseEntity<OrdemServicoPayload> findBy(@PathVariable long id) throws DaoException {
		return new ResponseEntity<>(this.service.find(id), HttpStatus.OK);
	}
	
	@ApiOperation(value = "Grava nova Ordem de Servico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Gravou Ordem de Servico com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PostMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> insert(@RequestBody OrdemServicoPayload pessoa) throws DaoException {
		this.service.insert(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Altera Ordem de Servico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Alterou Ordem de Servico com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@PutMapping(produces="application/json", consumes="application/json")
	public ResponseEntity<?> update(@RequestBody OrdemServicoPayload pessoa) throws DaoException {
		this.service.update(pessoa);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value = "Remove Ordem de Servico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Removeu Ordem de Servico com sucesso"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
	@DeleteMapping(value = "/{id}", produces="application/json", consumes="application/json")
	public ResponseEntity<?> delete(@PathVariable long id) throws DaoException {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
