-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Dim 14 Mai 2017 à 03:29
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gestionrecette`
--

-- --------------------------------------------------------

--
-- Structure de la table `ingrediant`
--

CREATE TABLE IF NOT EXISTS `ingrediant` (
  `id_ingrediant` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ingrediant` varchar(255) DEFAULT NULL,
  `quantite` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_ingrediant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

CREATE TABLE IF NOT EXISTS `recette` (
  `id_recette` int(11) NOT NULL AUTO_INCREMENT,
  `nom_repa` varchar(255) DEFAULT NULL,
  `statut` enum('empty','pending','done') DEFAULT NULL,
  PRIMARY KEY (`id_recette`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `recette_ingrediant_user`
--

CREATE TABLE IF NOT EXISTS `recette_ingrediant_user` (
  `id_receIngUser` int(11) NOT NULL AUTO_INCREMENT,
  `id_recette` int(11) NOT NULL,
  `id_ingrediant` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id_receIngUser`),
  KEY `fk_id_recette` (`id_recette`),
  KEY `fk_id_ingrediant` (`id_ingrediant`),
  KEY `fk_id_user` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(255) DEFAULT NULL,
  `role` enum('admin','cuisinier') DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `recette_ingrediant_user`
--
ALTER TABLE `recette_ingrediant_user`
  ADD CONSTRAINT `fk_id_recette` FOREIGN KEY (`id_recette`) REFERENCES `recette` (`id_recette`),
  ADD CONSTRAINT `fk_id_ingrediant` FOREIGN KEY (`id_ingrediant`) REFERENCES `ingrediant` (`id_ingrediant`),
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
