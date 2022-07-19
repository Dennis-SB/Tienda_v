package com.tienda.service;

import com.tienda.dao.ArticuloDao;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {
    @Autowired
    private ArticuloDao articulodao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) articulodao.findAll();
        if(activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional
    public void save(Articulo cliente) {
        articulodao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Articulo cliente) {
        articulodao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo cliente) {
        return articulodao.findById(cliente.getIdArticulo()).orElse(null);
    }
}