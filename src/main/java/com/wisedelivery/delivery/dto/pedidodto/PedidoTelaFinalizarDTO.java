package com.wisedelivery.delivery.dto.pedidodto;

import lombok.Data;

@Data
public class PedidoTelaFinalizarDTO {

  private RestauranteSalvoDTO restaurante;
  private BigDecimal subTotal;
  private BigDecimal taxaEntrega;
  private BigDecimal total;
  private List<ItemPedido> itens;
  private EnderecoDTO endereco;
}