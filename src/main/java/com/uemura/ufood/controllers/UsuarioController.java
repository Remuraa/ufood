package com.uemura.ufood.controllers;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(value = "loginDto") LoginDto loginDto) {
        if(service.login(loginDto)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
}
