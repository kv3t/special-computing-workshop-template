package ru.spbu.apcyb.svp.tasks.task4;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.spbu.apcyb.svp.tasks.task4.Multithread.calculateAndWriteTangentsSinglethreaded;
import static ru.spbu.apcyb.svp.tasks.task4.Multithread.calculateAndWriteTangentsMultithreaded;
import static ru.spbu.apcyb.svp.tasks.task4.Multithread.generateNumbersFile;

class MultithreadTest {
    @Test
    void oneNum() throws IOException{
        String sNum = "src/test/resources/input.txt";
        String sTan = "src/test/resources/output.txt";
        generateNumbersFile(sNum, 1);
        boolean sstream = calculateAndWriteTangentsSinglethreaded(sNum, sTan);
        boolean mstream = calculateAndWriteTangentsMultithreaded(sNum, sTan, 10);
        Assertions.assertTrue(sstream);
        Assertions.assertTrue(mstream);
    }
    @Test
    void oneHunNum() throws IOException{
        String sNum = "src/test/resources/input.txt";
        String sTan = "src/test/resources/output.txt";
        generateNumbersFile(sNum, 100);
        boolean sstream = calculateAndWriteTangentsSinglethreaded(sNum, sTan);
        boolean mstream = calculateAndWriteTangentsMultithreaded(sNum, sTan, 10);
        Assertions.assertTrue(sstream);
        Assertions.assertTrue(mstream);
    }
    @Test
    void oneMilNum() throws IOException{
        String sNum = "src/test/resources/input.txt";
        String sTan = "src/test/resources/output.txt";
        generateNumbersFile(sNum, 1000000);
        boolean sstream = calculateAndWriteTangentsSinglethreaded(sNum, sTan);
        boolean mstream = calculateAndWriteTangentsMultithreaded(sNum, sTan, 10);
        Assertions.assertTrue(sstream);
        Assertions.assertTrue(mstream);
    }

}