package br.com.fiap.fmba.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.fmba.persistence.model.OrdemServico;

public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {

}
