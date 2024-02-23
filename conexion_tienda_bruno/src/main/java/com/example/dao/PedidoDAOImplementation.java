package com.example.dao;

import com.example.model.Pedido;
import com.example.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAOImplementation implements PedidoDAO {

    @Override
    public List<Pedido> getAllPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
            Statement statement = con.createStatement()) {
            String sql = "SELECT * FROM pedidos;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idPedido = rs.getInt("id_pedido");
                int idUser = rs.getInt("id_user");
                String fechaPedido = rs.getString("fecha_pedido");
                String estado = rs.getString("estado");
                Pedido pedido = new Pedido(idPedido, idUser, fechaPedido, estado);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedidos;
    }

    @Override
    public Pedido getPedidoById(int id) {
        Pedido pedido = null;
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con
                        .prepareStatement("SELECT * FROM pedidos WHERE id_pedido = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                int idUser = rs.getInt("id_user");
                String fechaPedido = rs.getString("fecha_pedido");
                String estado = rs.getString("estado");
                pedido = new Pedido(id, idUser, fechaPedido, estado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pedido;
    }

    @Override
    public int insertPedido(Pedido pedido) {
        int idGenerado = -1;
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(
                        "INSERT INTO pedidos (id_user, fecha_pedido, estado) VALUES (?, ?, ?)",
                        Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, pedido.getIdUser());
            preparedStatement.setString(2, pedido.getFechaPedido());
            preparedStatement.setString(3, pedido.getEstado());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                return idGenerado;
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idGenerado = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("No se pudo obtener el ID generado para el pedido.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idGenerado;
    }

    @Override
    public boolean updatePedido(Pedido pedido) {
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement(
                        "UPDATE pedidos SET id_user = ?, fecha_pedido = ?, estado = ? WHERE id_pedido = ?")) {
            preparedStatement.setInt(1, pedido.getIdUser());
            preparedStatement.setString(2, pedido.getFechaPedido());
            preparedStatement.setString(3, pedido.getEstado());
            preparedStatement.setInt(4, pedido.getIdPedido());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePedido(int id) {
        try (Connection con = DatabaseConnection.getConnection();
                PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM pedidos WHERE id_pedido = ?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
