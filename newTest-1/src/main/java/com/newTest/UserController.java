package com.newTest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.ToString;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	BoardRepository boardRepository;
	
	@GetMapping("/boards")
	public List getAllBoards(){ 
		return boardRepository.findAll();
	}
	
	@GetMapping("/users")
	public List getAllUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board){
		return boardRepository.save(board);
	}
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable(value="id") Long userId) {
		return userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable(value="id") Long userId
			,@RequestBody User userDetail) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("user", "id", userId));
		
		user.setFirst_name(userDetail.getFirst_name());
		user.setLast_name(userDetail.getLast_name());
		user.setEmail(userDetail.getEmail());
		
		User updateUser = userRepository.save(user);
		return updateUser;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value="id") Long userId){
		User user = userRepository.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("user", "id", userId));
		userRepository.delete(user);
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	
	
	
	
	

}
