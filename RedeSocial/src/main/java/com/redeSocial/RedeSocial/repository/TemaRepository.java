package com.redeSocial.RedeSocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redeSocial.RedeSocial.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long> {

}
