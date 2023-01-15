package com.example.ecommerce.service;

import com.example.ecommerce.config.JwtService;
import com.example.ecommerce.domain.member.Address;
import com.example.ecommerce.domain.member.Member;
import com.example.ecommerce.dto.*;
import com.example.ecommerce.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;
    private final JwtService jwtService;
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
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("not found user"));

        String token = jwtService.generateToken(member);
        return LoginResponse.builder()
                .email(member.getEmail())
                .token(token)
                .name(member.getName())
                .id(member.getId())
                .build();



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
