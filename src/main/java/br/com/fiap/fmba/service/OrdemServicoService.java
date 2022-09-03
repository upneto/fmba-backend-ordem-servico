package br.com.fiap.fmba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.fmba.controller.payload.OrdemServicoPayload;
import br.com.fiap.fmba.persistence.dao.OrdemServicoRepository;
import br.com.fiap.fmba.persistence.model.OrdemServico;
import br.com.fiap.fmba.persistence.model.TipoStatusServico;
import br.com.fiap.fmba.resources.exception.DaoException;

@Service
public class OrdemServicoService {

	@Autowired
	private OrdemServicoRepository repository;

	public OrdemServicoPayload find(long id) throws DaoException {
		try {
			OrdemServico ordemServico = this.repository.findById(id).get();
			return OrdemServicoPayload.builder()					
						.id(ordemServico.getId())
						.dataCriacao(ordemServico.getDataCriacao())
						.dataFinal(ordemServico.getDataFinal())
						.dataInicio(ordemServico.getDataInicio())
						.status(ordemServico.getStatusServico().getId())
						.veiculo(ordemServico.getVeiculoId())
						.cliente(ordemServico.getClienteId())
						.build();						
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public List<OrdemServicoPayload> findAll() throws DaoException {
		List<OrdemServicoPayload> ordens = new ArrayList<OrdemServicoPayload>();
		try {
			List<OrdemServico> findAll = this.repository.findAll();
			findAll.stream().forEach(ordemServico -> {
				ordens.add(OrdemServicoPayload.builder()					
						.id(ordemServico.getId())
						.dataCriacao(ordemServico.getDataCriacao())
						.dataFinal(ordemServico.getDataFinal())
						.dataInicio(ordemServico.getDataInicio())
						.status(ordemServico.getStatusServico().getId())
						.veiculo(ordemServico.getVeiculoId())
						.cliente(ordemServico.getClienteId())
						.build());
			});
			
			return ordens;
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public void insert(OrdemServicoPayload ordemServico) throws DaoException {
		try {
			this.repository.save(OrdemServico.builder()
					.dataCriacao(ordemServico.getDataCriacao())
					.dataFinal(ordemServico.getDataFinal())
					.dataInicio(ordemServico.getDataInicio())
					.statusServico(TipoStatusServico.builder().id(ordemServico.getStatus()).build())
					.veiculoId(ordemServico.getVeiculo())
					.clienteId(ordemServico.getCliente())
					.build());
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public void update(OrdemServicoPayload ordemServico) throws DaoException {
		try {
			this.repository.save(OrdemServico.builder()
					.id(ordemServico.getId())
					.dataCriacao(ordemServico.getDataCriacao())
					.dataFinal(ordemServico.getDataFinal())
					.dataInicio(ordemServico.getDataInicio())
					.statusServico(TipoStatusServico.builder().id(ordemServico.getStatus()).build())
					.veiculoId(ordemServico.getVeiculo())
					.clienteId(ordemServico.getCliente())
					.build());
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}

	public void delete(long id) throws DaoException {
		try {
			this.repository.deleteById(id);
		} catch (Exception e) {
			throw new DaoException(e.getMessage(), e);
		}
	}
}
