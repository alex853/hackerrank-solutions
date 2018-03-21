package hr.algorithms.implementation.thetimeinwords;

public class TheTimeInWords {

    static String timeInWords(int h, int m) {
        String oclockPattern = "H o' clock";
        String quarterPastPattern = "quarter past H";
        String halfPastPattern = "half past H";
        String quarterToPattern = "quarter to N";
        String minutesPastPattern = "M past H";
        String minutesToPattern = "R to N";

        String[] hours = new String[]{
                null,
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve"};

        String[] minutes = new String[] {
                null,
                "one minute",
                "two minutes",
                "three minutes",
                "four minutes",
                "five minutes",
                "six minutes",
                "seven minutes",
                "eight minutes",
                "nine minutes",
                "ten minutes",
                "eleven minutes",
                "twelve minutes",
                "thirteen minutes",
                "fourteen minutes",
                "fifteen minutes",
                "sixteen minutes",
                "seventeen minutes",
                "eighteen minutes",
                "nineteen minutes",
                "twenty minutes",
                "twenty one minutes",
                "twenty two minutes",
                "twenty three minutes",
                "twenty four minutes",
                "twenty five minutes",
                "twenty six minutes",
                "twenty seven minutes",
                "twenty eight minutes",
                "twenty nine minutes"};

        String pattern;
        String mMinutes = "";
        String mnMinutes = "";

        if (m == 0) {
            pattern = oclockPattern;
        } else if (m == 15) {
            pattern = quarterPastPattern;
        } else if (m == 30) {
            pattern = halfPastPattern;
        } else if (m == 45) {
            pattern = quarterToPattern;
        } else if (m < 30) {
            pattern = minutesPastPattern;
            mMinutes = minutes[m];
        } else {
            pattern = minutesToPattern;
            mnMinutes = minutes[60 - m];
        }

        String result = pattern.replaceAll("H", hours[h]);
        result = result.replaceAll("N", hours[h == 12 ? 1 : h+1]);
        result = result.replaceAll("M", mMinutes);
        result = result.replaceAll("R", mnMinutes);

        return result;
    }

}
