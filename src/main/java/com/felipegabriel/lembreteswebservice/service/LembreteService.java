package com.felipegabriel.lembreteswebservice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.felipegabriel.lembreteswebservice.model.Lembrete;

public interface LembreteService {
	
	Lembrete salvarLembrete(Lembrete lembrete);
	
	Lembrete buscarLembrete(Integer pkLembrete);
	
	void deletarLembrete(Integer pkLembrete);
	
	Lembrete atualizarLembrete(Lembrete lembrete);
	
	Page<Lembrete> listarLembretes(Integer pagina, Integer qtdRegistros, Integer pkUsuario);
	
	List<Lembrete> listarLembretesPorTitulo(String titulo, Integer pkUsuario);
	
}
