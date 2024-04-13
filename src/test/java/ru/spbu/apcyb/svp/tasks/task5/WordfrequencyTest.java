package ru.spbu.apcyb.svp.tasks.task5;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

class WordfrequencyTest {

    @Test
    void shortFileTest() throws IOException {
        String[] args = new String[]{"src/test/resources/short_text.txt",
                "src/test/resources/counts_short.txt"};
        Wordfrequency.main(args);
        assertEquals(-1, Files.mismatch(
                        Path.of( "src/test/resources/short_textans.txt"),
                        Path.of( "src/test/resources/counts_short.txt")
                )
        );
        assertTrue(Files.exists(Path.of("src/main/resources/words/")));
    }

    @Test
    void incorrectAmountOfArgumentsExceptionTest() {
        String[] args = new String[] {"arg1", "arg2", "arg3"};
        assertThrows(IllegalArgumentException.class, () -> Wordfrequency.main(args));
    }

    @Test
    void hugeFileTest() {
        String[] args = new String[]{"src/test/resources/long_text.txt",
                "src/test/resources/counts.txt"};
        Wordfrequency.main(args);
        assertTrue(Files.exists(Path.of("src/main/resources/words/")));
    }

}