package com.redeSocial.RedeSocial.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_postagem")
public class PostagemModel {

		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		private long id;
		
		@NotNull
		private String descricao;
		
		private int likes;
		
		@ManyToOne
		@JsonIgnoreProperties ("postagem")
		private TemaModel tema; 

		@ManyToOne
		@JsonIgnoreProperties ("postagem")
		private UsuarioModel usuario; 
		
		public long getId() {
			 return id; 
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public int getLikes() {
			return likes;
		}

		public void setLikes(int likes) {
			this.likes = likes;
		}

		public TemaModel getTema() {
			return tema;
		}

		public void setTema(TemaModel tema) {
			this.tema = tema;
		}

		public UsuarioModel getUsuario() {
			return usuario;
		}

		public void setUsuario(UsuarioModel usuario) {
			this.usuario = usuario;
		} 	
}
