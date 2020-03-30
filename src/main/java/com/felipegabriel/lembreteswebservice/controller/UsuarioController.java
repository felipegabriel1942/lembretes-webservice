package com.felipegabriel.lembreteswebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping(value = "buscar-usuario-email")
	public ResponseEntity<Usuario> buscarUsuarioPorEmail(@RequestParam("email") String email) {
		try {
			return ResponseEntity.ok(service.buscarUsuarioPorEmail(email));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "buscar-usuario-pk")
	public ResponseEntity<Usuario> buscarUsuarioPorPk(@RequestParam("pkUsuario") Integer pkUsuario) {
		try {
			return ResponseEntity.ok(service.buscarUsuarioPorPK(pkUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
