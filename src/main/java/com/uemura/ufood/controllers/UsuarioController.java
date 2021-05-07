package com.uemura.ufood.controllers;

import com.uemura.ufood.domains.Dto.LoginDto;
import com.uemura.ufood.domains.Dto.UsuarioDto;
import com.uemura.ufood.services.UsuarioService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @ApiOperation(value = "Login")
    @PostMapping("/v1/login")
    public ResponseEntity login(@RequestBody LoginDto loginDto) {
        if(service.login(loginDto)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }

    @ApiOperation(value = "Salvar")
    @PostMapping("/v1/salvar")
    public ResponseEntity salvar(@RequestBody UsuarioDto usuario) {
        service.salvar(usuario);
        return ResponseEntity.ok().build();
    }
}
