-- phpMyAdmin SQL Dump
-- version 3.5.4
-- http://www.phpmyadmin.net
--
-- Host: --------------
-- Generation Time: Apr 24, 2013 at 07:18 PM
-- Server version: 5.1.59--------------------
-- PHP Version: 5.2.17

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `adeco_java`
--

-- --------------------------------------------------------

--
-- Table structure for table `Bank_Details`
--

CREATE TABLE IF NOT EXISTS `Bank_Details` (
  `Bank_Account_Number` varchar(30) DEFAULT NULL,
  `Bank_Name` varchar(50) NOT NULL,
  `Account_Holders_Name` varchar(50) NOT NULL,
  KEY `Bank_Account_Number` (`Bank_Account_Number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Bank_Details`
--

INSERT INTO `Bank_Details` (`Bank_Account_Number`, `Bank_Name`, `Account_Holders_Name`) VALUES
('1', '12', 'sdfdsg');

-- --------------------------------------------------------

--
-- Table structure for table `Courses`
--

CREATE TABLE IF NOT EXISTS `Courses` (
  `CourseID` int(11) NOT NULL,
  `Course_Name` varchar(50) NOT NULL,
  `Number of Units` int(11) NOT NULL,
  `Start_Date` datetime NOT NULL,
  `End_Date` datetime NOT NULL,
  `Type_of_Course` varchar(10) NOT NULL,
  `UnitID-1` varchar(255) DEFAULT NULL,
  `UnitID-2` varchar(255) DEFAULT NULL,
  `UnitID-3` varchar(255) DEFAULT NULL,
  `UnitID-4` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Courses`
--

INSERT INTO `Courses` (`CourseID`, `Course_Name`, `Number of Units`, `Start_Date`, `End_Date`, `Type_of_Course`, `UnitID-1`, `UnitID-2`, `UnitID-3`, `UnitID-4`) VALUES
(1, 'Computer Security and forensice', 4, '2012-10-20 00:00:00', '2015-12-20 00:00:00', 'FT', '1', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Results_Table`
--

CREATE TABLE IF NOT EXISTS `Results_Table` (
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `UnitID` varchar(255) NOT NULL,
  `Grade` varchar(5) NOT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `CourseID` (`CourseID`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Results_Table`
--

INSERT INTO `Results_Table` (`StudentID`, `CourseID`, `UnitID`, `Grade`) VALUES
(1219460, 1, '1', 'A+');

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE IF NOT EXISTS `Staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(20) DEFAULT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Surname` varchar(30) DEFAULT NULL,
  `Date_of_Birth` date NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(10) DEFAULT NULL,
  `Telephone_Number` varchar(20) NOT NULL,
  `E-mail` varchar(50) DEFAULT NULL,
  `Status` varchar(25) NOT NULL,
  `UnitID` varchar(10) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StaffID`),
  UNIQUE KEY `StaffID` (`StaffID`),
  KEY `Postcode` (`Postcode`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1219463 ;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`StaffID`, `Title`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `Telephone_Number`, `E-mail`, `Status`, `UnitID`, `Password`) VALUES
(1219460, 'MR all', 'Ale', 'ASAS', '1211-12-12', 'Female', 'LDASNSJSJDNJNdnjew', 'LU2-2RE', '+233232', 'defswfsfsfgs@o2.pl', 'DASAs', '1', 'dfefef'),
(1219461, 'value2', 'value3', NULL, '0000-00-00', '', NULL, NULL, '', NULL, '', NULL, NULL),
(1219462, 'MR', 'Alex', 'Drabek', '1992-10-04', 'Male', 'Luton', 'LU1 2JE', '1', '91991919', 'asdas@o2.pl', 'PhD', '1');

-- --------------------------------------------------------

--
-- Table structure for table `Students`
--

CREATE TABLE IF NOT EXISTS `Students` (
  `StudentID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(40) NOT NULL,
  `Surname` varchar(40) NOT NULL,
  `Date_of_Birth` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(7) DEFAULT NULL,
  `CourseID` int(11) NOT NULL,
  `Telephone_Number` varchar(20) DEFAULT NULL,
  `E-mail` varchar(50) NOT NULL,
  `Bank_Account_Number` int(20) NOT NULL,
  `Year_of_Study` int(4) NOT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StudentID`),
  UNIQUE KEY `StudentID` (`StudentID`),
  KEY `CourseID` (`CourseID`),
  KEY `Postcode` (`Postcode`),
  KEY `Bank_Account_Number` (`Bank_Account_Number`),
  KEY `StudentID_2` (`StudentID`),
  KEY `StudentID_3` (`StudentID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1219465 ;

--
-- Dumping data for table `Students`
--

INSERT INTO `Students` (`StudentID`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `CourseID`, `Telephone_Number`, `E-mail`, `Bank_Account_Number`, `Year_of_Study`, `Password`) VALUES
(1219460, 'Alexander', 'Drabek', '1991-11-07', 'Male', 'Luto nsdfnmdfndsf', 'LU2-2EE', 1, '+48 791454212', 'test@study.beds.ac.uk', 121212, 1, 'olololool'),
(1219461, 'Alex', 'Drabek', '0000-00-00', 'Male', 'Luton', 'LU3 1AA', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219462, 'Alex', 'Drabek', '1990-04-15', 'Male', 'Luton', 'LU3 1AA', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219463, 'Alex', 'Drabek', '1991-07-09', 'Male', 'Luton', 'LU3 1AA', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219464, 'Karolina', 'Drabek', '1998-08-04', 'Male', 'Luton', 'LU3 1AA', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `Units`
--

CREATE TABLE IF NOT EXISTS `Units` (
  `UnitID` varchar(255) NOT NULL,
  `Unit_Name` varchar(40) NOT NULL,
  PRIMARY KEY (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Units`
--

INSERT INTO `Units` (`UnitID`, `Unit_Name`) VALUES
('1', 'Alex unit');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
