package br.com.cwi.crescer.lavanderia.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ItemDAO;
import br.com.cwi.crescer.lavanderia.domain.Item;

@Service
public class ItemService {

	private ItemDAO itemDao;
	
	@Autowired
	public ItemService(ItemDAO itemDao){
		super();
		this.itemDao = itemDao;
	}
	
	public Item findById(Long id){
		return this.itemDao.findById(id);
	}
}
