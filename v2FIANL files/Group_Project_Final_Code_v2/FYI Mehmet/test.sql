-- phpMyAdmin SQL Dump
-- version 4.0.0
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 16, 2013 at 01:50 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `test`
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
('1', '12', 'sdfdsg'),
('11111111', 'Lyods TsI', 'Ches Starinski');

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
  `ID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `UnitID` varchar(255) NOT NULL,
  `Grade` varchar(5) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID` (`ID`),
  KEY `CourseID` (`CourseID`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Dumping data for table `results_table`
--

INSERT INTO `results_table` (`ID`, `StudentID`, `CourseID`, `UnitID`, `Grade`) VALUES
(0, 1219460, 1, '18', 'U'),
(1, 1219460, 1, '18', 'U'),
(2, 1219460, 1, '18', 'U'),
(3, 1219461, 2, '18', 'U');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE IF NOT EXISTS `staff` (
  `StaffID` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(25) DEFAULT NULL,
  `First_Name` varchar(40) NOT NULL,
  `Surname` varchar(40) DEFAULT NULL,
  `Date_of_Birth` varchar(25) DEFAULT NULL,
  `Gender` varchar(25) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(25) DEFAULT NULL,
  `Telephone_Number` varchar(25) NOT NULL,
  `E_mail` varchar(50) DEFAULT NULL,
  `Bank_Account_Number` varchar(25) NOT NULL,
  `Status` varchar(25) NOT NULL,
  `UnitID` varchar(25) DEFAULT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StaffID`),
  UNIQUE KEY `StaffID` (`StaffID`),
  KEY `Postcode` (`Postcode`),
  KEY `UnitID` (`UnitID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1234567895 ;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`StaffID`, `Title`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `Telephone_Number`, `E_mail`, `Bank_Account_Number`, `Status`, `UnitID`, `Password`) VALUES
(1225, 'MR ', 'hame', 'Mohamed', '0000-00-00', 'Male', 'Clouds', 'Somewhere', '?', '?', '112', 'Admin', '1', '12345'),
(101010, 'value2', 'Paul', 'sdds', '0000-00-00', 'male', 'edsfsd', 'sd', 'sdsfds', 'sdfdsaf', '2232', 'Staff', '2', 'password'),
(1219462, 'MR', 'Alex', 'Drabek', '1985-11-04', 'Male', 'Luton', 'LU3 1AE', '1', '91991919', '0', 'Staff', '0', '1'),
(1234567891, 'Mr', 'xx', 'xx c', '1985-12-12', 'Male', 'le2 3jr', '+12 121212', 'sdsd@o2.pl', '1212', 'Staff', 'CIS018-1', 'test', 'barcl.'),
(1234567894, 'Mr', 'Ches', 'Starinski', '1985-11-12', 'Male', 'Home', 'LU3 1AE', '078653449', 'spam@aol.com', '11111111', 'Staff', 'CIS01919191', 'lol');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `StudentID` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(40) NOT NULL,
  `Surname` varchar(40) NOT NULL,
  `Date_of_Birth` varchar(20) DEFAULT NULL,
  `Gender` varchar(20) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Postcode` varchar(25) DEFAULT NULL,
  `CourseID` int(11) NOT NULL,
  `Telephone_Number` varchar(25) DEFAULT NULL,
  `E_mail` varchar(50) NOT NULL,
  `Bank_Account_Number` varchar(25) NOT NULL,
  `Year_of_Study` varchar(25) NOT NULL,
  `Password` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`StudentID`),
  UNIQUE KEY `StudentID` (`StudentID`),
  KEY `CourseID` (`CourseID`),
  KEY `Postcode` (`Postcode`),
  KEY `Bank_Account_Number` (`Bank_Account_Number`),
  KEY `StudentID_2` (`StudentID`),
  KEY `StudentID_3` (`StudentID`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1219472 ;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`StudentID`, `First_Name`, `Surname`, `Date_of_Birth`, `Gender`, `Address`, `Postcode`, `CourseID`, `Telephone_Number`, `E_mail`, `Bank_Account_Number`, `Year_of_Study`, `Password`) VALUES
(1219460, 'Alexy', 'Smith', '1954-02-06', 'Female', 'Bedford', 'LU1-2HT', 114, '01205357534', 'spam@aol.com', '15151458', '2', '3'),
(1219461, 'Alex', 'Drabek', '0000-00-00', 'Male', 'Luton', 'LU1 2HT', 1, '91991919', 'asdas@o2.pl', '1234567', '1', 'test'),
(1219462, 'Alex', 'Pooper', '1992-10-15', 'Male', 'Luton', 'LU1 2HT', 1, '91991919', 'asdas@o2.pl', '1245454', '1', 'test'),
(1219463, 'Alex', 'Drabek', '1993-10-19', 'Male', 'Luton', 'LU1 2HT', 1, '91991919', 'asdas@o2.pl', '1234567', '1', 'test'),
(1219464, 'Karolina', 'Drabek', '1990-10-10', 'Male', 'Luton', 'LU1 2HG', 1, '91991919', 'asdas@o2.pl', '1234567', '1', 'a1b1c1d1e1f1'),
(1219465, 'sdaas', 'asdasd', '1992-11-15', 'Female', 'sdasdas', 'lu1 dsf', 1212, 'asdas@o12.pl', '121213', 'qwerty', '', 'sdfsdfs'),
(1219466, 'asdas', 'asdfa', '1992-11-15', 'Female', 'sdfsd', 'sefds', 1, '+21212', 'gfhgfhfg', '233232', 'Year 1', 'testowewe'),
(1219467, 'bababa', 'Bobobobob', '1992-12-12', 'Female', 'w3esdfd', 'asdfsa', 1, '+1212', 'esdfsdf@dsf', '1212', 'Year 2', 'wewew'),
(1219468, 'alowsx', 'drobciowe', '1992-12-12', 'Female', 'sdfasedf', 'lo 09 1', 2, '1212+', 'gwed@o2.', 'wes', '23245678', 'Masters'),
(1219469, 'Jasmine', 'Smith', '2008-02-09', 'Female', 'ggjn', 'PE287HS', 1, '06848932', 'lol@aol.com', '11111111', 'Year 1', 'Krystal'),
(1219470, 'Mandy', 'Grgdh', '1974-8-09', 'Female', 'hiton', 'PE287HS', 1, '07892466747', 'kik@aol.com', '1112223', 'Year 2', 'Missy'),
(1219471, 'Jim', 'Bob', '1852-3-12', 'Male', 'Home', 'LO189I', 2, '012647534', 'lolz@aol.co.uk', '15244152', 'Year 3', 'shoebop');

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
