package com.urbanshop.cliente.service;

import com.urbanshop.cliente.client.WishlistClient;
import com.urbanshop.cliente.dto.WishlistDTO;
import com.urbanshop.cliente.model.Cliente;
import com.urbanshop.cliente.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private WishlistClient wishlistClient;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    // 2. metodo que llama a wishlist
    public List<WishlistDTO> obtenerFavoritosDeCliente(Long idCliente) {

        // verificacion de existencia de cliente en base de datos
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        if (cliente.isEmpty()) {
            throw new RuntimeException("El cliente con ID " + idCliente + " no existe.");
        }

        // Si el cliente existe, usamos OpenFeign para ir a buscar sus datos al puerto 8083
        return wishlistClient.obtenerWishlistDelUsuario(idCliente);
    }
}
