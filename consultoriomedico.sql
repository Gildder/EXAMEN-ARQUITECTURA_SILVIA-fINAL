-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-07-2016 a las 22:05:58
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `consultoriomedico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consulta`
--

CREATE TABLE IF NOT EXISTS `consulta` (
  `idconsulta` int(11) NOT NULL,
  `fecha` varchar(20) NOT NULL,
  `hora` varchar(20) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `idmedico` int(11) NOT NULL,
  `iddiagnostico` int(11) NOT NULL,
  `idsintoma` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `consulta`
--

INSERT INTO `consulta` (`idconsulta`, `fecha`, `hora`, `idpaciente`, `idmedico`, `iddiagnostico`, `idsintoma`) VALUES
(1, '2016-04-20', '09:00:00', 1, 1, 1, 1),
(2, '2016-04-25', '11:00:00', 2, 2, 3, 3),
(3, '2/07/2016', '14:23', 1, 1, 1, 1),
(4, '2/07/2016', '15:25', 1, 1, 1, 1),
(5, '2/07/2016', '14:52', 1, 1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `diagnostico`
--

CREATE TABLE IF NOT EXISTS `diagnostico` (
  `iddiagnostico` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `diagnostico`
--

INSERT INTO `diagnostico` (`iddiagnostico`, `descripcion`) VALUES
(1, 'reposo absoluto'),
(2, 'inyeccion intramuscular'),
(3, 'internacion'),
(4, 'tomar amoxilina 100MG');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `idmedico` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `especialidad` varchar(20) NOT NULL,
  `codigoprofesional` varchar(15) NOT NULL,
  `idturno` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`idmedico`, `nombre`, `especialidad`, `codigoprofesional`, `idturno`) VALUES
(1, 'silvia ramirez', 'cardiologia', '01', 1),
(2, 'noris', 'medico cirujano', '02', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notapago`
--

CREATE TABLE IF NOT EXISTS `notapago` (
  `idnotapago` int(11) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `fecha` varchar(50) NOT NULL,
  `hora` varchar(50) NOT NULL,
  `monto` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `notapago`
--

INSERT INTO `notapago` (`idnotapago`, `descripcion`, `fecha`, `hora`, `monto`, `idpaciente`, `idusuario`) VALUES
(1, 'consulta medica', '2016-04-18', '08:30:00', 45, 3, 1),
(2, 'laboratorio', '2016-04-20', '10:30:00', 80, 3, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `idpaciente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechanac` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `tiposangre` varchar(10) NOT NULL,
  `peso` int(11) NOT NULL,
  `estadoCivil` varchar(50) NOT NULL DEFAULT 'soltero'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idpaciente`, `nombre`, `fechanac`, `telefono`, `tiposangre`, `peso`, `estadoCivil`) VALUES
(1, 'silvi lorena añez', '2010-12-10', 72532562, 'ORH+', 45, 'soltero'),
(2, 'noris quintanilla', '1999-05-23', 74582369, 'A+', 52, 'soltero'),
(3, 'wendy Callejas', '1994-07-15', 71258696, 'A+', 53, 'soltero');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sintoma`
--

CREATE TABLE IF NOT EXISTS `sintoma` (
  `idsintoma` int(11) NOT NULL,
  `descripcion` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sintoma`
--

INSERT INTO `sintoma` (`idsintoma`, `descripcion`) VALUES
(1, 'dolor de cuerpo'),
(2, 'dolor muscular'),
(3, 'dolor de muela'),
(4, 'tos seca y dolor de garganta'),
(5, 'gripe con alegia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turno`
--

CREATE TABLE IF NOT EXISTS `turno` (
  `idturno` int(11) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  `horainicio` varchar(20) NOT NULL,
  `horafin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `turno`
--

INSERT INTO `turno` (`idturno`, `descripcion`, `horainicio`, `horafin`) VALUES
(1, 'manana', '08:00:00', '12:00:00'),
(2, 'tarde', '14:00:00', '18:00:00'),
(3, 'noche', '18:00:00', '23:00:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idusuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `telefono` int(11) NOT NULL,
  `tipo` varchar(50) NOT NULL,
  `ci` varchar(20) NOT NULL,
  `contrasena` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idusuario`, `nombre`, `telefono`, `tipo`, `ci`, `contrasena`) VALUES
(1, 'silvia ramirez', 74125638, 'doctor', '715264', 'silvis'),
(2, 'nora quinteros', 7452689, 'secretaria', '7415628', 'noris'),
(3, 'vladi lazcano', 96535123, 'administrador', '6253489', 'vladimir');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `consulta`
--
ALTER TABLE `consulta`
 ADD PRIMARY KEY (`idconsulta`), ADD KEY `fk_paciente_consulta_idx` (`idpaciente`), ADD KEY `fk_medico_consulta_idx` (`idmedico`), ADD KEY `fk_diagnostico_consulta_idx` (`iddiagnostico`), ADD KEY `fk_sintoma_consulta_idx` (`idsintoma`);

--
-- Indices de la tabla `diagnostico`
--
ALTER TABLE `diagnostico`
 ADD PRIMARY KEY (`iddiagnostico`);

--
-- Indices de la tabla `medico`
--
ALTER TABLE `medico`
 ADD PRIMARY KEY (`idmedico`), ADD KEY `fk_turno_medico_idx` (`idturno`);

--
-- Indices de la tabla `notapago`
--
ALTER TABLE `notapago`
 ADD PRIMARY KEY (`idnotapago`), ADD KEY `fk_usuario_notapago_idx` (`idusuario`), ADD KEY `fk_paciente_notapago_idx` (`idpaciente`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
 ADD PRIMARY KEY (`idpaciente`);

--
-- Indices de la tabla `sintoma`
--
ALTER TABLE `sintoma`
 ADD PRIMARY KEY (`idsintoma`);

--
-- Indices de la tabla `turno`
--
ALTER TABLE `turno`
 ADD PRIMARY KEY (`idturno`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`idusuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `consulta`
--
ALTER TABLE `consulta`
ADD CONSTRAINT `fk_diagnostico_consulta` FOREIGN KEY (`iddiagnostico`) REFERENCES `diagnostico` (`iddiagnostico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_medico_consulta` FOREIGN KEY (`idmedico`) REFERENCES `medico` (`idmedico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_paciente_consulta` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_sintoma_consulta` FOREIGN KEY (`idsintoma`) REFERENCES `sintoma` (`idsintoma`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `medico`
--
ALTER TABLE `medico`
ADD CONSTRAINT `fk_turno_medico` FOREIGN KEY (`idturno`) REFERENCES `turno` (`idturno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notapago`
--
ALTER TABLE `notapago`
ADD CONSTRAINT `fk_paciente_notapago` FOREIGN KEY (`idpaciente`) REFERENCES `paciente` (`idpaciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_usuario_notapago` FOREIGN KEY (`idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
