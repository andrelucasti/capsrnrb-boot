package br.com.api.capsrnrb.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.api.capsrnrb.models.Usuarios;

public interface DaoUsuario extends CrudRepository<Usuarios, Long> {

}
