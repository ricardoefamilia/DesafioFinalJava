package br.com.desafiofinalspringboot.service;

import br.com.desafiofinalspringboot.model.Telefone;

public interface TelefoneService {

	Iterable<Telefone> buscaTodosPorCliente(Long idcliente);
	//Telefone buscaPorId(Long idtelefone);
	void inserir(Telefone telefone);
	void atualizar(Long idtelefone, Telefone telefone);
	void deletar(Long idtelefone);
}
