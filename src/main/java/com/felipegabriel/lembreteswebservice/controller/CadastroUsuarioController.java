package com.felipegabriel.lembreteswebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.lembreteswebservice.model.Usuario;
import com.felipegabriel.lembreteswebservice.service.impl.UsuarioServiceImpl;

@RestController
@RequestMapping("cadastro-usuario")
public class CadastroUsuarioController {
	
	@Autowired
	private UsuarioServiceImpl service;
	
	@PostMapping
	public ResponseEntity<?> salvarUsuario(@RequestBody Usuario usuario) {
		try {
			service.salvarUsuario(usuario);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getCause().getCause().getLocalizedMessage());
		}
	}
}
