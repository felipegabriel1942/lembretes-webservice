package com.felipegabriel.lembreteswebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipegabriel.lembreteswebservice.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	
	@Query(value = "select u from Usuario u where u.email = ?1 and u.senha = ?2")
	public Usuario buscarUsuarioPorEmailESenha(String email, String senha);
}
