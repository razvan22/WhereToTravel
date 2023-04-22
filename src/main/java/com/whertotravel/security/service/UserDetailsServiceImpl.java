package com.whertotravel.security.service;

import com.whertotravel.entities.user.repository.UserRepository;
import com.whertotravel.security.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var user = userRepository.findUserByEmail(username);
    return user.map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
  }
}
