package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.conversion.UserMapper;
import com.netcracker.blogproject.dto.UserDTO;
import com.netcracker.blogproject.entities.User;
import com.netcracker.blogproject.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(value = "User Controller", description = "Getting user list, registration and signing in by users, deleting users by admins")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "Getting the user (account) during the entering to the block using a login and a password")
    @RequestMapping(method = RequestMethod.POST, value = "/enter")
    public UserDTO enterByLoginAndPassword(@RequestBody String[] userLoginPassword) {
        return userMapper.userToUserDTO(userService.enterByLoginAndPassword(userLoginPassword));
    }

    @ApiOperation(value = "Getting all the users (accounts) with full information or not (it depends on the admin status)")
    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<UserDTO> getAllUsers(int userId) {
        if (userId == 0) return null;
        List<User> userList = userService.getAllUsers(userId);
        if(userList.isEmpty()) {
            return null;
        } else {
            List<UserDTO> userDTOList = new ArrayList<UserDTO>();
            for(User user : userList) {
                userDTOList.add(userMapper.userToUserDTO(user));
            }
            return userDTOList;
        }
    }

    @ApiOperation(value = "Deleting some user (by Id) by the admin")
    @RequestMapping(method = RequestMethod.DELETE, value = "/{accountId}/delete")
    public boolean deleteUserById(@PathVariable int accountId, int userId) {
        if(accountId == 0 || userId == 0) return false;
        return userService.deleteUserById(accountId, userId);
    }

    @ApiOperation(value = "Adding a new user during its registration")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public UserDTO addUser(@RequestBody UserDTO userDTO) {
        User user = userMapper.userDTOtoUser(userDTO);
        User userAdded = userService.addUser(user);
        if(userAdded != null) {
            return userMapper.userToUserDTO(userAdded);
        } else {
            return null;
        }
    }

}
