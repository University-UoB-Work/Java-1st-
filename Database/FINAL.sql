-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2013 at 03:44 PM
-- Server version: 5.5.24-log
-- PHP Version: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `bank_details`
--

CREATE TABLE IF NOT EXISTS `bank_details` (
  `Bank_Account_Number` varchar(30) DEFAULT NULL,
  `Bank_Name` varchar(50) NOT NULL,
  `Account_Holders_Name` varchar(50) NOT NULL,
  KEY `Bank_Account_Number` (`Bank_Account_Number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bank_details`
--

INSERT INTO `bank_details` (`Bank_Account_Number`, `Bank_Name`, `Account_Holders_Name`) VALUES
('1', '12', 'sdfdsg');

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE IF NOT EXISTS `courses` (
  `CourseID` int(11) NOT NULL AUTO_INCREMENT,
  `Course_Name` varchar(50) NOT NULL,
  `Number of Units` int(11) NOT NULL,
  `Start_Date` datetime NOT NULL,
  `End_Date` datetime NOT NULL,
  `Type_of_Course` varchar(10) NOT NULL,
  `UnitID_1` varchar(10) DEFAULT NULL,
  `UnitID_2` varchar(10) DEFAULT NULL,
  `UnitID_3` varchar(10) DEFAULT NULL,
  `UnitID_4` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`CourseID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`CourseID`, `Course_Name`, `Number of Units`, `Start_Date`, `End_Date`, `Type_of_Course`, `UnitID_1`, `UnitID_2`, `UnitID_3`, `UnitID_4`) VALUES
(1, 'Computer Security and forensice', 4, '2012-10-20 00:00:00', '2015-12-20 00:00:00', 'FT', '1', NULL, NULL, NULL),
(2, 'Sport Therapy', 4, '2012-10-20 00:00:00', '2015-12-20 00:00:00', 'PT', 'CIS12121', 'CIS16', 'CIS89', 'CIS-012');

-- --------------------------------------------------------

--
-- Table structure for table `results_table`
--

CREATE TABLE IF NOT EXISTS `results_table` (
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `UnitID` varchar(255) NOT NULL,
  `Grade` varchar(5) NOT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `CourseID` (`CourseID`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `results_table`
--

INSERT INTO `results_table` (`StudentID`, `CourseID`, `UnitID`, `Grade`) VALUES
(1219460, 1, '1', 'A+');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(20) DEFAULT NULL,
  `First_Name` varchar(30) NOT NULL,
  `Surname` varchar(30) DEFAULT NULL,
  `Date_of_Birth` date NOT NULL,
  `Gender` varchar(8) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(10) DEFAULT NULL,
  `Telephone_Number` varchar(20) NOT NULL,
  `E_mail` varchar(50) DEFAULT NULL,
  `Bank_Account_Number` int(20) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `UnitID` varchar(10) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StaffID`),
  UNIQUE KEY `StaffID` (`StaffID`),
  KEY `Postcode` (`Postcode`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1234567891 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `Title`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `Telephone_Number`, `E_mail`, `Bank_Account_Number`, `Status`, `UnitID`, `Password`) VALUES
(1234567890, 'MR all', 'Alexander', 'ASAS', '1211-12-12', 'Female', 'LDASNSJSJDNJNdnjew', 'LU2-2BE', '+233232', 'defswfsfsfgs@o2.pl', 0, 'Admin', '1', 'haha'),
(101010, 'value2', 'Paul', 'sdds', '0000-00-00', 'male', 'edsfsd', 'sd', 'sdsfds', 'sdfdsaf', 2232, 'Staff', '2', 'password'),
(1219462, 'MR', 'Alex', 'Drabek', '1987-10-12', 'Male', 'Luton', 'LU4 1AE', '1', '91991919', 0, 'Staff', '0', '1');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `StudentID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(40) NOT NULL,
  `Surname` varchar(40) NOT NULL,
  `Date_of_Birth` date NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(7) DEFAULT NULL,
  `CourseID` int(11) NOT NULL,
  `Telephone_Number` varchar(20) DEFAULT NULL,
  `E_mail` varchar(50) NOT NULL,
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
-- Dumping data for table `students`
--

INSERT INTO `students` (`StudentID`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `CourseID`, `Telephone_Number`, `E_mail`, `Bank_Account_Number`, `Year_of_Study`, `Password`) VALUES
(1219460, 'Alexander', 'Drabek', '1990-05-09', 'Male', 'Luto nsdfnmdfndsf', 'LA3-3AA', 1, '+44 1234567', 'test@study.beds.ac.uk', 121212, 1, 'test1'),
(1219461, 'Alex', 'Drabek', '0000-00-00', 'Male', 'Luton', 'LU2 2BC', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219462, 'Alex', 'Drabek', '1991-02-12', 'Male', 'Luton', 'LU2 2BC', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219463, 'Alex', 'Drabek', '1996-05-06', 'Male', 'Luton', 'LU2 2BC', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test'),
(1219464, 'Karolina', 'Drabek', '1991-11-11', 'Male', 'Luton', 'LU2 2BC', 1, '91991919', 'asdas@o2.pl', 1234567, 1, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE IF NOT EXISTS `units` (
  `Unit_ID` varchar(11) NOT NULL DEFAULT '0',
  `UnitName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Unit_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`Unit_ID`, `UnitName`) VALUES
('CIS018-1', 'sdd'),
('CIS01919191', 'sdd'),
('CIS16-1', 'sport'),
('CIS20-1', 'security');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
