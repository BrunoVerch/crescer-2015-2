package br.com.cwi.crescer.lavanderia.services;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;

@Service
public class PedidoInclusaoService {

	private DateService dateService;
	
	@Autowired
    public PedidoInclusaoService(DateService dateService){
        this.dateService=dateService;
    }
	
	public void cancelarPedido(Pedido pedido){
		pedido.setSituacao(SituacaoPedido.CANCELADO);
	}
	
	public boolean retirarPedido(Pedido pedido){
		if(pedido.getSituacao() == SituacaoPedido.PROCESSADO){
			pedido.setSituacao(SituacaoPedido.ENCERRADO);
			return true;
		} else {
			return false;
		}
	}
	
	public void valorBrutoPedido(Pedido pedido){
		pedido.setValor(totalValorItens(pedido));
	}
	
	public void calculaDataValores(Pedido pedido){
		dataDeEntrega(pedido);
		calculaValorDesconto(pedido);
		valorTotalPedido(pedido);
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
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try{
			Date date = sdf.parse(sdf.format(calendar.getTime()));
			pedido.setDataEntrega(date);
		} catch(ParseException e){
			e.printStackTrace();
		}
	}
	
	public Long pegaMaiorPrazo(List<Item> listaItens){
		Long maiorPrazo = 0L;
		for (Item item : listaItens) {
			maiorPrazo = item.getProduto().getPrazo() > maiorPrazo ? item.getProduto().getPrazo() : maiorPrazo;
		}
		return maiorPrazo;
	}
	
	public void processarItens(List<Item> listaItens){
		for (Item item : listaItens) {
			item.setSituacao(SituacaoItem.PROCESSADO);
		}
	}
	
	public void processarUmItem(Item item){
		item.setSituacao(SituacaoItem.PROCESSADO);
	}
	
	public boolean itensEstaoProcessados(List<Item> listaItens){
		for (Item item : listaItens) {
			if(item.getSituacao() != SituacaoItem.PROCESSADO){
				return false;
			}
		}
		return false;
	}
	
	public void alterarParaProcessado(Pedido pedido){
		pedido.setSituacao(SituacaoPedido.PROCESSADO);
	}
	
	public void salvarPedido(Pedido pedido){
		pedido.setSituacao(SituacaoPedido.PROCESSANDO);
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
		BigDecimal total = new BigDecimal("0");
		for(Item item : itens){
			total=total.add(item.getPeso());
		}
		return total;
	}
	
	//Operacoes com relacao ao item
	public BigDecimal totalValorItens(Pedido pedido){
		List<Item> itens = pedido.getItens();
		BigDecimal total = new BigDecimal("0");
		for(Item item : itens){
			total=total.add(calculaValorTotal(item.getValorUnitario(), item.getPeso()));			
		}
		return total;
	}
	
	public BigDecimal calculaValorTotal(BigDecimal valorUnitario, BigDecimal peso) {
		return valorUnitario.multiply(peso);
	}
}
