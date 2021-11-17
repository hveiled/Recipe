package recipes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import recipes.model.User;
import recipes.repository.UserRepo;

import java.util.logging.Logger;

@Service
public class UserRegistrationService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    Logger logger = Logger.getGlobal();

    public void saveUser(User user) {

        if (userRepo.existsByEmail(user.getEmail())) {
            logger.warning("saveUser: " + user.getEmail());
            logger.warning("saveUser: " + user.getPassword());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
