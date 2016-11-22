package br.com.gerencia.configuration.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.gerencia.model.ContaUsuario;
import br.com.gerencia.service.ContaUsuarioService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {



	@Autowired
	private ContaUsuarioService contaUserService;

	
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		ContaUsuario user = (ContaUsuario) contaUserService.pesquisarConta(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Username not found");
		}
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ADMIN");
		 authorities.add(auth);
		 
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(),true, true, true, true,
				authorities);
	}


}
