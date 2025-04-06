package br.com.fiap.apigossipnet.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.fiap.apigossipnet.user.dto.UserRequest;
import br.com.fiap.apigossipnet.user.dto.UserResponse;


@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder){
        var user = userService.create(userRequest.toModel());

        var uri = uriBuilder
                  .path("/user/{id}")
                  .buildAndExpand(user.getId())
                  .toUri();

        return ResponseEntity
               .created(uri)
               .body(UserResponse.from(user));
    }
}
