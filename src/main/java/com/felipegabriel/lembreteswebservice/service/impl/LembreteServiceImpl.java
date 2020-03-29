package com.felipegabriel.lembreteswebservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.felipegabriel.lembreteswebservice.model.Lembrete;
import com.felipegabriel.lembreteswebservice.repository.LembreteRepository;
import com.felipegabriel.lembreteswebservice.service.LembreteService;

@Service
public class LembreteServiceImpl implements LembreteService{

	@Autowired
	private LembreteRepository repository;
	
	
	@Override
	public Lembrete salvarLembrete(Lembrete lembrete) {
		return repository.save(lembrete);
	}

	@Override
	public Lembrete buscarLembrete(Integer pkLembrete) {
		return repository.findById(pkLembrete).orElse(null);
	}

	@Override
	public void deletarLembrete(Integer pkLembrete) {
		repository.deleteById(pkLembrete);
	}

	@Override
	public Lembrete atualizarLembrete(Lembrete lembrete) {
		if(lembrete.getPkLembrete() != null) {
			return repository.save(lembrete);
		}
		
		return null;
	}

	@Override
	public Page<Lembrete> listarLembretes(Integer pagina, Integer qtdRegistros, Integer pkUsuario) {
		return repository.listarLembretes(pkUsuario, PageRequest.of(pagina, qtdRegistros));
	}

	@Override
	public List<Lembrete> listarLembretesPorTitulo(String titulo, Integer pkUsuario) {
		return repository.listarLembretesPorTitulo(titulo.toUpperCase(), pkUsuario);
	}

}
