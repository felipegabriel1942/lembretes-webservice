package com.felipegabriel.lembreteswebservice.service;

import org.springframework.data.domain.Page;

import com.felipegabriel.lembreteswebservice.model.Lembrete;

public interface LembreteService {
	
	Lembrete salvarLembrete(Lembrete lembrete);
	
	Lembrete buscarLembrete(Integer pkLembrete);
	
	void deletarLembrete(Integer pkLembrete);
	
	Lembrete atualizarLembrete(Lembrete lembrete);
	
	Page<Lembrete> listarLembretes(Integer pagina, Integer qtdRegistros, Integer pkUsuario);
	
	Page<Lembrete> listarLembretesPorTitulo(Integer pagina, Integer qtdRegistros, String titulo, Integer pkUsuario);
	
}
