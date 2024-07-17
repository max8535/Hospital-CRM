package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entitiy.User;
import com.example.demo.exceptions.user.UserNotFoundException;
import com.example.demo.repo.UserRepo;
import com.example.demo.utils.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(User user, RoleEnum roleEnum) {
        user.setRole(roleEnum);
        return userRepo.save(user);
    }

    public User getUserById(Long id) throws UserNotFoundException {
        User user = userRepo.findById(id).orElse(null);
        if (user == null) {
            throw new UserNotFoundException("ID");
        }
//        List<Long> userLikes = likeRepo.findAllLikesIdByUserId(user.getId());
//        List<Long> userRepostedRepostIds = repostRepo.findAllRepostsIdsByUserId(user.getId());
//        UserDTO userDTO = UserDTO.toModel(user);
//        userDTO.setFollowings(followerRepo.findAllFollowsOnIdByUserId(userDTO.getId()));
//        userDTO.setFollowers(followerRepo.findAllUserIdByFollowsOnId(userDTO.getId()));
//        userDTO.setLikes(userLikes);
//        userDTO.setReposts(userRepostedRepostIds);
        return user;
    }

    public User findByLogin(String login) {
        User user = userRepo.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найден", login));
        }
        return user;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByLogin(username);
        return new org.springframework.security.core.userdetails.User(
                user.getLogin(),
                user.getPassword(),
                Collections.emptyList()
        );
    }
}
