package com.example.dao;

import com.example.model.Vinilo;
import com.example.util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViniloDAOImplementation implements ViniloDAO {

    @Override
    public List<Vinilo> getAllVinilos() {
        List<Vinilo> vinilos = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
            Statement statement = con.createStatement()) {
            String sql = "SELECT * FROM vinilos;";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int idVinilo = rs.getInt("id_vinilo");
                String nombre = rs.getString("nombre");
                String artista = rs.getString("artista");
                String genero = rs.getString("genero");
                int anoLanzamiento = rs.getInt("ano_lanzamiento");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                Vinilo vinilo = new Vinilo(idVinilo, nombre, artista, genero, anoLanzamiento, precio, stock);
                vinilos.add(vinilo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vinilos;
    }

    @Override
    public Vinilo getViniloById(int id) {
        Vinilo vinilo = null;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM vinilos WHERE id_vinilo = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String artista = rs.getString("artista");
                String genero = rs.getString("genero");
                int anoLanzamiento = rs.getInt("ano_lanzamiento");
                double precio = rs.getDouble("precio");
                int stock = rs.getInt("stock");
                vinilo = new Vinilo(id, nombre, artista, genero, anoLanzamiento, precio, stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vinilo;
    }

    @Override
    public boolean insertVinilo(Vinilo vinilo) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO vinilos (nombre, artista, genero, ano_lanzamiento, precio, stock) VALUES (?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, vinilo.getNombre());
            preparedStatement.setString(2, vinilo.getArtista());
            preparedStatement.setString(3, vinilo.getGenero());
            preparedStatement.setInt(4, vinilo.getAnoLanzamiento());
            preparedStatement.setDouble(5, vinilo.getPrecio());
            preparedStatement.setInt(6, vinilo.getStock());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateVinilo(Vinilo vinilo) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("UPDATE vinilos SET nombre = ?, artista = ?, genero = ?, ano_lanzamiento = ?, precio = ?, stock = ? WHERE id_vinilo = ?")) {
            preparedStatement.setString(1, vinilo.getNombre());
            preparedStatement.setString(2, vinilo.getArtista());
            preparedStatement.setString(3, vinilo.getGenero());
            preparedStatement.setInt(4, vinilo.getAnoLanzamiento());
            preparedStatement.setDouble(5, vinilo.getPrecio());
            preparedStatement.setInt(6, vinilo.getStock());
            preparedStatement.setInt(7, vinilo.getIdVinilo());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteVinilo(int id) {
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM vinilos WHERE id_vinilo = ?")) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

