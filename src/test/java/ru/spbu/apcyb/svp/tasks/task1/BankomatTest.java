package ru.spbu.apcyb.svp.tasks.task1;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import static ru.spbu.apcyb.svp.tasks.task1.Bankomat.inputLongList;

class BankomatTest {

    @Test
    void AmountIsNegative() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("-5", "2 1");}
        );
    }

    @Test
    void OneBanknoteIsNegative() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("5", "-2 1");}
        );
    }

    @Test
    void BothBanknotesAreNegative() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("5", "-2 -1");}
        );
    }

    @Test
    void SumIsZero() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("0", "-2 1");}
        );
    }

    @Test
    void BanknoteIsZero() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("5", "0");}
        );
    }

    @Test
    void SumWasNotWritten() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("", "-2 1");}
        );
    }

    @Test
    void BanknotesWereNotWritten() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("5", "");}
        );
    }

    @Test
    void SumIsNotANumber() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("abc", "1 5");}
        );
    }

    @Test
    void BanknotesAreNotNumbers() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("10", "a b c");}
        );
    }

    @Test
    void Sums() {
        assertThrows(NumberFormatException.class, () -> {Bankomat.coinChange("3+2", "1+1 2+1");}
        );
    }

    @Test
    void Sum5Banknotes3_2() {
        List<List<Long>> res = Bankomat.coinChange("5", "3 2");
        List<List<Long>> ans = new ArrayList<>();
        ans.add(Arrays.stream(Bankomat.inputLongList("3 2")).boxed().collect(Collectors.toList()));
        assertIterableEquals(res, ans);
    }

    @Test
    void OrderIndependence() {
        List<List<Long>> res1 = Bankomat.coinChange("5", "3 2");
        List<List<Long>> res2 = Bankomat.coinChange("5", "2 3");
        assertIterableEquals(res1, res2);
    }

    @Test
    void Thousand() {
        List<List<Long>> res =  Bankomat.coinChange("1000", "1");
        assertNotEquals(res.size(), 0);
    }

    @Test
    void ThousandAndBanknotes() {
        List<List<Long>> res =  Bankomat.coinChange("1000", "500 1");
        assertNotEquals(res.size(), 0);
    }

    @Test
    void ThreeBillion() {
        List<List<Long>> res = Bankomat.coinChange("3000000000", "3000000000");
        List<List<Long>> ans = new ArrayList<>();
        ans.add(Arrays.stream(inputLongList("3000000000")).boxed().collect(Collectors.toList()));
        assertIterableEquals(res, ans);
    }

    @Test
    void OneOfBanknotesIsBiggerThanAmount() {
        List<List<Long>> res = Bankomat.coinChange("5", "10 6");
        assertEquals(res.size(), 0);
    }

}