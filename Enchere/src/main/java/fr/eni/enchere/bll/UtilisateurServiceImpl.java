package fr.eni.enchere.bll;

import java.security.Principal;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.eni.enchere.bo.Utilisateur;
import fr.eni.enchere.dal.UtilisateurDAO;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDAO utilisateurDAO;
	private final PasswordEncoder passwordEncoder;
	
	public UtilisateurServiceImpl(UtilisateurDAO utilisateurDAO, PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
		this.utilisateurDAO = utilisateurDAO;
	}

	@Override
	public void creerProfil(Utilisateur utilisateur) {
		utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
		utilisateurDAO.save(utilisateur);
		
	}

	@Override
	public void supprimerProfil(Principal principal) {
		utilisateurDAO.delete(principal);
		
	}

	@Override
	public void enregistrerProfil(Utilisateur utilisateur) {
		utilisateurDAO.save(utilisateur);
		
	}

	@Override
	public Utilisateur findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findByPseudo(String pseudo) {
		return utilisateurDAO.findByPseudo(pseudo);
	}

}
