package br.com.desafiofinalspringboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafiofinalspringboot.model.Cliente;
import br.com.desafiofinalspringboot.model.Telefone;
import br.com.desafiofinalspringboot.service.ClienteService;
import br.com.desafiofinalspringboot.service.TelefoneService;

@RestController
@RequestMapping("telefones")
public class TelefoneRestController {
	
	@Autowired
	private TelefoneService telefoneService;
	@Autowired
	private ClienteService clienteService;

	@GetMapping("/{idcli}")
	public ResponseEntity<Iterable<Telefone>> buscarTodosPorCliente(@PathVariable Long idcli) {
		return ResponseEntity.ok(telefoneService.buscaTodosPorCliente(idcli));
	}

	@PostMapping("/{idcliente}")
	public ResponseEntity<Telefone> inserir(@PathVariable Long idcliente, @RequestBody Telefone telefone) {
		Optional<Cliente> cliente = Optional.of(clienteService.buscarPorId(idcliente));
		if(cliente.isPresent()) {
			telefone.setCliente(cliente.get());
			telefoneService.inserir(telefone);
		}		
		return ResponseEntity.ok(telefone);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Telefone> atualizar(@PathVariable Long id, @RequestBody Telefone telefone) {
		
		telefoneService.atualizar(id, telefone);
		return ResponseEntity.ok(telefone);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		telefoneService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}
