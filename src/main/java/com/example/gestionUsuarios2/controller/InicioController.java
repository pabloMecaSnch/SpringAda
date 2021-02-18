/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.gestionUsuarios2.controller;

import com.example.gestionUsuarios2.negocio.entity.Tarea;
import com.example.gestionUsuarios2.negocio.entity.Usuario;
import com.example.gestionUsuarios2.negocio.service.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class InicioController {
    
    private final UsuarioService usuService;

    public InicioController(UsuarioService usuService) {
       
        this.usuService = usuService;
        
    }
    
    
    @RequestMapping("/")
    public String listarusuarios(Model modelo){
        
        List<Usuario> usuarios =usuService.listarUsuarios();
        modelo.addAttribute("usuarios",usuarios);
        
        return"listado_usuarios";
    }    
    
     @RequestMapping("/crear_usuario")
    public String crearusuario(Model modelo){
        Usuario usuario = new Usuario();
        modelo.addAttribute("usuario",usuario);
        return "crear_usuario";
    }
    @PostMapping("/guardar")
    public String guardarUsuario(Usuario usuario){
        System.out.println(usuario.getNombre());
        usuService.guardarUsuario(usuario);
        return"redirect:/";
    }
     @RequestMapping("/crear_tarea")
     public String creartarea(Model modelo){
        List<Usuario> usuarios =usuService.listarUsuarios();
        modelo.addAttribute("usuarios",usuarios);
        Tarea tarea = new Tarea();
         System.out.println("tarea creada");
        modelo.addAttribute("tarea",tarea);
        System.out.println("tarea añadida");
        return "crear_tarea";
    }
    @PostMapping("/guardar_tarea")
    public String guardarTarea(Tarea tarea, @RequestParam Integer selectUsuario){
        System.out.println(selectUsuario);
        Usuario usu = new Usuario(selectUsuario);
        tarea.setUsuarioId(usu);
        usuService.guardarTarea(tarea);
        return"redirect:/";
    }
    @RequestMapping("/tarea_edit/{id}")
    public String editTarea(@PathVariable(value="id") Integer tareaId, Model modelo){
        Tarea tareaBase = usuService.getTareaById(tareaId);
        modelo.addAttribute("tarea",tareaBase);
        System.out.println(tareaBase.getNombre());
        return "/tarea_edit";
    }
    
}
