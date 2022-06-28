package com.tienda.service;

import com.tienda.dao.ClienteDao;
import com.tienda.domain.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteDao clientedao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clientedao.findAll();
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clientedao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clientedao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clientedao.findById(cliente.getIdCliente()).orElse(null);
    }
}