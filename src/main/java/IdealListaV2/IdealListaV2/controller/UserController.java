package IdealListaV2.IdealListaV2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IdealListaV2.IdealListaV2.exceptions.GenericResponse;
import IdealListaV2.IdealListaV2.model.User;
import IdealListaV2.IdealListaV2.service.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    private final UserService userService;

  //  Get all online users
    @GetMapping("/admin/active")
    public List<User> getOnlineUser(){
        List<User> userList = userService.getOnlineUsers();
        return userList;
    }

   // Get all users
    @GetMapping("/admin")
    public List<User> getAllUsers(){
        List<User> userList = userService.getUsers();
        return userList;
    }

   // find user from db
    @GetMapping("/{id}")
    public User userEditData(@PathVariable(value="id") String id){
        User user = userService.findById(id);
        return user;
    }

   // Edit user data
    @PutMapping("/userEdit/{id}")
    public User userUpdate(@RequestBody User user, @PathVariable String id){
        User userM = userService.findById(id);
        user.setId(id);
        if(user.getUsername()!=null){
            userM.setUsername(user.getUsername());
        }
        if(user.getEmail()!=null){
            userM.setEmail(user.getEmail());
        }
        String pass = user.getPassword();
        if(user.getPassword()!=null && !(pass.equals(""))){
            userM.setPassword(user.getPassword());
        }
        if(user.getMobileNumber()!=null){
            userM.setMobileNumber(user.getMobileNumber());
        }
        if(userM!=null){
        userM = userService.updateUser(userM);
        }
        return userM;
    }

   // Delete user
    @DeleteMapping("/admin/delete/{id}")
    public void userDelete(@PathVariable String id){
        userService.deleteUser(id);
    }

    //Add user in db
    @PostMapping("/admin/addUser")
	public GenericResponse<Boolean> addUser(@RequestBody User user){
        GenericResponse<Boolean> response = new GenericResponse<>();
		if(userService.findByEmail(user.getEmail()) == null){
			userService.saveUser(user);
			response.setResponse(true);
		}
        response.setResponse(false);
		return response;
	}

    //Logout user (Setting active as false)
    @PostMapping("/logout/{id}")
	public boolean userLogout(@PathVariable String id){
        User user = userService.findById(id);
        if(user!=null){
		    userService.setLoginStatusAsFalse(id);
            return true;
        }
        else
        {
            return false;
        }
	}
}
