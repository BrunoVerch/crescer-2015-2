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

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ClienteResumoDTO;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.mapper.ItemMapper;
import br.com.cwi.crescer.lavanderia.mapper.PedidoMapper;
import br.com.cwi.crescer.lavanderia.services.ClienteService;
import br.com.cwi.crescer.lavanderia.services.ItemService;
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
	private ItemService itemService;
	
	@Autowired
	public PedidoController(PedidoService pedidoService,ClienteService clienteService,
			MaterialService materialService,ServicoService servicoService,
			ProdutoService produtoService,PedidoInclusaoService pedidoInclusaoService,ItemService itemService){
		this.pedidoService=pedidoService;
		this.clienteService=clienteService;
		this.materialService=materialService;
		this.servicoService=servicoService;
		this.produtoService=produtoService;
		this.pedidoInclusaoService=pedidoInclusaoService;
		this.itemService = itemService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/visualizar/{id}",method = RequestMethod.GET)
    public ModelAndView visualiza(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.calculaDataValores(pedido);
		PedidoDTO pedidoDto=PedidoMapper.toDTO(pedido);
		pedidoDto.setItens(itemService.findByIdPedido(pedido));
        return new ModelAndView("pedido/visualiza", "pedido", pedidoDto);
    }
	
	@RequestMapping(path = "/processarItem/{id}",method = RequestMethod.GET)
    public ModelAndView processaItem(@PathVariable("id") Long id) {
		Item item = itemService.findById(id);
		pedidoInclusaoService.processarUmItem(item);
		Pedido pedido = pedidoService.findById(item.getPedido().getIdPedido());
		if(pedidoInclusaoService.itensEstaoProcessados(pedido.getItens())){
			pedidoInclusaoService.alterarParaProcessado(pedido);
		}
		pedidoService.atualizar(PedidoMapper.toDTO(pedido));
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/processarItens/{id}",method = RequestMethod.GET)
    public ModelAndView processa(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.processarItens(pedido.getItens());
		pedidoInclusaoService.alterarParaProcessado(pedido);
		pedidoService.atualizar(PedidoMapper.toDTO(pedido));
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/salvarItens/{id}",method = RequestMethod.GET)
    public ModelAndView salvaItens(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.salvarPedido(pedido);
		pedidoService.atualizar(PedidoMapper.toDTO(pedido));
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/cancelar/{id}",method = RequestMethod.GET)
    public ModelAndView cancela(@PathVariable("id") Long id) {
		Pedido pedido = pedidoService.findById(id);
		pedidoInclusaoService.cancelarPedido(pedido);
		pedidoService.atualizar(PedidoMapper.toDTO(pedido));
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
    }
	
	@RequestMapping(path = "/encerrar/{id}",method = RequestMethod.GET)
    public ModelAndView encerrar(Model model , @PathVariable("id") Long id) throws Exception {
		
		Pedido pedido = pedidoService.findById(id);
		ModelAndView mav = new ModelAndView("pedido/lista", "pedidos", pedidoService.listar());
		if(pedidoInclusaoService.retirarPedido(pedido)){
			pedidoService.atualizar(PedidoMapper.toDTO(pedido));
			mav.addObject("mensagem", "Pedido retirado com sucesso");
		} else {
			mav.addObject("mensagem", "Nao é possivel retirar o pedido");
		}
		return mav;
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
        return new ModelAndView("redirect:/pedidos/incluirProduto/"+id);
	}
	
	@RequestMapping(path="/incluirProduto/{id}", method= RequestMethod.GET)
    public ModelAndView selecionarProduto(@PathVariable("id") Long id) {
    	return new ModelAndView("item/inclui", "pedido", pedidoService.findById(id));
    }
    
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		return new ModelAndView("pedido/edita", "pedido", pedidoService.findById(id));
	}
    
    @RequestMapping(path = "/incluirItem", method = RequestMethod.POST)
    public ModelAndView incluirItem(@RequestParam("idServico") Long idServico,
    		@RequestParam("idMaterial") Long idMaterial,@RequestParam("idPedido") Long idPedido,@RequestParam("peso") String peso){ 	
    	
    	ProdutoDTO produto = produtoService.listarUmProduto(idMaterial, idServico);
    	Item item2 = itemService.incluirItem(ItemMapper.criarItemDTO(idPedido, peso, produto));
    	Pedido pedido = pedidoService.findById(idPedido);
    	pedido.getItens().add(item2);
    	pedidoService.atualizar(PedidoMapper.toDTO(pedido));
    	return new ModelAndView("redirect:/pedidos/editar/" + idPedido);
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
