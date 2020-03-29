package com.felipegabriel.lembreteswebservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipegabriel.lembreteswebservice.model.Usuario;
import com.felipegabriel.lembreteswebservice.repository.UsuarioRepository;
import com.felipegabriel.lembreteswebservice.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;

	@Override
	public Usuario salvarUsuario(Usuario usuario) {
		return repository.save(usuario);
	}

	@Override
	public Usuario buscarUsuarioPorEmail(String email) {
		return repository.buscarUsuarioPorEmail(email);
	}

	@Override
	public Usuario buscarUsuarioPorPK(Integer pkUsuario) {
		return repository.findById(pkUsuario).orElse(null);
	}

}
