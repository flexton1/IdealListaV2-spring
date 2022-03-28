package IdealListaV2.IdealListaV2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import IdealListaV2.IdealListaV2.model.User;
import IdealListaV2.IdealListaV2.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepo;


    public User findByEmail(String email){
		User user = userRepo.findUserByEmail(email).orElse(null);
		return user;
	}

    public User saveUser(User user) {
			User newUser = userRepo.save(user);
			return newUser;
	}

	public List<User> getUsers(){
		List<User> userList = userRepo.findAll();
		return userList;
	}
	
	public void setLoginStatusAsTrue(String email){
		User user = findByEmail(email);
		user.setEnabled(true);
		userRepo.save(user);
	}

	public void setLoginStatusAsFalse(String id){
		User user = findById(id);
		user.setEnabled(false);
		userRepo.save(user);
	}

	public void setUserRole(String id, String role){
		User user = findById(id);
		user.setRole("user");
		userRepo.save(user);
	}
	
	public List<User> getOnlineUsers(){
		List<User> userList = userRepo.findUserModelByEnabled(true).orElse(null);
		return userList;
	}
	public User findById(String id){
		User user = userRepo.findUserModelByUserId(id).orElse(null);
		return user;
	}

	public User updateUser(User User){
		return userRepo.save(User);
	}

	public void deleteUser(String id){
		userRepo.deleteById(id);
	}

}
