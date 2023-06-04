package com.wisedelivery.delivery.dto.restaurantedto;

public class Carrinho {

  public Carrinho(

      ItemCardapioService itemCardapioService,
      ClienteService clienteService) {
    this.itemCardapioService = itemCardapioService;
    this.clienteService = clienteService;
  }

  private final ClienteService clienteService;
  private final ItemCardapioService itemCardapioService;

  @Getter
  private List<ItemCarrinhoDTO> itens = new ArrayList<>();
  @Getter
  private Restaurante restaurante;
  @Getter
  private ClienteSalvoDTO cliente;
  private ItemCardapioDTO itemCardapioDto;
  @Getter
  private BigDecimal total = new BigDecimal(0);

  public void adicionarItem(ItemCarrinhoDTO itemCarrinhoDTO, Long itemCardapioDtoId) {
        setItemCardapio(itemCardapioDtoId);
        log.info(String.format("Restaurante: [%s]", itemCardapioDto.getRestaurante().getNome()));
        if(itens.isEmpty()) {
            this.restaurante = itemCardapioDto.getRestaurante();
            itemCarrinhoDTO.setId(1L);

            this.cliente = clienteService.procurarPeloId(itemCarrinhoDTO.getClienteId());
        }
        else if(!restauranteIgual(itemCardapioDto.getRestaurante())) {
            throw new RestauranteDiferenteExcpetion("Não é possível adicionar itens de restaurantes diferentes no mesmo carrinho");
else if(!restauranteIgual(itemCardapioDto.getRestaurante())) {
        log.info(String.format("Restaurante: [%s]", itemCarrinhoDTO.getItemCardapio().getRestaurante().getNome()));
        itemCarrinhoDTO.setId(itemCarrinhoDTO.getId().equals(1L) ? 1L : Long.valueOf(this.itens.size() + 1));
        itens.add(itemCarrinhoDTO);      
        setTotalCarrinho(itens);
    }
    }

  private boolean restauranteIgual(Restaurante restaurante) {

  public void setItemCardapio(Long itemCardapioDtoId) {

  public void removerItemDCarrinho(Long itemCarrinhoId) {
    ItemCarrinhoDTO itemCarrinho = this.itens.stream().filter(item -> item.getId().equals(itemCarrinhoId)).toList()
        .get(0);
    this.itens.remove(itemCarrinho);
    setTotalCarrinho(itens);
    setTotalCarrinho(itens);
  }

  private void setTotalCarrinho(List<ItemCarrinhoDTO> itensCarrinho) {
    setTotal(BigDecimal.ZERO);
    for (ItemCarrinhoDTO item : itensCarrinho) {
      setTotal(total.add(item.getPreco()));
    }
  }

  private void setTotal(BigDecimal valor) {
    this.total = valor;
  }

}