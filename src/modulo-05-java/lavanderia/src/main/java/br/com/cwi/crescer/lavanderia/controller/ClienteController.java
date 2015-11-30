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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.lavanderia.domain.Cidade;
import br.com.cwi.crescer.lavanderia.dto.ClienteDTO;
import br.com.cwi.crescer.lavanderia.services.CidadeService;
import br.com.cwi.crescer.lavanderia.services.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;
    private CidadeService cidadeService;

    @Autowired
    public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
        this.clienteService = clienteService;
        this.cidadeService = cidadeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView listar() {
        return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientes());
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ModelAndView viewExibe(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam("nome") String nome){
		return new ModelAndView("cliente/lista", "clientes", clienteService.buscarClientePorNome(nome));
	}

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
    public ModelAndView viewEdita(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/editar", method = RequestMethod.POST)
    public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO dto,BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("cliente/edita");
        }
        clienteService.atualizar(dto);
        redirectAttributes.addFlashAttribute("message", "Editado com sucesso...");
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
    public ModelAndView viewExclui(@PathVariable("id") Long id) {
        return new ModelAndView("cliente/exclui", "cliente", clienteService.buscarClientePorId(id));
    }

    @RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView excluir(ClienteDTO dto, RedirectAttributes redirectAttributes) {
        clienteService.excluir(dto.getId());
        redirectAttributes.addFlashAttribute("message", "Removido com sucesso...");
        return new ModelAndView("redirect:/clientes");
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView viewCriar() {
        return new ModelAndView("cliente/inclui", "cliente", new ClienteDTO());
    }

    @RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("cliente") ClienteDTO dto,BindingResult result, RedirectAttributes redirectAttributes) {
        if(result.hasErrors()){
            return new ModelAndView("cliente/inclui");
        }
        clienteService.criar(dto);
        redirectAttributes.addFlashAttribute("message", "Incluido com sucesso...");
        return new ModelAndView("redirect:/clientes");
    }

    @ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}
