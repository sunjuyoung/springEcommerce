package com.example.ecommerce.valid;

import com.example.ecommerce.dto.RegisterRequest;
import com.example.ecommerce.dto.RegisterResponse;
import com.example.ecommerce.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class RegisterValidation implements Validator {

    private final MemberRepository memberRepository;


    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RegisterRequest registerRequest = (RegisterRequest) target;
        if(memberRepository.existsByEmail(registerRequest.getEmail())){
            errors.rejectValue("email","wrong.value","해당 이메일은 이미 존재합니다.");

        }
        if(memberRepository.existsByName(registerRequest.getName())){
            errors.rejectValue("name","wrong.value","해당 닉네임은 이미 존재합니다.");
        }

    }
}
