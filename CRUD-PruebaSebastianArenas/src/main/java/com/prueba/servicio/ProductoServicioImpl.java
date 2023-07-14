package com.prueba.servicio;

import com.prueba.entidad.Producto;
import com.prueba.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductoServicioImpl implements ProductoServicio {

    @Autowired
    private ProductoRepositorio repositorio;

    @Override
    public List<Producto> listarTodosLosProductos() {
        // TODO Auto-generated method stub
        return repositorio.findAll();
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public Producto getProductoID(Long id) {
        return repositorio.findById(id).get();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        return repositorio.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        repositorio.deleteById(id);
    }

}
