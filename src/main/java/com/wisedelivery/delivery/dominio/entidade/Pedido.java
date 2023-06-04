package com.wisedelivery.delivery.dominio.entidade;

@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
public class Pedido {

  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id

  private BigDecimal subtotal;
  private BigDecimal taxaEntrega;
  private BigDecimal total;
  private String endereco;

  @OneToMany(mappedBy = "id.pedido", fetch = FetchType.EAGER)
  private List<ItemPedido> itens;

  public String getDiaPedido() {
    return String.valueOf(data.getDayOfMonth());
  }

  public String getMesPedido() {
    return String.valueOf(data.getMonth());
  }
}
