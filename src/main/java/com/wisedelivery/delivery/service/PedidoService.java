package com.wisedelivery.delivery.service;

public interface PedidoService {

  PedidoTelaFinalizarDTO deCarrinhoParaPedido(Carrinho carrinho);

  PedidoFecharDTO deCarrinhoParaPedidoFecharDto(Carrinho carrinho);

  PedidoDTO fecharPedido(PedidoFecharDTO pedido);

  PedidoFechadoDTO salvar(Carrinho carrinho);

}