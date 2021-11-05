class TimeConstantsDemo {

    public static void main(String[] args) {
        // print SECONDS_IN_DAY
        // print SECONDS_IN_WEEK
        System.out.println(TimeConstants.SECONDS_IN_A_DAY);
        System.out.println(TimeConstants.SECONDS_IN_A_WEEK);
    }
}

final class TimeConstants {
    public static final int SECOND = 1;
    public static final int SECONDS_IN_MINUTE = 60 * SECOND;
    public static final int SECONDS_IN_HOUR = 60 * SECONDS_IN_MINUTE;
    public static final int SECONDS_IN_A_DAY = SECONDS_IN_HOUR * 24;
    public static final int SECONDS_IN_A_WEEK = SECONDS_IN_A_DAY * 7;
    // write your code here

    private TimeConstants() { }
}