package br.com.cwi.crescer.lavanderia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.lavanderia.DAO.CidadeDAO;
import br.com.cwi.crescer.lavanderia.DAO.ClienteDAO;
import br.com.cwi.crescer.lavanderia.domain.Cliente;
import br.com.cwi.crescer.lavanderia.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ClienteMapper;

@Service
public class ClienteService {

    private ClienteDAO clienteDao;
    private CidadeDAO cidadeDAO;

    @Autowired
    public ClienteService(ClienteDAO clienteDao, CidadeDAO cidadeDAO) {
        this.clienteDao = clienteDao;
        this.cidadeDAO = cidadeDAO;
    }

    public ClienteDTO buscarClientePorId(Long id) {
        return ClienteMapper.toDTO(clienteDao.findById(id));
    }

    public List<ClienteDTO> buscarClientePorNome(String nome) {
        List<Cliente> clientes = clienteDao.findByName(nome);

        List<ClienteDTO> dtos = new ArrayList<ClienteDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(ClienteMapper.toDTO(cliente));
        }

        return dtos;
    }

    public List<ClienteResumoDTO> listarClientesAtivos() {
        List<Cliente> clientes = clienteDao.findBySituacao(SituacaoCliente.ATIVO);

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public List<ClienteResumoDTO> listarClientes() {
        List<Cliente> clientes = clienteDao.findAll();

        List<ClienteResumoDTO> dtos = new ArrayList<ClienteResumoDTO>();

        for (Cliente cliente : clientes) {
            dtos.add(new ClienteResumoDTO(cliente));
        }

        return dtos;
    }

    public void atualizar(ClienteDTO dto) {
        Cliente entity = clienteDao.findById(dto.getId());
        ClienteMapper.merge(dto, entity);
        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));
        clienteDao.save(entity);
    }

    public void excluir(Long id) {
        Cliente entity = clienteDao.findById(id);
        entity.setSituacao(SituacaoCliente.INATIVO);
        clienteDao.save(entity);
    }

    public void criar(ClienteDTO dto) {
        Cliente entity = ClienteMapper.getNewEntity(dto);
        entity.setCidade(cidadeDAO.findById(dto.getIdCidade()));
        entity.setSituacao(SituacaoCliente.ATIVO);
        clienteDao.save(entity);
    }

}
