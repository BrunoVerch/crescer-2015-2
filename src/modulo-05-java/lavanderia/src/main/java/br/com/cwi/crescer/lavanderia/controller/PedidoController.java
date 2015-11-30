package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;
import br.com.cwi.crescer.lavanderia.services.ClienteService;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.PedidoInclusaoService;
import br.com.cwi.crescer.lavanderia.services.PedidoService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ClienteService clienteService;
	private MaterialService materialService;
	private ServicoService servicoService;
	private ProdutoService produtoService;
	private PedidoInclusaoService pedidoInclusaoService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService,ClienteService clienteService,
			MaterialService materialService,ServicoService servicoService,
			ProdutoService produtoService,PedidoInclusaoService pedidoInclusaoService){
		this.pedidoService=pedidoService;
		this.clienteService=clienteService;
		this.materialService=materialService;
		this.servicoService=servicoService;
		this.produtoService=produtoService;
		this.pedidoInclusaoService=pedidoInclusaoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/visualizar/{id}",method = RequestMethod.GET)
    public ModelAndView visualiza(@PathVariable("id") Long id) {
        return new ModelAndView("pedido/visualiza", "pedido", pedidoService.findById(id));
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/cancelar/{id}",method = RequestMethod.GET)
    public ModelAndView cancela(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.cancelarPedido(pedido);
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/encerrar/{id}",method = RequestMethod.GET)
    public ModelAndView encerrar(@PathVariable("id") Long id) throws Exception {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.retirarPedido(pedido);
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewCriarPedido() {
        return new ModelAndView("pedido/inclui", "pedido", new PedidoIncluirDTO());
    }

	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("pedido") PedidoIncluirDTO pedidoDTO,
											BindingResult result,
											RedirectAttributes redirectAttributes){
		Long id = pedidoService.incluirPedido(pedidoDTO);
		ItemDTO itemDTO = new ItemDTO();
        itemDTO.setIdPedido(pedidoDTO.getIdPedido());
        return new ModelAndView("item/inclui","item",itemDTO);
	}
    
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		return new ModelAndView("pedido/edita", "pedido", pedidoService.findById(id));
	}
    
    @RequestMapping(path="/buscarMateriais", method = RequestMethod.GET)
    public ModelAndView buscarMateriais(Model model, @RequestParam("idPedido") Long idPedido, @RequestParam("idServico") Long idServico) {
    	model.addAttribute("servicoSelecionado", servicoService.findById(idServico));
    	model.addAttribute("pedido", pedidoService.findById(idPedido));      
    	return new ModelAndView("item/inclui", "materiais", produtoService.buscarMaterialPorServico(idServico));
    }
    
    @RequestMapping(path="/buscarCpf", method = RequestMethod.GET)
    public ModelAndView buscarCpf(String cpf) { 
    	return new ModelAndView("pedido/lista", "pedidos", pedidoService.findByCpf(cpf));
    }
    
    @RequestMapping(path="/buscarSituacao", method = RequestMethod.GET)
    public ModelAndView buscarSituacao(String situacao) { 
    	return new ModelAndView("pedido/lista", "pedidos", pedidoService.findBySituacao(situacao.toUpperCase()));
    }
    
    @ModelAttribute("clientes")
    public List<ClienteResumoDTO> comboClientes() {
        return clienteService.listarClientes();
    }
    
    @ModelAttribute("materiais")
    public List<Material> comboMateriais() {
        return materialService.listar();
    }
    
    @ModelAttribute("servicos")
    public List<Servico> comboServicos() {
        return servicoService.listar();
    }
}
