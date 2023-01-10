package com.example.ecommerce.service;

import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.dto.LoginRequest;
import com.example.ecommerce.dto.LoginResponse;
import com.example.ecommerce.dto.RegisterRequest;
import com.example.ecommerce.dto.RegisterResponse;
import com.example.ecommerce.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService   {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;

    public RegisterResponse register(RegisterRequest request) {
        Member member = new Member(
                request.getName(),
                passwordEncoder.encode(request.getPassword()),
                request.getEmail()
        );
        memberRepository.save(member);
        return modelMapper.map(member,RegisterResponse.class);

    }

    public LoginResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken token =  new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_GUEST"))
        );
        authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(token);
        return LoginResponse.builder()
                .email(request.getEmail())
                .build();


    }

}
