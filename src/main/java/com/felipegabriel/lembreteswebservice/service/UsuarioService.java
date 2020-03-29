package com.felipegabriel.lembreteswebservice.service;

import com.felipegabriel.lembreteswebservice.model.Usuario;

public interface UsuarioService {
	
	Usuario salvarUsuario(Usuario usuario);
	
	Usuario buscarUsuarioPorEmailESenha(String email, String senha);
}
