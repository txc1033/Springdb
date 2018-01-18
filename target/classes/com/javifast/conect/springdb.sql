SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";



CREATE TABLE `camiseta` (
  `id` int(6) NOT NULL,
  `numero` varchar(25) DEFAULT NULL,
  `idMarca` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `camiseta` (`id`, `numero`, `idMarca`) VALUES
(1, '10', 1),
(2, '7', 1),
(3, '11', 1);

CREATE TABLE `equipo` (
  `id` int(6) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `equipo` (`id`, `nombre`) VALUES
(1, 'Juventus'),
(2, 'Barcelona'),
(3, 'Colo-Colo');

CREATE TABLE `jugador` (
  `id` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `idEquipo` int(6) DEFAULT NULL,
  `idCamiseta` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `jugador` (`id`, `nombre`, `idEquipo`, `idCamiseta`) VALUES
(1, 'JavierMS', 1, 1),
(2, 'Javifast', 2, 2),
(3, 'test', 1, 1);

CREATE TABLE `marca` (
  `id` int(6) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `marca` (`id`, `nombre`) VALUES
(1, 'Addidas'),
(2, 'Puma');


ALTER TABLE `camiseta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idMarca` (`idMarca`);

ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IdEquipo_equipo` (`idEquipo`),
  ADD KEY `IdCamiseta_camiseta` (`idCamiseta`);

ALTER TABLE `marca`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `camiseta`
  ADD CONSTRAINT `camiseta_ibfk_1` FOREIGN KEY (`idMarca`) REFERENCES `marca` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `jugador`
  ADD CONSTRAINT `IdCamiseta_camiseta` FOREIGN KEY (`idCamiseta`) REFERENCES `camiseta` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `IdEquipo_equipo` FOREIGN KEY (`idEquipo`) REFERENCES `equipo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

