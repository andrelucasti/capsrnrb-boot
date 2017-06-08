package br.com.api.capsrnrb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class City
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   
   @Column(name="nome")
   private String nomeCidade;
   
   @OneToMany(mappedBy = "city")
   private List<Address> address = new ArrayList<>();
   
   @ManyToOne
   private State state;

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

   public State getstate()
   {
      return this.state;
   }

   public void setstate(State state)
   {
      this.state = state;
   }
}
