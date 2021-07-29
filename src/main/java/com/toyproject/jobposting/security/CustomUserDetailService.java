package com.toyproject.jobposting.security;

import com.toyproject.jobposting.Repository.UserRepository;
import com.toyproject.jobposting.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User findUser = userRepository.findById(username).get(0);
        if(findUser == null){
            new UsernameNotFoundException("유저를 찾을 수 없습니다. 아이디 : "+ username);
        }
        return UserPrincipal.create(findUser);
    }
}
