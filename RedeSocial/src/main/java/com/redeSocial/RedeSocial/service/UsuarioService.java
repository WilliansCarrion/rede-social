package com.redeSocial.RedeSocial.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.redeSocial.RedeSocial.model.LoginUsuarioModel;
import com.redeSocial.RedeSocial.model.UsuarioModel;
import com.redeSocial.RedeSocial.repository.UsuarioRepository;

@Service
public class UsuarioService {

		@Autowired
		private UsuarioRepository repository;
		
		public UsuarioModel CadastrarUsuario (UsuarioModel email) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			
			String senhaEncoder = encoder.encode(email.getSenha());
			email.setSenha(senhaEncoder);
			
			return repository.save(email);
		}
		
		public Optional<LoginUsuarioModel> Logar(Optional<LoginUsuarioModel> user) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Optional<UsuarioModel> email = repository.findByEmail(user.get().getEmail());
			
			if (email.isPresent()) {
				if (encoder.matches(user.get().getSenha(), email.get().getSenha())) {
				
					String auth = user.get().getEmail() + ":" + user.get().getSenha();
					byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
					String authHeader = "Basic " + new String (encodeAuth);
					
					user.get().setToken(authHeader);
					user.get().setNome(email.get().getNome());
					
					return user;							
				}
			}
			return null; 
		}
}
