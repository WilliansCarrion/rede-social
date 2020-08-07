package com.redeSocial.RedeSocial.controller;

//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redeSocial.RedeSocial.model.LoginUsuarioModel;
import com.redeSocial.RedeSocial.model.UsuarioModel;
//import com.redeSocial.RedeSocial.repository.UsuarioRepository;
import com.redeSocial.RedeSocial.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
	
	// CONTROLLER COM A CAMADA DE SECURITY > Funções 'logar' e 'cadastrar'
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping ("/logar")
	public ResponseEntity<LoginUsuarioModel> Autentication (@RequestBody Optional<LoginUsuarioModel> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping ("/cadastrar")
	public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel email) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(usuarioService.CadastrarUsuario(email));
	}
		
	/* CONTROLLER SEM A CAMADA DE SECURITY
	 
	 @Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> getAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<UsuarioModel> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@PutMapping 
	public ResponseEntity<UsuarioModel> put (@RequestBody UsuarioModel usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(usuario));
	}
	
	@DeleteMapping
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}*/
}
