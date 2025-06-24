package com.example.TechFlowSpa.repository;

import  com.example.TechFlowSpa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends  JpaRepository<Usuario,Integer> {
}
