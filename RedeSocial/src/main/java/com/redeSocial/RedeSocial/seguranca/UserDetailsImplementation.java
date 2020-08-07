package com.redeSocial.RedeSocial.seguranca;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.redeSocial.RedeSocial.model.UsuarioModel;

public class UserDetailsImplementation implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	private String password;
	
	public UserDetailsImplementation(UsuarioModel user) {
		this.userName = user.getEmail(); //Email = usuário
		this.password = user.getSenha(); 
	}
	
	public UserDetailsImplementation() {}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
