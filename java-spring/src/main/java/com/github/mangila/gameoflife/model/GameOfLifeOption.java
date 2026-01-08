package com.github.mangila.gameoflife.model;

public record GameOfLifeOption(
        int rows,
        int columns,
        byte[] generation) {
}