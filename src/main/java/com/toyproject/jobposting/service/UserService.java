package com.toyproject.jobposting.service;

import com.toyproject.jobposting.Repository.UserRepository;
import com.toyproject.jobposting.dto.LoginDto;
import com.toyproject.jobposting.dto.UserDto;
import com.toyproject.jobposting.entity.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void save(User user){
        LoginDto userDto = new LoginDto();
        userDto.setIdentity(user.getIdentity());
        userDto.setPassword(user.getPassword());
        validateDuplicateUser(userDto);
        userRepository.save(user);
    }

    private void validateDuplicateUser(LoginDto user) {

        List<User> findUser = userRepository.findByIdentity(user);
        if(!findUser.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public List<User> findByIdentity(LoginDto loginDto){
        return userRepository.findByIdentity(loginDto);
    }

    public List<User> findUser() {
        return userRepository.findUsers();
    }

    public List<User> findById(String Identity){
        return userRepository.findById(Identity);
    }
    @Transactional
    public User updateUser(Long id, User target){
        User find = userRepository.findOne(id);
        find.setPhoneNumber(target.getPhoneNumber());
        find.setUserStatus(target.getUserStatus());
        find.setName(target.getName());
        find.setPassword(target.getPassword());
        find.setIdentity(target.getIdentity());
        find.setEmail(target.getEmail());
        return find;
    }

    public User findOne(Long id){
        return userRepository.findOne(id);
    }

    @Transactional
    public void deleteUser(Long id){
        userRepository.deleteUser(id);
    }
}
