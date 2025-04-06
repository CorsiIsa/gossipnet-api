package br.com.fiap.apigossipnet.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRespository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
    
    public User create(User user){
        return userRepository.save(user);
    }
}
