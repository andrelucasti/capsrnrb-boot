package br.com.api.capsrnrb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Address
{

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String street;
   private String zipCode;
   private Integer number;
   private String complement;
   private String district;
   
   
   @OneToMany(mappedBy = "address")
   private List<User> usuarios = new ArrayList<>();
   
   @ManyToOne
   private City city;

   public Integer getId()
   {
      return this.id;
   }

   public void setId(Integer id)
   {
      this.id = id;
   }

   public String getstreet()
   {
      return this.street;
   }

   public void setstreet(String street)
   {
      this.street = street;
   }

   public String getzipCode()
   {
      return this.zipCode;
   }

   public void setzipCode(String zipCode)
   {
      this.zipCode = zipCode;
   }

   public Integer getnumber()
   {
      return this.number;
   }

   public void setnumber(Integer number)
   {
      this.number = number;
   }

   public String getcomplement()
   {
      return this.complement;
   }

   public void setcomplement(String complement)
   {
      this.complement = complement;
   }

   public City getCity()
   {
      return this.city;
   }

   public void setCidade(City city)
   {
      this.city = city;
   }

public String getdistrict() {
	return district;
}

public void setdistrict(String district) {
	this.district = district;
}
}
