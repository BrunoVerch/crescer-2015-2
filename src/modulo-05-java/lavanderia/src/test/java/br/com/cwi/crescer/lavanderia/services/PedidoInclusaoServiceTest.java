package br.com.cwi.crescer.lavanderia.services;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;

public class PedidoInclusaoServiceTest {

	@Test
	public void deveCancelarPedido(){
		Pedido pedido = new Pedido();
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.cancelarPedido(pedido);
		
		assertEquals(SituacaoPedido.CANCELADO, pedido.getSituacao());
	}
	
	@Test
	public void consegueRetirarPedido() throws Exception{
		Pedido pedido = new Pedido();
		pedido.setSituacao(SituacaoPedido.PROCESSADO);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.retirarPedido(pedido);
		
		assertEquals(SituacaoPedido.ENCERRADO, pedido.getSituacao());
	}
	
	@Test
	public void naoConsegueRetirarPedido() throws Exception{
		Pedido pedido = new Pedido();
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		boolean resposta = pedidoInclusaoService.retirarPedido(pedido);
		
		Assert.assertFalse(resposta);
	}
	
	@Test
	public void calculaValorTotalDosItens(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();      
        item1.setValorUnitario(new BigDecimal(4));
        item2.setValorUnitario(new BigDecimal(4));
        item3.setValorUnitario(new BigDecimal(4));       
        item1.setPeso(new BigDecimal(4));
        item2.setPeso(new BigDecimal(4));
        item3.setPeso(new BigDecimal(4));      
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal total = pedidoInclusaoService.totalValorItens(pedido);
        
		assertEquals(total, new BigDecimal("48"));
	}
	
	@Test
	public void calculaValorTotalDeUmItem(){
		Item item = new Item();
		item.setPeso(new BigDecimal("5"));
		item.setValorUnitario(new BigDecimal("5"));
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal resultado = pedidoInclusaoService.calculaValorTotal(item.getValorUnitario(), item.getPeso());
		
		assertEquals(new BigDecimal("25"),resultado);
	}
	
	@Test
	public void totalQuantidadePeso(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();      
        item1.setPeso(new BigDecimal(4));
        item2.setPeso(new BigDecimal(4));
        item3.setPeso(new BigDecimal(4));      
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal total = pedidoInclusaoService.totalQuantidadePeso(pedido);
        
		assertEquals(new BigDecimal("12"),total);
	}
	
	@Test
	public void descontoPodeSerPorPesoValor(){
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		boolean total = pedidoInclusaoService.descontoPodeSerPorPesoValor(new BigDecimal("16"), new BigDecimal("91"));
        
		assertTrue(total);
	}
	
	@Test
	public void pegaMaiorPrazo(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        p1.setPrazo(1L);
        p2.setPrazo(2L);
        p3.setPrazo(3L);
        item1.setProduto(p1);
        item2.setProduto(p2);
        item3.setProduto(p3);             
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		Long total = pedidoInclusaoService.pegaMaiorPrazo(itens);
        boolean resultado = total.compareTo(3L) == 0;
		assertTrue(resultado);
	}
	
	@Test
	public void dataDeEntrega() throws ParseException{
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        p1.setPrazo(1L);
        p2.setPrazo(2L);
        p3.setPrazo(3L);
        item1.setProduto(p1);
        item2.setProduto(p2);
        item3.setProduto(p3);             
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("04/12/2015");
        pedido.setDataInclusao(date);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		Date esperada = sdf.parse("07/12/2015");
		pedidoInclusaoService.dataDeEntrega(pedido);
        
		boolean resultado = pedido.getDataEntrega().compareTo(esperada) == 0;
		assertTrue(resultado);
	}
	
	@Test
	public void alteraPedidoParaProcessado(){
		Pedido pedido = new Pedido();   
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.alterarParaProcessado(pedido);
        
		assertEquals(pedido.getSituacao(),SituacaoPedido.PROCESSADO);
	}
	
	@Test
	public void salvaPedidoalterandoParaProcessando(){
		Pedido pedido = new Pedido();   
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.salvarPedido(pedido);
        
		assertEquals(pedido.getSituacao(),SituacaoPedido.PROCESSANDO);
	}
	
	@Test
	public void verificaSeItensEstaoProcessadosRetornandoVerdadeiro(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();      
        item1.setSituacao(SituacaoItem.PROCESSADO);
        item2.setSituacao(SituacaoItem.PROCESSADO);
        item3.setSituacao(SituacaoItem.PROCESSADO);      
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		boolean resultado = pedidoInclusaoService.itensEstaoProcessados(pedido.getItens());
        
		assertTrue(resultado);
	}
	
	@Test
	public void calculaValorDesconto() throws ParseException{
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        p1.setPrazo(1L);
        p2.setPrazo(2L);
        p3.setPrazo(3L);
        item1.setProduto(p1);
        item2.setProduto(p2);
        item3.setProduto(p3);
        item1.setValorUnitario(new BigDecimal("5"));
        item2.setValorUnitario(new BigDecimal("5"));
        item3.setValorUnitario(new BigDecimal("5"));
        item1.setPeso(new BigDecimal("3"));
        item2.setPeso(new BigDecimal("3"));
        item3.setPeso(new BigDecimal("3"));
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("01/12/2015");
        pedido.setDataInclusao(date);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.calculaValorDesconto(pedido);
		
		assertEquals(new BigDecimal("3.6"),pedido.getValorDesconto());
	}
	
