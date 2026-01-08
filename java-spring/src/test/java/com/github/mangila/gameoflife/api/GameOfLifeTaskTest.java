package com.github.mangila.gameoflife.api;

import com.github.mangila.gameoflife.model.GameOfLifeOption;
import org.junit.jupiter.api.Test;

class GameOfLifeTaskTest {

    @Test
    public void testRun() {
        var option = new GameOfLifeOption(4, 4, new byte[]{
                0, 0, 0, 0,
                0, 1, 1, 0,
                1, 0, 1, 0,
                0, 0, 0, 0
        });
        var task = new GameOfLifeTask(option);
        task.run();
    }
}