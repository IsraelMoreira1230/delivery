package com.wisedelivery.delivery.dto.restaurantedto;

@Data
public class ItemCarrinhoDTO {

  private Long clienteId;
  private Long id = 0L;
  private ItemCardapioDTO itemCardapio;
  private String observacoes;
  private BigDecimal preco;
  private int quantidade;

}