-- phpMyAdmin SQL Dump
-- version 4.2.12deb2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-07-2015 a las 22:46:48
-- Versión del servidor: 5.6.25-0ubuntu0.15.04.1
-- Versión de PHP: 5.6.4-4ubuntu6.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gym`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE IF NOT EXISTS `administradores` (
`id_administrador` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`id_administrador`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Correo`, `Usuario`, `Password`) VALUES
(1, 'ppp', 'ppp', 'ppp', 'ppp', 'ppp', 'ppp', 'ppp'),
(2, '111', '111', '111', '111', '111', '111', '1111'),
(3, 'qqq', 'qqq', 'qqq', 'qqq', 'qqq', 'qqq', 'qqq'),
(4, 'nomADM', 'apenomADM', 'telnomADM', 'dirnomADM', 'emanomADM', 'usunomADM', 'connomADM');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
`id_empleado` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Usuario` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`id_empleado`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Correo`, `Usuario`, `Password`) VALUES
(1, 'Jorge', 'Estrada', '85-65-52-15', 'Azcapotzalco', 'jorge@gmail.com', '', ''),
(9, 'esdrf', 'gt', 'fds', 'gfd', 'gfd', '', 'gfd'),
(10, 'hfd', 'gf', 'gfg', 'f', 'gf', '', 'gf'),
(11, 'dasvd', 'cx', 'ndg', 'vbfvfdvdf', 'vfdvfd', '', 'vfdvfd'),
(12, 'jhng', 'bgf', 'bgfv', 'gfv', 'fvg', '', '555'),
(15, 'fgdf', 'dfv', 'vdf', 'vsdx', 'vsd', 'vsdx', 'vsd'),
(16, '222', '222', '222', '222', '222', '222', '222'),
(17, 'empleado', 'empleadoApe', 'empleadoTel', 'empDir', 'empEMA', 'empUsua', 'empCon'),
(18, 'nomEMP', 'apeEMP', 'telEMP', 'dirEMP', 'emaEMP', 'usuEMP', 'conEMP'),
(19, 'Julio', 'Chavez', 'Carrazco', 'Morelia', 'jcarrazco@hotmail.com', 'jcarrazco', 'jcarrazco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE IF NOT EXISTS `historial` (
`id_historial` int(10) NOT NULL,
  `Identificacion` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Fecha` varchar(50) NOT NULL,
  `Hora` varchar(50) NOT NULL,
  `Estatus` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`id_historial`, `Identificacion`, `Usuario`, `Fecha`, `Hora`, `Estatus`) VALUES
(1, 'Empleado', '222', '2015-07-21', '21:17', 'Salida'),
(2, 'Empleado', '222', '2015-07-21', '21:18', 'Entrada'),
(3, 'Empleado', '222', '2015-07-21', '21:18', 'Salida'),
(4, 'Empleado', '222', '2015-07-21', '21:18', 'Entrada'),
(5, 'Empleado', 'vsdx', '2015-07-21', '21:20', 'Entrada'),
(6, 'Empleado', 'vsdx', '2015-07-21', '21:20', 'Salida'),
(7, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Entrada'),
(8, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Salida'),
(9, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Entrada'),
(10, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Salida'),
(11, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Entrada'),
(12, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Salida'),
(13, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Entrada'),
(14, 'Empleado', 'usuEMP', '2015-07-21', '21:26', 'Salida'),
(15, 'Empleado', 'empUsua', '2015-07-21', '21:30', 'Entrada'),
(16, 'Empleado', 'empUsua', '2015-07-21', '21:30', 'Salida'),
(17, 'Usuario', 'usuUSU', '2015-07-21', '21:30', 'Entrada'),
(18, 'Usuario', 'usuUSU', '2015-07-21', '21:31', 'Salida'),
(19, 'Usuario', 'usuUSU', '2015-07-21', '21:31', 'Entrada'),
(20, 'Empleado', '222', '2015-07-21', '21:58', 'Entrada'),
(21, 'Empleado', '222', '2015-07-21', '21:58', 'Salida'),
(22, 'Usuario', '333', '2015-07-21', '21:59', 'Entrada'),
(23, 'Usuario', '333', '2015-07-21', '21:59', 'Salida'),
(24, 'Usuario', '333', '2015-07-23', '21:51', 'Entrada'),
(25, 'Empleado', '222', '2015-07-23', '21:52', 'Entrada'),
(26, 'Empleado', '222', '2015-07-23', '21:52', 'Salida'),
(27, 'Empleado', '222', '2015-07-23', '21:52', 'Entrada'),
(28, 'Empleado', '222', '2015-07-23', '21:52', 'Salida'),
(29, 'Empleado', '222', '2015-07-23', '21:52', 'Entrada'),
(30, 'Empleado', '222', '2015-07-23', '21:52', 'Salida'),
(31, 'Empleado', '222', '2015-07-23', '21:53', 'Entrada'),
(32, 'Empleado', '222', '2015-07-23', '21:53', 'Salida'),
(33, 'Empleado', '222', '2015-07-23', '21:53', 'Entrada'),
(34, 'Empleado', '222', '2015-07-23', '21:53', 'Salida'),
(35, 'Empleado', '222', '2015-07-23', '21:53', 'Entrada'),
(36, 'Empleado', '222', '2015-07-23', '22:16', 'Salida'),
(37, 'Empleado', '222', '2015-07-23', '22:16', 'Entrada'),
(38, 'Empleado', '222', '2015-07-23', '22:17', 'Salida'),
(39, 'Empleado', '222', '2015-07-23', '22:17', 'Entrada'),
(40, 'Empleado', '222', '2015-07-23', '22:18', 'Salida'),
(41, 'Usuario', '333', '2015-07-23', '22:22', 'Salida'),
(42, 'Usuario', 'george5', '2015-07-23', '22:23', 'Entrada'),
(43, 'Empleado', '222', '2015-07-24', '01:51', 'Entrada'),
(44, 'Empleado', '222', '2015-07-24', '01:51', 'Salida'),
(45, 'Usuario', '333', '2015-07-30', '15:43', 'Entrada'),
(46, 'Empleado', 'jcarrazco', '2015-07-30', '13:00', 'Entrada'),
(47, 'Empleado', 'jcarrazco', '2015-07-30', '18:03', 'Salida'),
(48, 'Empleado', 'jcarrazco', '2015-07-29', '13:05', 'Entrada'),
(49, 'Empleado', 'jcarrazco', '2015-07-29', '18:10', 'Salida');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`id_usuario` int(10) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Telefono` varchar(50) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `Correo` varchar(50) NOT NULL,
  `Usuario` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `Nombre`, `Apellido`, `Telefono`, `Direccion`, `Correo`, `Usuario`, `Password`) VALUES
(2, '33', '33', '33', '3333', '33', '333', '333'),
(5, 'usuNAME', 'usuAPE', 'usuTEL', 'usuDIR', 'usuEMA', 'usuUSU', 'usuCON'),
(6, 'Jorge', 'Soliz', '98754125', 'Bolivia 22 Col. Peralvillo', 'jorge23@hotmail.com', 'george5', '123');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
 ADD PRIMARY KEY (`id_administrador`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
 ADD PRIMARY KEY (`id_empleado`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
 ADD PRIMARY KEY (`id_historial`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
MODIFY `id_administrador` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
MODIFY `id_empleado` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
MODIFY `id_historial` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=50;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id_usuario` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
