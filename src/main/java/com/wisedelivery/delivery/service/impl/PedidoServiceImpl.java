package com.wisedelivery.delivery.service.impl;

@Service
public class PedidoServiceImpl implements PedidoService {
  @Autowired
  @Getter
  private RestauranteService restauranteService;

  @Autowired
  @Getter
  private ClienteService clienteService;

  @Autowired
  @Getter
  private ClienteRepository clienteRepository;

  @Autowired
  @Getter
  private ItemCardapioRepository itemCardapioRepository;

  @Autowired
  @Getter
  private PedidoRepository pedidoRepository;

  @Override
    public PedidoDTO buscarPedidoPeloId(Long id) {
        // TODO Auto-generated method stub
@@ -48,7 +65,6 @@

  public List<PedidoDTO> buscarTodosOsPedidosPorClienteId(Long clienteId) {

  @Override
  public PedidoTelaFinalizarDTO deCarrinhoParaPedido(Carrinho carrinho) {
    PedidoTelaFinalizarDTO pedido = new PedidoTelaFinalizarDTO();
    pedido.setRestaurante(getRestauranteService().procurarPeloEmail(carrinho.getRestaurante().getEmail()));
    pedido.setSubTotal(carrinho.getTotal());
    pedido.setTaxaEntrega(carrinho.getRestaurante().getTaxaEntrega());
    pedido.setTotal(pedido.getSubTotal().add(pedido.getTaxaEntrega()));
    pedido.setItens(getItensPedido(carrinho.getItens()));
    return pedido;
  }

  @Override
  public PedidoFecharDTO deCarrinhoParaPedidoFecharDto(Carrinho carrinho) {
    PedidoFecharDTO pedido = new PedidoFecharDTO();
    pedido.setRestaurante(getRestauranteService().procurarPeloEmail(carrinho.getRestaurante().getEmail()));
    pedido.setCliente(getClienteService().procurarPeloId(carrinho.getCliente().getId()));
    pedido.setSubTotal(carrinho.getTotal());
    pedido.setTaxaEntrega(carrinho.getRestaurante().getTaxaEntrega());
    pedido.setTotal(pedido.getSubTotal().add(pedido.getTaxaEntrega()));
    pedido.setItens(getItensPedido(carrinho.getItens()));
    return pedido;
  }

  private List<ItemPedido> getItensPedido(List<ItemCarrinhoDTO> itens) {
    return itens.stream().map(item -> {
      return ItemPedido.builder()
          .observacoes(item.getObservacoes())
          .preco(item.getPreco())
          .quantidade(item.getQuantidade())
          .itemCardapio(itemCardapioRepository.findById(item.getItemCardapio().getId()).get())
          .build();
    }).toList();
  }

  @Override
  public PedidoDTO fecharPedido(PedidoFecharDTO pedido) {

    throw new UnsupportedOperationException("Unimplemented method 'fecharPedido'");
  }

  @Override
  public PedidoFechadoDTO salvar(Carrinho carrinho) {

    Cliente cliente = getCLiente(carrinho.getCliente().getId());
    Pedido pedido = Pedido.builder()
        .cliente(cliente)
        .restaurante(carrinho.getRestaurante())
        .itens(getItensPedido(carrinho.getItens()))
        .subtotal(carrinho.getTotal())
        .taxaEntrega(carrinho.getRestaurante().getTaxaEntrega())
        .total(carrinho.getTotal().multiply(carrinho.getRestaurante().getTaxaEntrega()))
        .endereco(cliente.getEndereco())
        .build();

    return getPedidoRepository().save(pedido);
  }

  public Cliente getCLiente(Long id) {
    return getClienteRepository().findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException(null));
  }

  public String getEnderecoFormatado(EnderecoDTO enderecoDTO) {
    StringBuilder sb = new StringBuilder();
    sb.append("Rua ");
    sb.append(enderecoDTO.getRua());
    sb.append(", ");
    sb.append(enderecoDTO.getNumero());
    sb.append(" - ");
    sb.append(enderecoDTO.getBairro());
    sb.append(" - ");
    sb.append(enderecoDTO.getCidade());
    sb.append(" - ");
    sb.append(enderecoDTO.getEstado());
    sb.append(" - ");
    sb.append(enderecoDTO.getCep());
    return sb.toString();
  }

}