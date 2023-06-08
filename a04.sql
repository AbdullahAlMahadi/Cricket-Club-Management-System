-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 28, 2019 at 04:08 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `a04`
--

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE `coach` (
  `coachId` varchar(6) NOT NULL,
  `coachName` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` int(11) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`coachId`, `coachName`, `email`, `phone`, `salary`) VALUES
('c1', 'Tom', 'tom@gmail.com', 1710599456, 50000.00),
('c2', 'Jack', 'jack@gmail.com', 1829116927, 60000.00),
('c3', 'Kirsten', 'Kirsten@gmail.com', 1710544456, 60000.00),
('c4', 'John', 'John@gmail.com', 1921416345, 50000.00),
('c5', 'Whatmore', 'Whatmore@gmail.com', 1710588888, 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c1', '1234', 1),
('c2', '1234', 1),
('c3', '1234', 1),
('c4', '1234', 1),
('c5', '1234', 1),
('m1', '1234', 0),
('m2', '1234', 0),
('m3', '1234', 0),
('m4', '1234', 0),
('m5', '1234', 0),
('p1', '1234', 2),
('p2', '1234', 2),
('p3', '1234', 2),
('p4', '1234', 2),
('p5', '1234', 2),
('p6', '1234', 2),
('p7', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `manager`
--

CREATE TABLE `manager` (
  `managerId` varchar(6) NOT NULL,
  `managerName` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` int(11) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manager`
--

INSERT INTO `manager` (`managerId`, `managerName`, `email`, `phone`, `salary`) VALUES
('m1', 'Atik', 'atik@gmail.com', 1324568791, 40000.00),
('m2', 'Piyal', 'piyal@gmail.com', 1423658741, 20000.00),
('m3', 'shuvo', 'shuvo@gmail.com', 1753245698, 30000.00),
('m4', 'Sakib', 'sakib@gmail.com', 823145698, 40000.00),
('m5', 'Tamim', 'tamim@gmail.com', 1921456327, 30000.00);

-- --------------------------------------------------------

--
-- Table structure for table `match`
--

CREATE TABLE `match` (
  `matchNo` varchar(6) NOT NULL,
  `matchType` varchar(20) NOT NULL,
  `schedule` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `match`
--

INSERT INTO `match` (`matchNo`, `matchType`, `schedule`, `status`) VALUES
('mn5', 'ODI', '20-sep', 'win'),
('mn6', 'TEST', '30-oct', 'loss'),
('mn7', 'ODI', '20dec', 'win');

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE `player` (
  `playerId` varchar(6) NOT NULL,
  `playerName` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `phone` int(11) NOT NULL,
  `salary` double(8,2) NOT NULL,
  `playerType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`playerId`, `playerName`, `email`, `phone`, `salary`, `playerType`) VALUES
('p1', 'Masrafee', 'masrafee@gmail.com', 1598745621, 50000.00, 'Bowler'),
('p2', 'Rubel', 'rubel@gmail.com', 1523478962, 32000.00, 'Bowler'),
('p3', 'Sabbir', 'sabbir@gmail.com', 1756894213, 20000.00, 'Batsman'),
('p4', 'Tamim', 'Tamim@gmail.com', 1569874521, 40000.00, 'Batsman'),
('p5', 'Sakib', 'sakib@gmail.com', 1587941526, 40000.00, 'All Rounder'),
('p6', 'Miraz', 'miraj@gmail.com', 1895641238, 40000.00, 'All Rounder'),
('p7', 'Mushfiqur', 'Mushfiqur@gmail.com', 178945612, 40000.00, 'Wicket-keeper Batsma');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`coachId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);

--
-- Indexes for table `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`managerId`);

--
-- Indexes for table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`matchNo`);

--
-- Indexes for table `player`
--
ALTER TABLE `player`
  ADD PRIMARY KEY (`playerId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
