package com.autobots.automanager.entidades;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.enumeradores.TipoDocumento;

import java.util.Date;

@Data
@Entity
public class Documento extends RepresentationModel<Documento> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private TipoDocumento tipo;
	@Column(nullable = true)
	private Date dataEmissao;
	@Column(unique = true, nullable = false)
	private String numero;
}