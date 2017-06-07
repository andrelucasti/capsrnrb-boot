package br.com.api.capsrnrb.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Endereco
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String rua;
   private String cep;
   private Integer numero;
   private String complemento;
   private String bairro;
   
   
   @OneToMany(mappedBy = "endereco")
   @JsonIgnoreProperties(value="endereco")
   private List<Usuarios> usuarios;
   
   @ManyToOne
   private Cidade cidade;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getRua()
   {
      return this.rua;
   }

   public void setRua(String rua)
   {
      this.rua = rua;
   }

   public String getCep()
   {
      return this.cep;
   }

   public void setCep(String cep)
   {
      this.cep = cep;
   }

   public Integer getNumero()
   {
      return this.numero;
   }

   public void setNumero(Integer numero)
   {
      this.numero = numero;
   }

   public String getComplemento()
   {
      return this.complemento;
   }

   public void setComplemento(String complemento)
   {
      this.complemento = complemento;
   }

   public Cidade getCidade()
   {
      return this.cidade;
   }

   public void setCidade(Cidade cidade)
   {
      this.cidade = cidade;
   }

public String getBairro() {
	return bairro;
}

public void setBairro(String bairro) {
	this.bairro = bairro;
}
}
