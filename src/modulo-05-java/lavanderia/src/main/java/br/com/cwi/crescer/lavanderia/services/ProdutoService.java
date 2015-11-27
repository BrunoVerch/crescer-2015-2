package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.ProdutoDAO;
import br.com.cwi.crescer.lavanderia.domain.Produto;
import br.com.cwi.crescer.lavanderia.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ProdutoMapper;

@Service
public class ProdutoService {

    private ProdutoDAO produtoDao;

    @Autowired
    public ProdutoService(ProdutoDAO produtoDao){
        super();
        this.produtoDao = produtoDao;
    }

    public Produto findById(Long id){
        return this.produtoDao.findById(id);
    }

    public List<ProdutoDTO> listarProdutos() {
        List<Produto> produtos = produtoDao.findAll();

        List<ProdutoDTO> dtos = new ArrayList<ProdutoDTO>();

        for (Produto produto : produtos) {
            dtos.add(ProdutoMapper.toDTO(produto));
        }

        return dtos;
    }

    public void atualizar(ProdutoDTO dto) {
        Produto entity = produtoDao.findById(dto.getIdProduto());
        ProdutoMapper.merge(dto, entity);
        produtoDao.save(entity);
    }

    public void criar(ProdutoDTO dto) {
        Produto entity = ProdutoMapper.getNewEntity(dto);
        entity.setSituacao(SituacaoProduto.ATIVO);
        produtoDao.save(entity);
    }
}
