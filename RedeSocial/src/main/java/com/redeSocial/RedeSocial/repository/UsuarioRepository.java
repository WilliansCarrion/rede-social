package com.redeSocial.RedeSocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redeSocial.RedeSocial.model.LoginUsuarioModel;
import com.redeSocial.RedeSocial.model.UsuarioModel;
//Não importou model Usuário

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
		public Optional <UsuarioModel> findByEmail(String email);

}
