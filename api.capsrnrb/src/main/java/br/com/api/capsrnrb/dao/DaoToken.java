package br.com.api.capsrnrb.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.api.capsrnrb.models.Token;

public interface DaoToken extends CrudRepository<Token, String> {

}
