package com.wisedelivery.delivery.dominio;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@MappedSuperclass
public class Usuario {
  @EqualsAndHashCode.Include
  @Getter
  @Setter
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Getter
  @Setter
  @Column(length = 80, nullable = false)
  private String nome;
  @Getter
  @Setter
  @Column(length = 60, nullable = false)
  private String email;
  @Getter
  @Setter
  @Column(length = 80, nullable = false)
  private String senha;
  @Getter
  @Setter
  @Column(length = 20, nullable = false)
  private String telefone;

  @Getter
  @Setter
  private String endereco;
}