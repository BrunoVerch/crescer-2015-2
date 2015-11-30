package br.com.cwi.crescer.lavanderia.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

public class PedidoIncluirDTO {

    // toDo: validacao para form
    private Long idPedido;

    private Long idCliente;

    private Date dataInclusao;

    private Date dataEntrega;

    private BigDecimal valor;

    private List<Item> itens;

    private SituacaoPedido situacao;

    private BigDecimal valorDesconto;

    private BigDecimal valorFinal;

    public PedidoIncluirDTO(){}
    
    public PedidoIncluirDTO(Long idCliente){
    	this.idCliente = idCliente;
    }
    
    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdCliente() {
		return idCliente;
	}
    
    public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }

}
