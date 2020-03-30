package com.felipegabriel.lembreteswebservice.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.felipegabriel.lembreteswebservice.model.Lembrete;

@Repository
public interface LembreteRepository extends JpaRepository<Lembrete, Integer>{
	
	
	@Query(value = "select l from Lembrete l where upper(l.titulo) like %?1% and l.fkUsuario.pkUsuario = ?2 order by l.titulo asc")
	public List<Lembrete> listarLembretesPorTitulo(String titulo, Integer pkUsuario);
	
	@Query(value = "select l from Lembrete l where l.fkUsuario.pkUsuario = ?1 order by l.pkLembrete desc")
	public Page<Lembrete> listarLembretes(Integer pkUsuario, Pageable page);
}
