package com.felipegabriel.lembreteswebservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lembrete")
public class Lembrete {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pklembrete")
	private Integer pkLembrete;
	
	private String titulo;
	
	private String texto;
	
	@Column(name = "datalembrete")
	private Date dataLembrete;
	
	@ManyToOne
	@JoinColumn(name = "fkusuario")
	private Usuario fkUsuario;
}
