package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Item;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Pedido;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoDTO;
import br.com.cwi.crescer.lavanderia.dto.PedidoIncluirDTO;
import br.com.cwi.crescer.lavanderia.services.ItemService;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.PedidoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;


@Controller
@RequestMapping("/itens")
public class ItemController {

	private ItemService itemService;
    private MaterialService materialService;
    private ServicoService servicoService;
    private PedidoService pedidoService;


    @Autowired
    public ItemController(ItemService itemService,MaterialService materialService,ServicoService servicoService,PedidoService pedidoService) {
        this.itemService = itemService;
        this.materialService=materialService;
        this.servicoService=servicoService;
        this.pedidoService=pedidoService;
    }
    
    //inclusao item terminar
    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView manter(@Valid @ModelAttribute("item") ItemDTO itemDTO,
    							BindingResult result,
    							final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors()) {
		    return new ModelAndView("item/inclui");
		}
		Item incluido = itemService.incluirItem(itemDTO);	
		if(incluido != null){
			redirectAttributes.addFlashAttribute("menssagemFlash", "incluiu Com Sucesso");
		}else{
			redirectAttributes.addFlashAttribute("menssagemFlash", "não foi possivel incluir");
		}
		return new ModelAndView("item/inclui");
		/*Pedido pedido = pedidoService.findById(incluido.getPedido().getIdPedido());		
		ItemDTO outroItem = new ItemDTO();
		outroItem.setIdPedido(pedido.getIdPedido());
        return new ModelAndView("item/inclui","item",outroItem);*/
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
