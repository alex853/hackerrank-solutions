package hr.algorithms.implementation.taumandbday;

public class TaumAndBday {

    static long taumBday(long b, long w, long x, long y, long z) {
        if (z >= Math.abs(x - y)) {
            return x * b + y * w;
        }

        if (y > x) {
            return x * b + (x + z) * w;
        } else {
            return (y + z) * b + y * w;
        }
    }

}
