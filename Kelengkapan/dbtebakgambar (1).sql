-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Jan 2024 pada 09.44
-- Versi server: 10.4.24-MariaDB
-- Versi PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";
CREATE DATABASE `dbtebakgambar`;
USE `dbtebakgambar`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbtebakgambar`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_gambar`
--

CREATE TABLE `tb_gambar` (
  `id_gambar` int(11) NOT NULL,
  `gambar` varchar(255) NOT NULL,
  `jawaban_gambar` varchar(50) NOT NULL,
  `level_gambar` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_gambar`
--

INSERT INTO `tb_gambar` (`id_gambar`, `gambar`, `jawaban_gambar`, `level_gambar`) VALUES
(15, '15.png', 'mari makan', 'Easy'),
(16, '16.png', 'jambu batu', 'Easy'),
(17, '17.png', 'pisau tajam', 'Normal'),
(18, '18.png', 'tantangan seru', 'Hard'),
(19, '19.png', 'kambing guling', 'Easy'),
(20, '20.png', 'alas kaki', 'Normal'),
(21, '21.png', 'potongan harga', 'Hard'),
(22, '22.png', 'tuang air', 'Normal'),
(23, '23.png', 'tenaga listrik', 'Normal');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_user`
--

CREATE TABLE `tb_user` (
  `id_user` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nickname` varchar(50) NOT NULL,
  `score` int(11) NOT NULL,
  `role` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_user`
--

INSERT INTO `tb_user` (`id_user`, `user`, `password`, `nickname`, `score`, `role`) VALUES
(1, '123', '123', '', 0, 'admin'),
(13, 'surya', 'surya', 'surya', 21, 'user'),
(14, 'levri', 'levri', 'swiper', 100, 'user'),
(15, 'agus', 'agus', 'agus', 2, 'user'),
(16, 'wibawa', 'wibawa', 'wibawa', 7, 'user'),
(17, 'johan', 'johan', 'johan', 6, 'user'),
(28, '1', '1', '1', 0, 'user'),
(29, 'adik', 'adik', 'adik', 6, 'user'),
(30, 'dede', 'dede', 'dede', 5, 'user'),
(31, 'punya', 'punya', 'punya', 0, 'user'),
(32, 'testing', 'testing', 'testing', 4, 'user');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_gambar`
--
ALTER TABLE `tb_gambar`
  ADD PRIMARY KEY (`id_gambar`);

--
-- Indeks untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tb_gambar`
--
ALTER TABLE `tb_gambar`
  MODIFY `id_gambar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT untuk tabel `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
