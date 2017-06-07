package br.com.api.capsrnrb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cidade
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name="nome")
   private String nomeCidade;
   
   @OneToMany(mappedBy = "cidade")
   private List<Endereco> enderecos;
   
   @ManyToOne
   private Estado estado;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getNome()
   {
      return this.nomeCidade;
   }

   public void setNome(String nomeCidade)
   {
      this.nomeCidade = nomeCidade;
   }

   public Estado getEstado()
   {
      return this.estado;
   }

   public void setEstado(Estado estado)
   {
      this.estado = estado;
   }
}
