package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;

public class ItemDTO {
	
	private Long id;

	private Long idPedido;
	
	private Long idProduto;
	
	private Long idServico;
	
	private Long idMaterial;
	
	private String descricaoServico;
	
	private String descricaoMaterial;
	
	@NotNull
	private BigDecimal peso;
	
	private BigDecimal valorUnitario;
	
	private BigDecimal valorTotal;
	
	private String situacao;
	
	private SituacaoItem situacaoItem;

	public ItemDTO(){}
	
	public ItemDTO(Long idPedido){
		this.idPedido=idPedido;
	}
	
	public SituacaoItem getSituacaoItem() {
		return situacaoItem;
	}
	public void setSituacaoItem(SituacaoItem situacaoItem) {
		this.situacaoItem = situacaoItem;
	}
	public Long getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	public Long getIdServico() {
		return idServico;
	}
	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDescricaoServico() {
		return descricaoServico;
	}

	public void setDescricaoServico(String descricaoServico) {
		this.descricaoServico = descricaoServico;
	}

	public String getDescricaoMaterial() {
		return descricaoMaterial;
	}

	public void setDescricaoMaterial(String descricaoMaterial) {
		this.descricaoMaterial = descricaoMaterial;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	
}
