package br.com.fiap.fmba.persistence.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the dt_ordem_servicos database table.
 * 
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="dt_ordem_servicos", schema = "fmba")
public class OrdemServico implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 6748462382703973190L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(name="data_criacao")
	private Date dataCriacao;

	@Column(name="data_final")
	private Date dataFinal;

	@Column(name="data_inicio")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInicio;

	@ManyToOne
	@JoinColumn(name="tipo_status_servico_id")	
	private TipoStatusServico statusServico;

	@Column(name="veiculo_servico_id")
	private BigInteger veiculoId;

	@Column(name="cliente_servico_id")
	private BigInteger clienteId;

}