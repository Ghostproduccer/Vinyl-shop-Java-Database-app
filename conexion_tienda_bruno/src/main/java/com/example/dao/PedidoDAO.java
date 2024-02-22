package com.example.dao;

import com.example.model.Pedido;

import java.util.List;

public interface PedidoDAO {

    List<Pedido> getAllPedidos();

    Pedido getPedidoById(int id);

    boolean insertPedido(Pedido pedido);

    boolean updatePedido(Pedido pedido);

    boolean deletePedido(int id);
}

