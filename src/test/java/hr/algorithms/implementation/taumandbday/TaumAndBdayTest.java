package hr.algorithms.implementation.taumandbday;

import org.junit.Test;

import static org.junit.Assert.*;

public class TaumAndBdayTest {
    @Test
    public void example0() {
        assertEquals(20L, TaumAndBday.taumBday(10, 10, 1, 1, 1));
    }

    @Test
    public void testCase5_1() {
        assertEquals(18192035842L, TaumAndBday.taumBday(27984, 1402, 619246, 615589, 247954));
    }
    /* Test Case #5
        10
        27984 1402
        619246 615589 247954
        95677 39394
        86983 311224 588538
        68406 12718
        532909 315341 201009
        15242 95521
        712721 628729 396706
        21988 67781
        645748 353796 333199
        22952 80129
        502975 175136 340236
        38577 3120
        541637 657823 735060
        5943 69851
        674453 392925 381074
        62990 61330
        310144 312251 93023
        11152 43844
        788543 223872 972572

        18192035842
        20582630747
        39331944938
        70920116291
        38179353700
        25577754744
        22947138309
        31454478354
        38686324390
        18609275504
     */
}