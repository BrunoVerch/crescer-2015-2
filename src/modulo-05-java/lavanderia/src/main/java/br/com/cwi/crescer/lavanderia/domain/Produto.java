package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Produto")
@SequenceGenerator(name = Produto.SEQUENCE_NAME,sequenceName = Produto.SEQUENCE_NAME)
public class Produto {
	
	public static final String SEQUENCE_NAME = "SEQ_Produto";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDProduto")
	private Long idProduto;
	
	@ManyToOne
	@JoinColumn(name = "IDServico")
	private Servico servico;
	
	@ManyToOne
	@JoinColumn(name = "IDMaterial")
	private Material material;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	
	public Servico getServico() {
		return servico;
	}
	
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public void setMaterial(Material material) {
		this.material = material;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
