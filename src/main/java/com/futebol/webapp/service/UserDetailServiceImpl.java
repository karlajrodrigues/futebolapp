package com.futebol.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.futebol.webapp.model.Usuario;
import com.futebol.webapp.repository.UsuarioRepository;
import com.futebol.webapp.util.PasswordUtil;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = usuarioRepository.findByLogin(username).orElseThrow(()-> 
        new UsernameNotFoundException("Usuário não encontrado"));
        String senha = PasswordUtil.encoderPassword(usuario.getPassword());
        return User.builder().username(usuario.getLogin())
        .password(PasswordUtil.encoderPassword(usuario.getPassword()))
        .roles("USER")
        .build();

    }
}
