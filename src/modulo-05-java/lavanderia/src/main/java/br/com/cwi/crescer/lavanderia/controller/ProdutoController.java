package br.com.cwi.crescer.lavanderia.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.domain.Material;
import br.com.cwi.crescer.lavanderia.domain.Servico;
import br.com.cwi.crescer.lavanderia.dto.ProdutoDTO;
import br.com.cwi.crescer.lavanderia.dto.ProdutoIncluirDTO;
import br.com.cwi.crescer.lavanderia.services.MaterialService;
import br.com.cwi.crescer.lavanderia.services.ProdutoService;
import br.com.cwi.crescer.lavanderia.services.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;
    private MaterialService materialService;
    private ServicoService servicoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService,MaterialService materialService,ServicoService servicoService) {
        this.produtoService = produtoService;
        this.materialService = materialService;
        this.servicoService = servicoService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
    }
    
    @RequestMapping(path="/buscar", method = RequestMethod.GET)
    public ModelAndView buscaListar(String material, String servico, RedirectAttributes redirectAttributes) {
    	Long idMaterial = Long.valueOf(material).longValue();
    	Long idServico = Long.valueOf(servico).longValue();
    	if(produtoService.verificaSeEhExisteCombinacao(idMaterial, idServico)){
    		return new ModelAndView("produto/lista", "produtos", produtoService.listarUmProduto(idMaterial, idServico)); 		
    	}
    	return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("produto/edita", "produto", produtoService.findById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return new ModelAndView("produto/edita");
        }
        produtoService.atualizar(dto);
        return new ModelAndView("redirect:/produtos");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewCriar() {
        return new ModelAndView("produto/inclui", "produto", new ProdutoIncluirDTO());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("produto") ProdutoIncluirDTO dto, BindingResult result, RedirectAttributes redirectAttributes) {
    	if (result.hasErrors()) {
            return new ModelAndView("produto/inclui");
        }
        if(!produtoService.criar(dto)){
        	redirectAttributes.addFlashAttribute("messageError", "Este produto ja existe...");
        } else {
        	redirectAttributes.addFlashAttribute("messageSucess", "Criado com sucesso...");
        }       
        return new ModelAndView("redirect:/produtos");
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
