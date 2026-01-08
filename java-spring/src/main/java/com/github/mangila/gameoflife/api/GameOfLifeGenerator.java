package com.github.mangila.gameoflife.api;

public final class GameOfLifeGenerator {

    public static void generateNewGeneration(
            int rows,
            int columns,
            byte[] currentGeneration,
            byte[] nextGeneration) {
        byte alive = 1;
        for (int i = 0; i < currentGeneration.length; i++) {
            int neighbours = neighbours(i, rows, currentGeneration);
            int cell = currentGeneration[i];
            if (cell == alive) {
                if (neighbours == 2 || neighbours == 3) {
                    nextGeneration[i] = alive;
                }
            } else {
                if (neighbours == 3) {
                    nextGeneration[i] = alive;
                }
            }
        }
    }

    // TODO: grid boundary from the flat array checks
    private static int neighbours(int index,
                                  int rows,
                                  byte[] currentGeneration) {
        int neighbours = 0;
        int up = index - rows;
        neighbours += getIndex(currentGeneration, up);
        int upLeft = index - rows - 1;
        neighbours += getIndex(currentGeneration, upLeft);
        int upRight = index - rows + 1;
        neighbours += getIndex(currentGeneration, upRight);
        int down = index + rows;
        neighbours += getIndex(currentGeneration, down);
        int downLeft = index + rows - 1;
        neighbours += getIndex(currentGeneration, downLeft);
        int downRight = index + rows + 1;
        neighbours += getIndex(currentGeneration, downRight);
        int left = index - 1;
        neighbours += getIndex(currentGeneration, left);
        int right = index + 1;
        neighbours += getIndex(currentGeneration, right);

        return neighbours;
    }


    public static int getIndex(byte[] currentGeneration, int index) {
        if (index >= 0 && index < currentGeneration.length) {
            return currentGeneration[index];
        }
        return 0;
    }

}
