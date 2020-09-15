package fr.afpa.projetregistation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.afpa.projetregistation.dao.IUserTestDao;
import fr.afpa.projetregistation.entity.UserTestEntity;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserTestController {

	@Autowired
	IUserTestDao userDao;
	
	@GetMapping("/userstest")
    public List<UserTestEntity> getUsers() {
        return (List<UserTestEntity>) userDao.findAll();
    }
 
    @PostMapping("/userstest")
    void addUser(@RequestBody UserTestEntity user) {
        userDao.save(user);
    }
	
   
}
