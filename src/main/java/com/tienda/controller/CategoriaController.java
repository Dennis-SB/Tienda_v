package com.tienda.controller;

import com.tienda.domain.Categoria;
import com.tienda.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaservice;
    @GetMapping("/categoria/listado")
    public String inicio(Model model) {
        var categorias = categoriaservice.getCategorias(false);
        model.addAttribute("categorias",categorias);
        return "/categoria/listado";
    }
    
    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modificar";
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria) {
        categoriaservice.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model) {
        categoria = categoriaservice.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modificar";
    }
    
    @GetMapping("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria) {
        categoriaservice.delete(categoria);
        return "redirect:/categoria/listado";
    }
}