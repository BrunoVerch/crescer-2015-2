package br.com.cwi.crescer.lavanderia.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ItemDAO;
import br.com.cwi.crescer.lavanderia.DAO.PedidoDAO;
import br.com.cwi.crescer.lavanderia.DAO.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Item.SituacaoItem;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;

@Service
public class ItemService {

	private ItemDAO itemDao;
	private PedidoDAO pedidoDao;
	private ProdutoDAO produtoDao;
	
	@Autowired
	public ItemService(ItemDAO itemDao,PedidoDAO pedidoDao,ProdutoDAO produtoDao){
		this.itemDao = itemDao;
		this.pedidoDao = pedidoDao;
		this.produtoDao = produtoDao;
	}
	
	public Item findById(Long id){
		return this.itemDao.findById(id);
	}

	 public Item incluirItem(ItemDTO itemDTO){
	    	Produto produto = obterProduto(itemDTO);
			
			Item item = new Item();
			item.setValorUnitario(produto.getValor());
			item.setPedido(pedidoDao.findById(itemDTO.getIdPedido()));
			item.setProduto(produto);
			item.setPeso(itemDTO.getPeso());
			BigDecimal valorTotal = item.getValorUnitario().multiply(item.getPeso());
			item.setValorTotal(valorTotal);
			item.setSituacao(SituacaoItem.PENDENTE);		
			return itemDao.save(item);
		
	 }
	 
	 public Produto obterProduto(ItemDTO itemDTO){
	    	Produto produtoBuscar = new Produto();
			produtoBuscar.setMaterial(new Material());
			produtoBuscar.setServico(new Servico());
			produtoBuscar.getMaterial().setIdMaterial(itemDTO.getIdMaterial());
			produtoBuscar.getServico().setIdServico(itemDTO.getIdServico());
			Produto produto = produtoDao.findByServicoAndMaterial(produtoBuscar.getServico().getIdServico(), produtoBuscar.getMaterial().getIdMaterial());
			return produto;
	    }
}
