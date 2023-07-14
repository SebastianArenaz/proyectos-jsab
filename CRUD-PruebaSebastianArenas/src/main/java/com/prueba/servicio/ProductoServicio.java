package com.prueba.servicio;

import com.prueba.entidad.Producto;

import java.util.List;

public interface ProductoServicio {

	public List<Producto>listarTodosLosProductos();

	public Producto guardarProducto(Producto producto);

	public Producto getProductoID(Long id);

	public Producto actualizarProducto(Producto producto);

	public void eliminarProducto(Long id);

}
