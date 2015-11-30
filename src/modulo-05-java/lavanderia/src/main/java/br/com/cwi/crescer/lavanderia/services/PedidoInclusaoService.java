package br.com.cwi.crescer.lavanderia.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.DAO.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Service
public class PedidoInclusaoService {

	private ProdutoDAO produtoDao;
	private PedidoDAO pedidoDao;
	private DateService dateService;
	
	@Autowired
    public PedidoInclusaoService(PedidoDAO pedidoDao,ProdutoDAO produtoDao,DateService dateService){
        this.pedidoDao = pedidoDao;
        this.produtoDao = produtoDao;
        this.dateService=dateService;
    }
	
	public void cancelarPedido(Pedido pedido){
		pedido.setSituacao(SituacaoPedido.CANCELADO);
	}
	
	public void retirarPedido(Pedido pedido) throws Exception{
		if(pedido.getSituacao() == SituacaoPedido.PROCESSADO){
			pedido.setSituacao(SituacaoPedido.ENCERRADO);
		} else {
			throw new Exception("Não é possivel retirar o pedido que não foi processado!");
		}
	}
	
	public void valorBrutoPedido(Pedido pedido){
		pedido.setValor(totalValorItens(pedido));
	}
	
	public void calculaValorDesconto(Pedido pedido){
		BigDecimal percentualDeDesconto = percentualDoDesconto(pedido);
		BigDecimal valorDesconto = pedido.getValor().multiply(percentualDeDesconto).divide(new BigDecimal("100"));
		valorDesconto.setScale(2, BigDecimal.ROUND_DOWN);
		pedido.setValorDesconto(valorDesconto);
	}
	
	public void valorTotalPedido(Pedido pedido){
		valorBrutoPedido(pedido);
		calculaValorDesconto(pedido);
		BigDecimal valorTotal = pedido.getValor().subtract(pedido.getValorDesconto());
		pedido.setValorFinal(valorTotal);
	}
	
	public void dataDeEntrega(Pedido pedido){
		Long maiorPrazo = pegaMaiorPrazo(pedido.getItens());
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(pedido.getDataInclusao());
		calendar.add(calendar.DATE, maiorPrazo.intValue());
		
		pedido.setDataEntrega(calendar.getTime());
	}
	
	private Long pegaMaiorPrazo(List<Item> listaItens){
		Long maiorPrazo = 0L;
		for (Item item : listaItens) {
			maiorPrazo = item.getProduto().getPrazo() > maiorPrazo ? item.getProduto().getPrazo() : maiorPrazo;
		}
		return maiorPrazo;
	}
	
	//Operacoes com relacao ao desconto
	public BigDecimal percentualDoDesconto(Pedido pedido){
		final BigDecimal percentualDescontoPesoOuValor = new BigDecimal("4.87");
		final BigDecimal percentualDescontoSegundaQuarta = new BigDecimal("8.0");
		final BigDecimal percentualDescontoQuintaSexta = new BigDecimal("4.0");
		Date dataInclusao = pedido.getDataInclusao();
		BigDecimal percentualDesconto0 = new BigDecimal("0");
		
		if(dateService.ehDeSegundaAQuarta(dataInclusao)){
			return percentualDescontoSegundaQuarta;
		}
		if(descontoPodeSerPorPesoValor(totalQuantidadePeso(pedido),totalValorItens(pedido))){
			return percentualDescontoPesoOuValor;
		}
		if(dateService.ehQuintaOuSexta(dataInclusao)){
			return percentualDescontoQuintaSexta;
		}
		return percentualDesconto0;
	}
	
	public boolean descontoPodeSerPorPesoValor(BigDecimal peso,BigDecimal valor){
		return valor.compareTo(new BigDecimal("90")) > 0 || peso.compareTo(new BigDecimal("15")) > 0;
	}
	
	public BigDecimal totalQuantidadePeso(Pedido pedido){
		List<Item> itens = pedido.getItens();
		BigDecimal total = new BigDecimal(0);
		for(Item item : itens){
			total=total.add(item.getPeso());
		}
		return total;
	}
	
	//Operacoes com relacao ao item
	private BigDecimal totalValorItens(Pedido pedido){
		List<Item> itens = pedido.getItens();
		BigDecimal total = new BigDecimal(0);
		for(Item item : itens){
			total=total.add(totalDoItem(item));
		}
		return total;
	}
	private BigDecimal totalDoItem(Item item){
		BigDecimal peso = item.getPeso();
		BigDecimal valorProduto = item.getProduto().getValor();
		return peso.multiply(valorProduto);
	}
}
