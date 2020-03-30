package com.felipegabriel.lembreteswebservice.service;

import com.felipegabriel.lembreteswebservice.model.Usuario;

public interface UsuarioService {
	
	void salvarUsuario(Usuario usuario);
	
	Usuario buscarUsuarioPorEmail(String email);
	
	Usuario buscarUsuarioPorPK(Integer pkUsuario);
}
