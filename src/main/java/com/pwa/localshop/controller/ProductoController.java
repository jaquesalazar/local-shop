package com.pwa.localshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pwa.localshop.repository.ProductoRepository;

@Controller
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("productos", productoRepository.findAll());
        return "index";
    }
}