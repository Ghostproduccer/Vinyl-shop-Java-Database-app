-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS tienda_bruno;
USE tienda_bruno;

-- Tabla de Usuarios
CREATE TABLE users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50),
    apellido VARCHAR(50),
    email VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(15),
    contrasena VARCHAR(255)
);

-- Tabla de Vinilos
CREATE TABLE vinilos (
    id_vinilo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    artista VARCHAR(100),
    genero VARCHAR(50),
    ano_lanzamiento INT,
    precio DECIMAL(10, 2),
    stock INT
);

-- Tabla de Pedidos
CREATE TABLE pedidos (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    id_user INT,
    fecha_pedido VARCHAR(50),
    estado VARCHAR(20),
    FOREIGN KEY (id_user) REFERENCES users(id_user)
);

-- Tabla de Detalles del Pedido
CREATE TABLE detalles_pedido (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_vinilo INT,
    cantidad INT,
    precio_unitario DECIMAL(10, 2),
    FOREIGN KEY (id_pedido) REFERENCES pedidos(id_pedido),
    FOREIGN KEY (id_vinilo) REFERENCES vinilos(id_vinilo)
);

-- Inserción de datos para la tabla 'vinilos'
INSERT INTO vinilos (nombre, artista, genero, ano_lanzamiento, precio, stock)
VALUES 
    ('Smooth Orbit Over The Detroit River', 'Brian Kage', 'Techno', 2022, 19.99, 50),
    ('Cube', 'Eddie Fowlkes', 'High Tech Soul', 2021, 24.99, 30),
    ('Capsize', 'Dying In Beauty', 'Dancefloor Weapon', 2023, 15.99, 40),
    ('From Hunk To Husk', 'Karenn', 'Techno', 2024, 22.50, 20),
    ('Shine (Ritzee Lee Remix)', 'Shinedoe', 'Techno', 2022, 18.75, 35),
    ('The Will To Overcome', 'DJ Bone', 'Techno', 2021, 21.00, 25),
    ('Maintain 313', 'Cybotron', 'Techno', 2023, 17.50, 45),
    ('Im The Machine', 'William Arist', 'London Acid Techno', 2022, 20.99, 30),
    ('8am In Salford', 'Blasha & Allatt', 'Warehouse Rumbler', 2023, 23.50, 15),
    ('Dead Ashcid', 'Jacquarius', 'Techno', 2024, 16.25, 40);

-- Inserción de datos para la tabla 'users'
INSERT INTO users (nombre, apellido, email, direccion, telefono, contrasena)
VALUES 
    ('Bruno', 'Bruno', 'bruno@example.com', 'calle mayor', '666665748', 'password123'),
    ('Alice', 'Smith', 'alice.smith@example.com', '456 Oak St', '6684635253', 'secretword'),
    ('Bob', 'Johnson', 'bob.johnson@example.com', '789 Maple St', '698567453', 'letmein');

-- Inserción de datos para la tabla 'pedidos'
INSERT INTO pedidos (id_user, fecha_pedido, estado)
VALUES 
    (1, '2024-01-27', 'En proceso'),
    (2, '2024-01-28', 'Enviado'),
    (3, '2024-01-29', 'Entregado');

-- Inserción de datos para la tabla 'detalles_pedido'
INSERT INTO detalles_pedido (id_pedido, id_vinilo, cantidad, precio_unitario)
VALUES 
    (1, 1, 2, 19.99),
    (1, 3, 1, 15.99),
    (2, 5, 3, 18.75),
    (3, 8, 1, 20.99),
    (3, 10, 2, 16.25);


