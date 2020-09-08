package fr.afpa.projetregistation.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import fr.afpa.projetregistation.dto.UtilisateurDto;
import fr.afpa.projetregistation.utils.Constantes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class TestLoginController {
	
	@GetMapping("/user")
	public ResponseEntity<UtilisateurDto> currentUser(HttpSession session, Principal user) {
		UtilisateurDto userDto = (UtilisateurDto) session.getAttribute(Constantes.USER_EN_COURS);
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(userDto == null) {
			userDto = new UtilisateurDto();
			userDto.setMatricule(user.getName());
			for(GrantedAuthority role : authentication.getAuthorities()) {
				String roleUtilisateur = role.getAuthority();
				if (roleUtilisateur == "ROLE_EMPLOYE") {
					userDto.setResponsable(true);
				}else if (roleUtilisateur == "ROLE_EMPLOYE") {
					userDto.setResponsable(false);
				}
				break;
			}
		}
		return ResponseEntity.ok(userDto);
	}
	
}
