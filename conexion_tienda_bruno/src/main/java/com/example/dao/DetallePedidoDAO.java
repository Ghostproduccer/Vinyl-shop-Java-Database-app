package com.example.dao;

import com.example.model.DetallePedido;

import java.util.List;

public interface DetallePedidoDAO {

    List<DetallePedido> getAllDetallesPedidos();

    DetallePedido getDetallePedidoById(int id);

    boolean insertDetallePedido(DetallePedido detallePedido);

    boolean updateDetallePedido(DetallePedido detallePedido);

    boolean deleteDetallePedido(int id);
}