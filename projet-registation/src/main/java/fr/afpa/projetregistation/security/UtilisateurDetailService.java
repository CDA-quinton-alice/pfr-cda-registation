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
import fr.afpa.projetregistation.entity.ConnexionEntity;
import fr.afpa.projetregistation.entity.UtilisateurEntity;

@Service
public class UtilisateurDetailService implements UserDetailsService {

	@Autowired
	private IUtilisateurDao utilisateurDao;

	@Override
	public UserDetails loadUserByUsername(String matricule) throws UsernameNotFoundException {
		if (matricule.trim().isEmpty()) {
			throw new UsernameNotFoundException("matricule is empty");
		}

		Optional<UtilisateurEntity> userOpt = this.utilisateurDao.findById(matricule);

		if (!userOpt.isPresent()) {
			throw new UsernameNotFoundException("User " + matricule + " not found");
		}

		UtilisateurEntity uEnt = userOpt.get();
		ConnexionEntity user = uEnt.getConnexion();
		return new org.springframework.security.core.userdetails.User(user.getMatricule(), user.getPassword(),
				getGrantedAuthorities(uEnt));
	}

	private List<GrantedAuthority> getGrantedAuthorities(UtilisateurEntity uEnt) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		boolean role = uEnt.isResponsable();
		if (role == true) {
			authorities.add(new SimpleGrantedAuthority("ROLE_RESPONSABLE"));
		} else {
			authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYE"));
		}
		return authorities;
	}

}
