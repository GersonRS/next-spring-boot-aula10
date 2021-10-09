package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {
  
  @Autowired
  private UsuarioRepository usuarioRepository;

  @GetMapping
  public List<Usuario> buscaUsuarios() {
    return usuarioRepository.findAll();
  }

  @PostMapping
  public Usuario adicionar(@RequestBody Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

  @PutMapping
  public Usuario atualizar(@RequestBody Usuario usuario) {
    Optional<Usuario> optionalUsuario = usuarioRepository.findById(usuario.getId());
    if(optionalUsuario.isPresent())
      return usuarioRepository.save(usuario);
    else {
      return new Usuario();
    }
  }

  @DeleteMapping(path = "/id/{varID}")
  public String deletar(@PathVariable(name = "varID", required = true) Long id) {
    Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
    try {
      usuarioRepository.delete(optionalUsuario.get());
      return "Sucesso";
    } catch (Exception e) {
      return "deu erro";
    }
  }

}
