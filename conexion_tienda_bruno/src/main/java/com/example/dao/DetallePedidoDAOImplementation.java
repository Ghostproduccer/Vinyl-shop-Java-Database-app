package com.example.dao;

import com.example.model.DetallePedido;
import com.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetallePedidoDAOImplementation implements DetallePedidoDAO {

    @Override
    public List<DetallePedido> getAllDetallesPedidos() {
        List<DetallePedido> detallesPedidos = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
                Statement statement = con.createStatement()) {
            String sql = "SELECT * FROM detalles_pedido;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idDetalle = rs.getInt("id_detalle");
                int idPedido = rs.getInt("id_pedido");
                int idVinilo = rs.getInt("id_vinilo");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                DetallePedido detallePedido = new DetallePedido(idDetalle, idPedido, idVinilo, cantidad,
                        precioUnitario);
                detallesPedidos.add(detallePedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallesPedidos;
    }

    @Override
    public DetallePedido getDetallePedidoById(int id) {
        DetallePedido detallePedido = null;
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con
                        .prepareStatement("SELECT * FROM detalles_pedido WHERE id_detalle = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                int idVinilo = rs.getInt("id_vinilo");
                int cantidad = rs.getInt("cantidad");
                double precioUnitario = rs.getDouble("precio_unitario");
                detallePedido = new DetallePedido(id, idPedido, idVinilo, cantidad, precioUnitario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detallePedido;
    }

    @Override
    public boolean insertDetallePedido(DetallePedido detallePedido) {
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(
                        "INSERT INTO detalles_pedido (id_pedido, id_vinilo, cantidad, precio_unitario) VALUES (?, ?, ?, ?)")) {
            preparedStatement.setInt(1, detallePedido.getIdPedido());
            preparedStatement.setInt(2, detallePedido.getIdVinilo());
            preparedStatement.setInt(3, detallePedido.getCantidad());
            preparedStatement.setDouble(4, detallePedido.getPrecioUnitario());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateDetallePedido(DetallePedido detallePedido) {
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(
                        "UPDATE detalles_pedido SET id_pedido = ?, id_vinilo = ?, cantidad = ?, precio_unitario = ? WHERE id_detalle = ?")) {
            preparedStatement.setInt(1, detallePedido.getIdPedido());
            preparedStatement.setInt(2, detallePedido.getIdVinilo());
            preparedStatement.setInt(3, detallePedido.getCantidad());
            preparedStatement.setDouble(4, detallePedido.getPrecioUnitario());
            preparedStatement.setInt(5, detallePedido.getIdDetalle());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteDetallePedido(int id) {
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con
                        .prepareStatement("DELETE FROM detalles_pedido WHERE id_detalle = ?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
