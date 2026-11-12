package com.shopsoft.controller;
import com.shopsoft.model.Producto;
import com.shopsoft.repository.ProductoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/** Controlador MVC para las operaciones del inventario. */
@Controller
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoRepository repository;
    public ProductoController(ProductoRepository repository){this.repository=repository;}

    // Consulta y muestra todos los productos.
    @GetMapping
    public String listar(Model model){
        model.addAttribute("productos", repository.findAll());
        return "productos/lista";
    }

    // Presenta el formulario vacío para registrar.
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("producto", new Producto());
        model.addAttribute("titulo", "Registrar producto");
        return "productos/formulario";
    }

    // Guarda un producto nuevo o actualizado.
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Producto producto){
        if(producto.getIdCategoria()==null) producto.setIdCategoria(1);
        repository.save(producto);
        return "redirect:/productos";
    }

    // Carga un producto existente para editar.
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model){
        Producto producto=repository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Producto no encontrado: "+id));
        model.addAttribute("producto", producto);
        model.addAttribute("titulo", "Editar producto");
        return "productos/formulario";
    }

    // Elimina el producto seleccionado.
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        repository.deleteById(id);
        return "redirect:/productos";
    }
}
