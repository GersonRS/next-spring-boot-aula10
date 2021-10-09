package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable{

  private static final long serialVersionUID = 87236483268L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String nome;
  @Column
  private String sobrenome;
  @Column
  private String login;
  @Column
  private String senha;

  public Usuario() {
  }

  public Usuario(final String nome, final String sobrenome, final String login, final String senha) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.login = login;
    this.senha = senha;
  }

  public Usuario(final Long id, final String nome, final String sobrenome, final String login, final String senha) {
    this.id = id;
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.login = login;
    this.senha = senha;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(final Long id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(final String nome) {
    this.nome = nome;
  }
  public String getSobrenome() {
    return sobrenome;
  }
  public void setSobrenome(final String sobrenome) {
    this.sobrenome = sobrenome;
  }
  public String getLogin() {
    return login;
  }
  public void setLogin(final String login) {
    this.login = login;
  }
  public String getSenha() {
    return senha;
  }
  public void setSenha(final String senha) {
    this.senha = senha;
  }
}
