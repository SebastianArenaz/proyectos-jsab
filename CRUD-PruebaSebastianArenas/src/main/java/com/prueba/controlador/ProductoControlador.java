package com.prueba.controlador;

import com.prueba.entidad.Producto;
import com.prueba.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductoControlador {

    @Autowired
    private ProductoServicio servicio;

    @GetMapping({"/productos", "/"})
    public String listarProductos(Model modelo) {
        modelo.addAttribute("productos", servicio.listarTodosLosProductos());
        return "productos";//Retornamos Los Productos
    }


    @GetMapping("/productos/nuevo")
    public String MostrarProductosFormulario(Model modelo) {
        Producto producto = new Producto();
        modelo.addAttribute("producto", producto);
        return "crear_productos";//Retornamos Los Productos
    }

    @PostMapping("/productos")
    public String guardarProducto(@ModelAttribute("producto") Producto producto) {
        servicio.guardarProducto(producto);
        return "redirect:/productos";//Retornamos Los Productos
    }

    @GetMapping("/productos/editar/{id}")
    public String MostrarFormularioEditarProducto(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("producto", servicio.getProductoID(id));
        return "editar_productos";//Retornamos Los Productos
    }

    @PostMapping("/productos/{id}")
    public String ActualizarProducto(@PathVariable Long id, @ModelAttribute("producto") Producto producto, Model modelo) {
        Producto productoEncontrado = servicio.getProductoID(id);

        productoEncontrado.setId(id);
        productoEncontrado.setNombre(producto.getNombre());
        productoEncontrado.setCategoria(producto.getCategoria());
        productoEncontrado.setPeso(producto.getPeso());
        productoEncontrado.setPrecio(producto.getPrecio());
        productoEncontrado.setReferencia(producto.getReferencia());
        productoEncontrado.setFecha(producto.getFecha());
        productoEncontrado.setStock(producto.getStock());

        servicio.actualizarProducto(productoEncontrado);

        return "redirect:/productos";
    }

    @GetMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        servicio.eliminarProducto(id);
        return "redirect:/productos";
    }






    /** En esta parte tenemos los controladores que muestran el status del endpoint consumido, que en este caso podemos usar desde el postman **/


    @GetMapping("rest/productos/{id}")
    public ResponseEntity<Producto> eliminarProductoID(@PathVariable Long id) {
        try {


            Producto productoEncontrado = servicio.getProductoID(id);

            /***Verificamos que el producto si exista en la base de datos para poder eliminarlo **/
            if (productoEncontrado.getId() != null) {
                servicio.eliminarProducto(id);
                return new ResponseEntity<Producto>(HttpStatus.OK);
            }else {
                return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
        }


    }

    @PostMapping("rest/productos/GuardarNuevoProducto")
    public ResponseEntity<Producto> guardarNuevoProducto(@RequestBody Producto producto) {
        try {
            servicio.guardarProducto(producto);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("rest/productos/ActualizarProductoID/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Producto> ActualizarProductoID(@RequestBody Producto producto, @PathVariable Long id) {

        try {
            Producto productoEncontrado = servicio.getProductoID(id);
            /***Verificamos que el producto si exista en la base de datos para poder Actualizarlo**/
            if (productoEncontrado.getId() != null) {
                productoEncontrado.setId(id);
                productoEncontrado.setNombre(producto.getNombre());
                productoEncontrado.setCategoria(producto.getCategoria());
                productoEncontrado.setPeso(producto.getPeso());
                productoEncontrado.setPrecio(producto.getPrecio());
                productoEncontrado.setReferencia(producto.getReferencia());
                productoEncontrado.setFecha(producto.getFecha());
                productoEncontrado.setStock(producto.getStock());

                servicio.actualizarProducto(productoEncontrado);
                return new ResponseEntity<Producto>(HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Producto>(HttpStatus.BAD_REQUEST);

    }

    //Con este metodo Listamos todos los productos registrados
    @GetMapping("rest/productos/ListarTodo")
    @ResponseStatus(value = HttpStatus.OK)
    public @ResponseBody List<Producto> listarTodosProductos() {
        List<Producto> lista = servicio.listarTodosLosProductos();
        if (lista.isEmpty()) {
            return null;
        }
        return lista;
    }


}
