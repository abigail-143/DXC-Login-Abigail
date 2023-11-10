package com.dxclogin.dxclogin.controller;

import com.dxclogin.dxclogin.model.ClearanceRoles;
import com.dxclogin.dxclogin.model.UsersModel;
import com.dxclogin.dxclogin.repository.TokensRepository;
import com.dxclogin.dxclogin.repository.UsersRepository;
import com.dxclogin.dxclogin.service.UsersService;
import io.jsonwebtoken.Jwts;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class UsersController {
    private final UsersRepository usersRepository;
    private final TokensRepository tokensRepository;

    @Autowired
    private SecretKey secretKey;

    public UsersController(UsersRepository usersRepository, TokensRepository tokensRepository) {
        this.usersRepository = usersRepository;
        this.tokensRepository = tokensRepository;
    }

    // GET, pulls list of users registered
    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        List<UsersModel> allUsers = usersRepository.findAll();
        return ResponseEntity.ok(allUsers);

    }
    // POST, registers a new account
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestParam String username, @RequestParam String password, @RequestParam String clearance) {
        try {
            String salt = BCrypt.gensalt(12);
            String encryptPW = BCrypt.hashpw(password, salt);

            UsersModel newUser = new UsersModel();
            newUser.setUsername(username);
            newUser.setPassword(encryptPW);
            newUser.setClearance(ClearanceRoles.valueOf(clearance));
            usersRepository.save(newUser);
            UsersService usersService = new UsersService("New User Registered");
            return ResponseEntity.ok(usersService);
        } catch (Exception error) {
            UsersService usersService = new UsersService("Registration Failed");
            System.out.println(error.getMessage());
            return ResponseEntity.status(501).body(usersService);
        }
    }

    // POST, logs in an existing user
    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestParam String username, @RequestParam String password) {
        Optional<UsersModel> user = usersRepository.findByUsername(username);

        if (user.isPresent()) {
            UsersModel activeUser = user.get();
            String savedPW = activeUser.getPassword();
            boolean checkPW = BCrypt.checkpw(password, savedPW);

            if (checkPW) {
                String activeUserClearance = activeUser.getClearance().toString();
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                String currentTime = timestamp.toString();
                HashMap<String, Object> newClaim = new HashMap<>();
                newClaim.put("username", username);
                newClaim.put("clearance", activeUser.getClearance());
                newClaim.put("loginAt", currentTime);
                String accessToken = Jwts.builder().claims(newClaim).signWith(secretKey).compact();

                UsersService usersService = new UsersService(accessToken, "Successful Login", username, activeUserClearance);
                return ResponseEntity.ok(usersService);
            } else {
                UsersService usersService = new UsersService("Wrong Password");
                return ResponseEntity.status(500).body(usersService);
            }
        } else {
            System.out.println(user);
            UsersService usersService = new UsersService("Invalid Username");
            return ResponseEntity.status(500).body(usersService);
        }
    }
}