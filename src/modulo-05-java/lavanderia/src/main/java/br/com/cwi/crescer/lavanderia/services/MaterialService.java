package br.com.cwi.crescer.lavanderia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.MaterialDAO;
import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.domain.Material;

@Service
public class MaterialService {

	private MaterialDAO materialDao;
	
	@Autowired
	public MaterialService(MaterialDAO materialDao){
		super();
		this.materialDao = materialDao;
	}
	
	public Material findById(Long id){
		return this.materialDao.findById(id);
	}
	
	public List<Material> listar() {
        return materialDao.listAll();
    }
}
