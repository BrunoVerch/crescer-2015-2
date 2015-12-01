package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ItemDTO;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;


@Controller
@RequestMapping("/itens")
public class ItemController {

    private MaterialService materialService;
    private ServicoService servicoService;


    @Autowired
    public ItemController(MaterialService materialService,ServicoService servicoService) {
        this.materialService=materialService;
        this.servicoService=servicoService;
    }
    
    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView manter(@RequestParam("id") Long idPedido) {
		return new ModelAndView("item/inclui","item",new ItemDTO(idPedido));
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
