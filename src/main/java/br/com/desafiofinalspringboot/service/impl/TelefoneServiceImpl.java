package br.com.desafiofinalspringboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafiofinalspringboot.model.Cliente;
import br.com.desafiofinalspringboot.model.ClienteRepository;
import br.com.desafiofinalspringboot.model.Telefone;
import br.com.desafiofinalspringboot.model.TelefoneRepository;
import br.com.desafiofinalspringboot.service.TelefoneService;

@Service
public class TelefoneServiceImpl implements TelefoneService{

	@Autowired
	private TelefoneRepository telefoneRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public Iterable<Telefone> buscaTodosPorCliente(Long idcliente) {
		// Buscar todos os Telefones.
		List<Telefone> telefonesDoCliente = new ArrayList<>();		
		List<Telefone> listaTelefone = (List<Telefone>) telefoneRepository.findAll();
		for (Telefone telefone : listaTelefone) {
			if(telefone.getCliente().getId() == idcliente) {
				telefonesDoCliente.add(telefone);
			}
		}
		return (Iterable<Telefone>)telefonesDoCliente;
	}

	@Override
	public void inserir(Telefone telefone) {
		telefoneRepository.save(telefone);	
	}

	@Override
	public void atualizar(Long idtelefone, Telefone telefone) {
		Optional<Telefone> telNovo = telefoneRepository.findById(idtelefone);
		if(telNovo.isPresent()) {
			telefoneRepository.save(telefone);
		}		
	}

	@Override
	public void deletar(Long idtelefone) {
		telefoneRepository.deleteById(idtelefone);		
	}

	
}
