package br.com.cwi.crescer.lavanderia.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ItemDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;

@Service
public class ItemService {

	private ItemDAO itemDao;
	private PedidoService pedidoService;
	private ProdutoService produtoService;
	private ItemService itemService;
	private PedidoInclusaoService pedidoInclusaoService;

	@Autowired
	public ItemService(ItemDAO itemDao, PedidoService pedidoService,
			ProdutoService produtoService, ItemService itemService,PedidoInclusaoService pedidoInclusaoService) {
		this.itemDao = itemDao;
		this.pedidoService = pedidoService;
		this.produtoService = produtoService;
		this.itemService = itemService;
		this.pedidoInclusaoService = pedidoInclusaoService;
	}

	public Item findById(Long id) {
		return this.itemDao.findById(id);
	}

	public List<Item> findByIdPedido(Pedido pedido) {
		return itemDao.findByIdPedido(pedido);
	}

	public Item incluirItem(ItemDTO itemDTO) {
		Pedido pedido = pedidoService.findById(itemDTO.getIdPedido());
		Produto produto = produtoService.findById(itemDTO.getIdProduto());
		Item item = new Item();
		item.setPedido(pedido);
		item.setProduto(produto);
		item.setPeso(itemDTO.getPeso());
		item.setValorUnitario(produto.getValor());
		item.setValorTotal(item.getValorUnitario().multiply(item.getPeso()));
		item.setSituacao(SituacaoItem.PENDENTE);
		itemDao.save(item);
		pedidoInclusaoService.valorBrutoPedido(pedido);
		return item;
	}
}
