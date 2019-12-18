-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-12-2019 a las 09:00:04
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sociedad`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gastos`
--

CREATE TABLE IF NOT EXISTS `gastos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `gasto` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `gastos`
--

INSERT INTO `gastos` (`id`, `id_usuario`, `gasto`) VALUES
(1, 1, 2.1),
(2, 1, 3.6),
(3, 1, 1.2),
(4, 1, 5.5),
(5, 1, 1.05),
(6, 1, 1.05),
(7, 1, 3.15),
(8, 1, 2.4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mesa`
--

CREATE TABLE IF NOT EXISTS `mesa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nombre` (`nombre`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `mesa`
--

INSERT INTO `mesa` (`id`, `nombre`) VALUES
(1, 'mesa 1'),
(2, 'mesa 2'),
(3, 'mesa 3'),
(4, 'mesa 4');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE IF NOT EXISTS `productos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `tipo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `cantidad_disponible` int(11) NOT NULL,
  `precio` float NOT NULL,
  `minimo_disponible` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `nombre`, `tipo`, `cantidad_disponible`, `precio`, `minimo_disponible`) VALUES
(2, 'fanta naranja', 'refresco', 21, 1.2, 10),
(3, 'vino', 'bebida_alcoholica', 20, 3.5, 7),
(4, 'cerveza', 'bebida_alcoholica', 20, 1.8, 10),
(5, 'tabaco a', 'tabaco', 7, 5.5, 5),
(6, 'tabaco b', 'tabaco', 7, 6.3, 5),
(7, 'Coca cola', 'refresco', 9, 1.05, 10),
(8, 'Nestea', 'refresco', 13, 1.2, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE IF NOT EXISTS `reservas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `fecha` date DEFAULT NULL,
  `hora` varchar(5) COLLATE utf8_spanish_ci DEFAULT NULL,
  `mesa` varchar(15) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mesa` (`mesa`),
  KEY `hora` (`hora`),
  KEY `hora_2` (`hora`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=16 ;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`id`, `id_usuario`, `fecha`, `hora`, `mesa`) VALUES
(13, 1, '2019-12-20', '14:00', 'mesa 1'),
(14, 1, '2019-12-13', '13:00', 'mesa 1'),
(15, 1, '2019-12-13', '13:00', 'mesa 2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserva_usuario`
--

CREATE TABLE IF NOT EXISTS `reserva_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(11) NOT NULL,
  `id_reserva` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_reserva` (`id_reserva`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `num_usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `pass_usuario` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `num_usuario`, `pass_usuario`) VALUES
(1, 'Usuario', '111', '222'),
(2, 'prueba', '1', '1'),
(3, 'usuario_sha', '10', 'b1d5781111d84f7b3fe4');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`mesa`) REFERENCES `mesa` (`nombre`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `reserva_usuario`
--
ALTER TABLE `reserva_usuario`
  ADD CONSTRAINT `reserva_usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reserva_usuario_ibfk_2` FOREIGN KEY (`id_reserva`) REFERENCES `reservas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
