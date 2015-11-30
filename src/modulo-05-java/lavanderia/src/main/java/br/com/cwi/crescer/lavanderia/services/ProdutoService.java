package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.MaterialDAO;
import br.com.cwi.crescer.lavanderia.DAO.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.DAO.ServicoDAO;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoIncluirDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDao;
    private MaterialDAO materialDao;
    private ServicoDAO servicoDao;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDao,MaterialDAO materialDao,ServicoDAO servicoDao){
        this.produtoDao = produtoDao;
        this.materialDao = materialDao;
        this.servicoDao = servicoDao;
    }

    public Produto findById(Long id){
        return this.produtoDao.findById(id);
    }
    
    public List<Material> buscarMaterialPorServico(Long idServico) {
    	List<Material> materiais = new ArrayList<Material>();
    	
    	for(ProdutoDTO produto : listarProdutos()) {
    		if(produto.getServico().getIdServico().equals(idServico)) {   			
    			if(!materiais.contains(produto.getMaterial())) {
    				materiais.add(produto.getMaterial());
    			}
    		}
    	} 	
    	return materiais;
    }


    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoDao.findAll();

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoMapper.toDTO(produto));
        }

        return dtos;
    }
    
    public ProdutoDTO listarUmProduto(Long idMaterial,Long idServico){   	
    	return ProdutoMapper.toDTO(produtoDao.findByServicoAndMaterial(idServico, idMaterial));
    }
    
    public List<ProdutoDTO> listarProdutosPorMaterial(Long idMaterial){
    	List<Produto> produtos = produtoDao.findByMaterial( idMaterial);

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoMapper.toDTO(produto));
        }

        return dtos;
    }
    
    public List<ProdutoDTO> listarProdutosPorServico(Long idServico){
    	List<Produto> produtos = produtoDao.findByServico(idServico);

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoMapper.toDTO(produto));
        }

        return dtos;
    }

    public void atualizar(ProdutoDTO dto) {
        Produto entity = produtoDao.findById(dto.getIdProduto());
        ProdutoMapper.merge(dto, entity);
        SituacaoProduto situacao = dto.getSituacao() == 0 ? SituacaoProduto.ATIVO : SituacaoProduto.INATIVO;
        entity.setSituacao(situacao);
        produtoDao.save(entity);
    }

    public boolean criar(ProdutoIncluirDTO dto) {
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setMaterial(materialDao.findById(dto.getIdMaterial()));
        entity.setServico(servicoDao.findById(dto.getIdServico()));
        boolean ehCombinacaoUnica = !verificaSeEhExisteCombinacao(dto.getIdMaterial(),dto.getIdServico());
        entity.setSituacao(SituacaoProduto.ATIVO);
        if(ehCombinacaoUnica){        	
            produtoDao.save(entity);
            return true;
        } else {
        	return false;
        }
    }
    
    public boolean verificaSeEhExisteCombinacao(Long idMaterial,Long idServico){
    	Produto produto = produtoDao.findByServicoAndMaterial(idServico, idMaterial);
    	if(produto == null){
    		return false;
    	} else {
    		return true;
    	}
    }
}
