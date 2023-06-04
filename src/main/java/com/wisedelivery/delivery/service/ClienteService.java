package com.wisedelivery.delivery.service;

public interface ClienteService {

  ClienteSalvoDTO salvar(ClienteDTO dto);

  ClienteSalvoDTO procurarPeloId(Long id);

  boolean login(ClienteLoginDTO cliente);

  ClienteIdDTO procurarCliente(String email);

  static Object getEmail() {
    return null;
  }

}
