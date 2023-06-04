package com.wisedelivery.delivery.dto.pedidodto;

@Data
public class PedidoFecharDTO {
  private RestauranteSalvoDTO restaurante;
  private ClienteSalvoDTO cliente;
  private BigDecimal subTotal;
  private BigDecimal taxaEntrega;
  private BigDecimal total;
  private List<ItemPedido> itens;
  private EnderecoDTO endereco;
}