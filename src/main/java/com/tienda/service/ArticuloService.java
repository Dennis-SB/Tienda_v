package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {
    public List<Articulo> getArticulos(boolean activos);
    public void save(Articulo cliente);
    public void delete(Articulo cliente);
    public Articulo getArticulo(Articulo cliente);
}
