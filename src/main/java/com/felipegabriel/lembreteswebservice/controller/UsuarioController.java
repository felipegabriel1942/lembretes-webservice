package com.felipegabriel.lembreteswebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.lembreteswebservice.model.Usuario;
import com.felipegabriel.lembreteswebservice.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioServiceImpl service;
	
	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		try {
			return ResponseEntity.ok(service.salvarUsuario(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "buscar-usuario-email-e-senha")
	public ResponseEntity<Usuario> buscarUsuarioPorEmailESenha(@RequestParam("email") String email,
			@RequestParam("senha") String senha) {
		try {
			return ResponseEntity.ok(service.buscarUsuarioPorEmailESenha(email, senha));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
