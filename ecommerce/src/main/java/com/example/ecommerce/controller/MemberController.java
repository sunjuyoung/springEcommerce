package com.example.ecommerce.controller;

import com.example.ecommerce.dto.*;
import com.example.ecommerce.service.MemberService;
import com.example.ecommerce.valid.RegisterValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {


    private final MemberService memberService;
    private final RegisterValidation registerValidation;

    @InitBinder("registerRequest")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(registerValidation);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterRequest registerRequest,
                                                     BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
       RegisterResponse registerResponse =  memberService.register(registerRequest);
       return ResponseEntity.ok().body(registerResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request){
        LoginResponse login = memberService.login(request);
        return ResponseEntity.ok().body(login);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMembers(){
        List<MemberResponse> members = memberService.getMembers();
        return ResponseEntity.ok().body(members);
    }
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable("memberId")Long mId){
        MemberResponse member = memberService.getMember(mId);
        return ResponseEntity.ok().body(member);
    }

    @PutMapping("/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable("memberId")Long mId,
                                                       @RequestBody MemberUpdateRequest request){
        log.info("====");
        log.info(request.getName());
        log.info(request.getEmail());
        memberService.updateMember(mId,request);
        return ResponseEntity.ok().body("success");
    }
    @DeleteMapping("/{memberId}")
    public ResponseEntity<?> updateMember(@PathVariable("memberId")Long mId){
        memberService.deleteMember(mId);
        return ResponseEntity.ok().body("success");
    }

}
