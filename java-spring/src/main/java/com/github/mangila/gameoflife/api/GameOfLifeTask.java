package com.github.mangila.gameoflife.api;

import com.github.mangila.gameoflife.model.GameOfLifeOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public record GameOfLifeTask(GameOfLifeOption option) implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(GameOfLifeTask.class);
    private static final int MAX_GENERATIONS = 1000;

    @Override
    public void run() {
        int columns = option.columns();
        int rows = option.rows();
        // TODO: clone?
        byte[] currentGeneration = option.generation();
        byte[] nextGeneration = new byte[currentGeneration.length];
        int chunkSize = 512;
        byte[] chunk = new byte[chunkSize];
        for (int i = 0; i < MAX_GENERATIONS; i++) {
            GameOfLifeGenerator.generateNewGeneration(
                    rows,
                    columns,
                    currentGeneration,
                    nextGeneration);
//            var buffer = ByteBuffer.wrap(nextGeneration);
//            while (buffer.hasRemaining()) {
//                int remaining = buffer.remaining();
//                int currentSize = Math.min(remaining, chunkSize);
//                buffer.get(chunk);
//                int offset = buffer.position() - currentSize;
//                Arrays.fill(chunk, (byte) 0);
//            }
            log.info("Generation {} - {}", i, Arrays.toString(nextGeneration));
            System.arraycopy(nextGeneration, 0, currentGeneration, 0, currentGeneration.length);
            Arrays.fill(nextGeneration, (byte) 0);
        }
    }
}
