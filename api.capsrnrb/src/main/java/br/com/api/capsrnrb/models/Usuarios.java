package br.com.api.capsrnrb.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuarios
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	@Column
	private String nomeMae;
	@Column
	private Integer nuProntuario;
	@Column
	private String nuCartSus;
	@Column
	private String localEmArquivo;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	@DateTimeFormat
	private Calendar dataNascimento;
	
	@ManyToMany
	@JoinTable(name = "usuarios_datatriagem", joinColumns = {@JoinColumn(name="usuarios_id")}, inverseJoinColumns = {@JoinColumn(name="colecaoDataTriagem_id")})
	private List<DataTriagem> colecaoDataTriagem = new ArrayList<>();
	
	@Column
	private String tipoDroga;
	@Column
	private String nuTelefone;
	
		
	public Long getId(){
		return this.id;
	}

	public void setId(Long id){
		this.id = id;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

	public String getNomeMae(){
		return this.nomeMae;
	}

	public void setNomeMae(String nomeMae){
		this.nomeMae = nomeMae;
	}

	public Integer getNuProntuario(){
		return this.nuProntuario;
	}

	public void setNuProntuario(Integer nuProntuario){
		this.nuProntuario = nuProntuario;
	}

	public String getNuCartSus(){
		return this.nuCartSus;
	}

	public void setNuCartSus(String nuCartSus){
		this.nuCartSus = nuCartSus;
	}

	public Calendar getDataNascimento(){
		return this.dataNascimento;
	}

	public List<DataTriagem> getColecaoDataTriagem() {
		return colecaoDataTriagem;
	}

	public void setColecaoDataTriagem(List<DataTriagem> colecaoDataTriagem) {
		this.colecaoDataTriagem = colecaoDataTriagem;
	}


	public void setDataNascimento(Calendar dataNascimento){
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco()
	{
		return this.endereco;
	}

	public void setEndereco(Endereco endereco)
	{
		this.endereco = endereco;
	}

	public String getLocalEmArquivo() {
		return localEmArquivo;
	}

	public void setLocalEmArquivo(String localEmArquivo) {
		this.localEmArquivo = localEmArquivo;
	}

	public String getTipoDroga() {
		return tipoDroga;
	}

	public void setTipoDroga(String tipoDroga) {
		this.tipoDroga = tipoDroga;
	}

	public String getNuTelefone() {
		return nuTelefone;
	}

	public void setNuTelefone(String nuTelefone) {
		this.nuTelefone = nuTelefone;
	}

		
}
