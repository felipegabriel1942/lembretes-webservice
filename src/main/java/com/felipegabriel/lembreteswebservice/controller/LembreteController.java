package com.felipegabriel.lembreteswebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipegabriel.lembreteswebservice.model.Lembrete;
import com.felipegabriel.lembreteswebservice.service.impl.LembreteServiceImpl;

@RestController
@RequestMapping("lembrete")
public class LembreteController {
	
	@Autowired
	private LembreteServiceImpl service;
	
	@PostMapping
	public ResponseEntity<Lembrete> salvarLembrete(@RequestBody Lembrete lembrete) {
		try {
			return ResponseEntity.ok(service.salvarLembrete(lembrete));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "buscar-lembrete")
	public ResponseEntity<Lembrete> buscarLembrete(@RequestParam("pkLembrete") Integer pkLembrete) {
		try {
			return ResponseEntity.ok(service.buscarLembrete(pkLembrete));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "total-lembretes-usuario")
	public ResponseEntity<?> contarLembretesUsuario(@RequestParam("pkUsuario") Integer pkusuario) {
		try {
			return ResponseEntity.ok(service.contarLembretesUsuario(pkusuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Void> deletarLembrete(@RequestParam("pkLembrete") Integer pkLembrete) {
		try {
			service.deletarLembrete(pkLembrete);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Lembrete> atualizarLembrete(@RequestBody Lembrete lembrete) {
		try {
			return ResponseEntity.ok(service.atualizarLembrete(lembrete));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "listar-lembretes")
	public ResponseEntity<Page<Lembrete>> listarLembretes(@RequestParam("pagina") Integer pagina,
			@RequestParam("qtdRegistros") Integer qtdRegistros,
			@RequestParam("pkUsuario") Integer pkUsuario) {
		try {
			return ResponseEntity.ok(service.listarLembretes(pagina, qtdRegistros, pkUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping(value = "listar-lembretes-por-titulo")
	public ResponseEntity<Page<Lembrete>> listarLembretesPorTitulo(@RequestParam("pagina") Integer pagina,
			@RequestParam("qtdRegistros") Integer qtdRegistros,
			@RequestParam("titulo") String titulo,
			@RequestParam("pkUsuario") Integer pkUsuario) {
		try {
			return ResponseEntity.ok(service.listarLembretesPorTitulo(pagina, qtdRegistros, titulo , pkUsuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
