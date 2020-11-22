package com.uemura.ufood.controllers;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(value = "loginDto") LoginDto loginDto) {
        return ResponseEntity.ok(service.login(loginDto));
    }
}
