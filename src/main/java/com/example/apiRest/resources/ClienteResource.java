package com.example.apiRest.resources;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apiRest.models.Cliente;
import com.example.apiRest.repositories.ClienteRepository;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin("*")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;

	@GetMapping("/clientes")
	public List<Cliente> listaClientes() {
		return clienteRepository.findAll();
	}

	@GetMapping("/clienteid/{id}")
	public Optional<Cliente> listaClienteUnico(@PathVariable(value = "id") Integer id) {
		return clienteRepository.findById(id);
	}
	
	@GetMapping("/clientenome/{nome}")
	public Optional<Cliente> listaClienteNome(@PathVariable(value = "nome") String nome) {
		return clienteRepository.findByNome(nome);
	}
	
	@GetMapping("/clientedata/{datanasc}")
	public Optional<Cliente> listaClienteDataNasc(@PathVariable(value = "datanasc") String datanasc) {
		return clienteRepository.findByDatanasc(datanasc);
	}
	
	@GetMapping("/clientetelefone/{telefone}")
	public Optional<Cliente> listaClienteTell(@PathVariable(value = "telefone") String telefone) {
		return clienteRepository.findByTelefone(telefone);
	}

	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@DeleteMapping("/cliente")
	public Void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
		return null;
	}

	@PutMapping("/cliente")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	
	
	
	
	
	
	
	//
//	@Autowired
//	private ClienteService service;
//	
//	@GetMapping(value= "/(id)")
//	public ResponseEntity<Cliente> findById(@PathVariable Integer id){
//		Cliente cliente = service.findById(id);
//		return ResponseEntity.ok().body(cliente);
//	}
//	
//	@GetMapping
//	public ResponseEntity<List<Cliente>> findAll(){
//		List<Cliente> clientes = service.findAll();
//		return ResponseEntity.ok().body(clientes);
//	}
//	
//	@PostMapping
//	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
//		Cliente obj = service.save(cliente);
//		return ResponseEntity.ok().body(obj);
//	}
//	
//	@PutMapping
//	public ResponseEntity<Cliente> update (@RequestBody Cliente cliente){
//		Cliente obj = service.update(cliente);
//		return ResponseEntity.ok().body(obj);
//	}
//	
//	@DeleteMapping(value = "/(id)")
//	public ResponseEntity<Void> delete(@PathVariable Integer id){
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//		
//	}

}