	@Test
	public void calculaDataValores() throws ParseException{
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();
        Produto p1 = new Produto();
        Produto p2 = new Produto();
        Produto p3 = new Produto();
        p1.setPrazo(1L);
        p2.setPrazo(2L);
        p3.setPrazo(3L);
        item1.setProduto(p1);
        item2.setProduto(p2);
        item3.setProduto(p3);
        item1.setValorUnitario(new BigDecimal("5"));
        item2.setValorUnitario(new BigDecimal("5"));
        item3.setValorUnitario(new BigDecimal("5"));
        item1.setPeso(new BigDecimal("3"));
        item2.setPeso(new BigDecimal("3"));
        item3.setPeso(new BigDecimal("3"));
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("01/12/2015");
        pedido.setDataInclusao(date);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.calculaDataValores(pedido);
		
		assertEquals(new BigDecimal("3.6"),pedido.getValorDesconto());
		assertEquals(new BigDecimal("41.4"),pedido.getValorFinal());
		assertEquals(sdf.parse("04/12/2015"),pedido.getDataEntrega());
	}
	
	@Test
	public void processarItens(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();      
        item1.setSituacao(SituacaoItem.PROCESSANDO);
        item2.setSituacao(SituacaoItem.PROCESSANDO);
        item3.setSituacao(SituacaoItem.PROCESSANDO);      
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.processarItens(pedido.getItens());
		
		assertEquals(SituacaoItem.PROCESSADO,item1.getSituacao());
		assertEquals(SituacaoItem.PROCESSADO,item2.getSituacao());
		assertEquals(SituacaoItem.PROCESSADO,item3.getSituacao());
	}
	
	@Test
	public void verificaSeItensEstaoProcessadosRetornandoFalso(){
		Pedido pedido = new Pedido();
		Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        List<Item> itens = new ArrayList<Item>();      
        item1.setSituacao(SituacaoItem.PROCESSADO);
        item2.setSituacao(SituacaoItem.PENDENTE);
        item3.setSituacao(SituacaoItem.PROCESSADO);      
        itens.add(item1);
        itens.add(item2);
        itens.add(item3);     
        pedido.setItens(itens);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		boolean resultado = pedidoInclusaoService.itensEstaoProcessados(pedido.getItens());
        
		assertFalse(resultado);
	}
	
	@Test
	public void processaUmItem(){
		Item item1 = new Item();     
        item1.setSituacao(SituacaoItem.PENDENTE);
        DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		pedidoInclusaoService.processarUmItem(item1);
        
		assertEquals(item1.getSituacao(),SituacaoItem.PROCESSADO);
	}
	
	@Test
	public void percentualDeDescontoEhDeSegundaAQuarta() throws ParseException{
		Pedido pedido = new Pedido();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("01/12/2015");
		pedido.setDataInclusao(date);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal resultado = pedidoInclusaoService.percentualDoDesconto(pedido);
		
		assertEquals(new BigDecimal("8.0"),resultado);
	}
	
	@Test
	public void percentualDeDescontoEhDeQuintaOuSexta() throws ParseException{
		Pedido pedido = new Pedido();
		Item item = new Item();
		item.setPeso(new BigDecimal("1"));
		item.setValorUnitario(new BigDecimal("2"));
        List<Item> itens = new ArrayList<Item>();
        itens.add(item);
        pedido.setItens(itens);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("26/11/2015");
		pedido.setDataInclusao(date);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal resultado = pedidoInclusaoService.percentualDoDesconto(pedido);
		
		assertEquals(new BigDecimal("4.0"),resultado);
	}
	
	@Test
	public void percentualDeDescontoEhPorPesoEValor() throws ParseException{
		Pedido pedido = new Pedido();
		Item item = new Item();
		item.setPeso(new BigDecimal("16"));
		item.setValorUnitario(new BigDecimal("93"));
        List<Item> itens = new ArrayList<Item>();
        itens.add(item);
        pedido.setItens(itens);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("26/11/2015");
		pedido.setDataInclusao(date);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal resultado = pedidoInclusaoService.percentualDoDesconto(pedido);
		
		assertEquals(new BigDecimal("4.87"),resultado);
	}
	
	@Test
	public void percentualDeDescontoEh0DataIgualDomigo() throws ParseException{
		Pedido pedido = new Pedido();
		Item item = new Item();
		item.setPeso(new BigDecimal("1"));
		item.setValorUnitario(new BigDecimal("2"));
        List<Item> itens = new ArrayList<Item>();
        itens.add(item);
        pedido.setItens(itens);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");          
        Date date = sdf.parse("26/12/2015");
		pedido.setDataInclusao(date);
		DateService dateService = new DateService();
		PedidoInclusaoService pedidoInclusaoService = new PedidoInclusaoService(dateService);
		
		BigDecimal resultado = pedidoInclusaoService.percentualDoDesconto(pedido);
		
		assertEquals(new BigDecimal("0"),resultado);
	}
}
