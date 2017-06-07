package br.com.api.capsrnrb.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class DataTriagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat
	private Calendar data;
	
/*	@Transient
	@JsonIgnoreProperties
	private String dataTriagemTexto;
*/		

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataTriagem() {
		return data;
	}

	public void setDataTriagem(Calendar data) {
		this.data = data;
	}

	
}
