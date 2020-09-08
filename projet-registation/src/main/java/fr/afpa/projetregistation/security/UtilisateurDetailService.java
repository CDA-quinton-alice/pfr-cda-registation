package fr.afpa.projetregistation.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.afpa.projetregistation.dao.IUtilisateurDao;
import fr.afpa.projetregistation.entity.UtilisateurEntity;


@Service
public class UtilisateurDetailService implements UserDetailsService {
	
	@Autowired
	private IUtilisateurDao utilisateurDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username.trim().isEmpty()) {
			throw new UsernameNotFoundException("Le username est vide");
		}
 
		Optional<UtilisateurEntity> userOpt = this.utilisateurDao.findById(username);
 
		if (! userOpt.isPresent()) {
			throw new UsernameNotFoundException("Utilisateur " + username + " non trouvé");
		}
		
		UtilisateurEntity user = userOpt.get();
		return new org.springframework.security.core.userdetails.User(user.getMatricule(), user.getConnexion().getPassword(), getGrantedAuthorities(user));
	}
 
	private List<GrantedAuthority> getGrantedAuthorities(UtilisateurEntity user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
//		RoleEntity role = user.getRole();
		if (user.isResponsable()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_RESPONSABLE"));
		}else if (!user.isResponsable()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYE"));
		}
		return authorities;
	}

}
