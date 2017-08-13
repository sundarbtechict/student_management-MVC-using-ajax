-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 13, 2017 at 10:38 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STUDENT_ID` int(20) NOT NULL,
  `REG_NO` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL,
  `DOB` date DEFAULT NULL,
  `DEPT` varchar(20) DEFAULT NULL,
  `EMAIL` varchar(30) DEFAULT NULL,
  `MOBILE` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STUDENT_ID`, `REG_NO`, `NAME`, `DOB`, `DEPT`, `EMAIL`, `MOBILE`) VALUES
(1, '101', 'Jagadeesh', '1990-08-05', 'IT', 'jaganttp@gmail.com', '9642691215'),
(2, '102', 'Sundar', '2000-12-14', 'ICT', 'sundarttp@gmail.com', '9600672982'),
(3, '103', 'Saran', '1999-11-29', 'ICT', 'saranttp@gmail.com', '123456'),
(106, '104', 'Sangeeth', '1999-11-29', 'IT', 'sangttp@gmail.com', '123456');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STUDENT_ID`),
  ADD UNIQUE KEY `regno` (`STUDENT_ID`),
  ADD UNIQUE KEY `REG_NO` (`REG_NO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `STUDENT_ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
