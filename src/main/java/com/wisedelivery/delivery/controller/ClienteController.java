package com.wisedelivery.delivery.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.wisedelivery.delivery.dto.enderecodto.EnderecoDTO;
import com.wisedelivery.delivery.dto.pedidodto.PedidoTelaFinalizarDTO;
import com.wisedelivery.delivery.service.ClienteService;
import com.wisedelivery.delivery.service.PedidoService;

import lombok.Getter;

public class ClienteController {

  private Validator validator;
  @Autowired
  @Getter
  private Validator<ClienteDTO> validator;

  @GetMapping("form-cadastro")
    public String formCadastroCliente( Model model ){
        model.addAttribute("cliente", new ClienteDTO());

public String login(@ModelAttribute("cliente") ClienteDTO cliente, Model mo
        }

  ClienteIdDTO clienteIdDto = getClienteService()
  procurarCliente(ClienteService.getEmail());model.addAttribute("clienteId",clienteIdDto);
  return home(model);

  private Object getClienteService() {
    return null;
  }

  @GetMapping("/home")
public String adicionaItemAoCarrinho(@ModelAttribute("itemCarrinho")ItemCarrinho
            model.addAttribute("erro", true);
            model.addAttribute("msgErroRestaurante", e.getMessage());
        }

  model.addAttribute("carrinho",carrinho);return"cliente-carrinho";

  public String removeItemCarrinho(@PathVariable("itemId") Long itemId, Model mode

    @GetMapping("tela-finalizar-pedido")

  public String telaFinalizarPedido(Model model) {
    com.wisedelivery.delivery.dto.restaurantedto.Carrinho carrinho;
    model.addAttribute("pedido", PedidoService.deCarrinhoParaPedido(carrinho));
    PedidoTelaFinalizarDTO pedido = PedidoService.deCarrinhoParaPedido(carrinho);
    EnderecoDTO endereco = (EnderecoDTO) model.getAttribute("endereco");
    if (Objects.nonNull(endereco)) {
      pedido.setEndereco(endereco);
    }
    model.addAttribute("pedido", pedido);
    return "cliente-finalizar-pedido";
  }

  @GetMapping("pedido/inserir-endereco")
  public String telaInserirEndereco(Model model) {
    model.addAttribute("endereco", new EnderecoDTO());
    return "tela-inserirEndereco";
  }

  @PostMapping("endereco/inserir")
  public String inserirEndereco(@ModelAttribute("endereco") EnderecoDTO endereco, Model model) {
    model.addAttribute("endereco", endereco);
    return telaFinalizarPedido(model);
  }

  @GetMapping("pedido/salvar")
  public String salvarPedido() {
    PedidoService.salvar();
    return "";
  }
}