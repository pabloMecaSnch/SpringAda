/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestionUsuarios2.negocio.service;

import com.example.gestionUsuarios2.negocio.entity.Tarea;
import com.example.gestionUsuarios2.negocio.entity.Usuario;
import com.example.gestionUsuarios2.repository.TareaRepository;
import com.example.gestionUsuarios2.repository.UsuarioRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuRepository;
    private final TareaRepository tareaRepository;
    List<Tarea> tareas1, tareas2;
    Usuario usuario;
    String nombre;

    public UsuarioService(UsuarioRepository usuRepository, TareaRepository tareaRep) {
        this.usuRepository = usuRepository;
        this.tareaRepository = tareaRep;
    }
    public void guardarUsuario(Usuario usuario){
        usuRepository.save(usuario);
    }
    public void guardarTarea(Tarea tarea){
        tareaRepository.save(tarea);
    }
    public List<Usuario> listarUsuarios(){
        
//        List<Usuario> usuarios=usuRepository.verUsuarios();
        List<Usuario> usuarios=usuRepository.findAll();
        return usuarios;
        
                
    }
    
}
