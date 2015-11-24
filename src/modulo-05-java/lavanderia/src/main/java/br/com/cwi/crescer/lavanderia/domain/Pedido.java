package br.com.cwi.crescer.lavanderia.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME,sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {

    public static final String SEQUENCE_NAME = "SEQ_Pedido";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
    @Column(name = "IDPedido")
    private Long idPedido;

    @ManyToOne
    @JoinColumn(name = "IDCliente")
    private Cliente cliente;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATAInclusao")
    @Basic(optional = false)
    private Date dataInclusao;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATAEntrega")
    @Basic(optional = false)
    private Date dataEntrega;

    @Column(name = "Valor")
    @Basic(optional = false)
    private BigDecimal valor;
    
    @OneToMany(mappedBy = "pedido")
	private List<Item> itens;

    @Column(name = "Situacao", length = 1)
    @Basic(optional = false)
    private SituacaoPedido situacao;

    public static enum SituacaoPedido {
        PENDENTE, PROCESSANDO, PROCESSADO, ENCERRADO, CANCELADO
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public SituacaoPedido getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoPedido situacao) {
        this.situacao = situacao;
    }
    
    public List<Item> getItens() {
		return itens;
	}
    
    public void setItens(List<Item> itens) {
		this.itens = itens;
	}
}
