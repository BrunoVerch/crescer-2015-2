package br.com.cwi.crescer.lavanderia.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cidade")
//@SequenceGenerator(name = Cidade.SEQUENCE_NAME,sequenceName = Cidade.SEQUENCE_NAME)
public class Cidade {
	
	//public static final String SEQUENCE_NAME = "cidade_seq";
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDCidade")
	private Long idCidade;
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "UF", length = 2)
	@Basic(optional = false)
	private Long uf;

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getUf() {
		return uf;
	}

	public void setUf(Long uf) {
		this.uf = uf;
	}
}
