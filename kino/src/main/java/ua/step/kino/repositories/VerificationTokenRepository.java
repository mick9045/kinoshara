package ua.step.kino.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.step.kino.entities.User;
import ua.step.kino.entities.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository <VerificationToken, Long> {

  VerificationToken findByToken(String token);

  VerificationToken findByUser(User user);
}
