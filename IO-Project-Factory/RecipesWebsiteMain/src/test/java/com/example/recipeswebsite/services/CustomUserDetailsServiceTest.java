package com.example.recipeswebsite.services;

import static org.junit.jupiter.api.Assertions.*;

import com.example.recipeswebsite.model.User;
import com.example.recipeswebsite.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DataJpaTest
class CustomUserDetailsServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService userService;

    @BeforeEach
    void setUp() {
        userService = new CustomUserDetailsService(userRepository);
    }

    @Test
    public void testLoadUserByUsername_ValidUser() {
        // given
        String email = "test@example.com";
        String password = "password";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        //when
        when(userRepository.findByEmail(email)).thenReturn(user);

        // then
        UserDetails userDetails = userService.loadUserByUsername(email);

        verify(userRepository).findByEmail(email);
        assertThat(userDetails.getUsername()).isEqualTo(email);
        assertThat(userDetails.getPassword()).isEqualTo(password);
    }


    @Test
    public void testLoadUserByUsername_InvalidUser() {
        //given
        String email = "nonexistent@example.com";

        //when
        when(userRepository.findByEmail(email)).thenReturn(null);

        //then
        assertThrows(UsernameNotFoundException.class, () -> userService.loadUserByUsername(email));
        verify(userRepository).findByEmail(email);
    }
}