package com.example.ecommerce.service;

import com.example.ecommerce.config.CustomUser;
import com.example.ecommerce.domain.member.Address;
import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.dto.*;
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
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

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
       // UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
//        UsernamePasswordAuthenticationToken token =  new UsernamePasswordAuthenticationToken(
//                userDetails,null,
//                List.of(new SimpleGrantedAuthority("ROLE_GUEST"))
//        );
//       // authenticationManager.authenticate(token);
//        SecurityContextHolder.getContext().setAuthentication(token);
//        return LoginResponse.builder()
//                .email(request.getEmail())
//                .build();
        return null;


    }

    public MemberResponse getMember(Long mId) {
        Member member = memberRepository.findById(mId)
                .orElseThrow(() -> new UsernameNotFoundException("not found user"));
        return modelMapper.map(member, MemberResponse.class);
    }

    public void updateMember(Long mId, MemberUpdateRequest request) {
        Member member = memberRepository.findById(mId)
                .orElseThrow(() -> new UsernameNotFoundException("not found user"));
        Address address = new Address(request.getCity(), request.getStreet(), request.getZipcode());
        member.updateMember(request,address);

    }

    public void deleteMember(Long mId) {
        memberRepository.deleteMemberAndReviewsById(mId);
    }

    public List<MemberResponse> getMembers() {
        List<Member> memberList = memberRepository.findAll();
        List<MemberResponse> memberResponses = new ArrayList<>();
        memberList.forEach(member -> {
            memberResponses.add(modelMapper.map(member, MemberResponse.class));
        });
        return memberResponses;
    }


}
