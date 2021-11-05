class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public int getCountsOfDigits(long number) {
        return String.valueOf(Math.abs(number)).length();
    }

    @Override
    public String toString() {
        String _hours = Integer.toString(hours);
        String _minutes = Integer.toString(minutes);
        String _seconds = Integer.toString(seconds);
        if (getCountsOfDigits(hours) == 1) {
            _hours = "0" + hours;
        }
        if (getCountsOfDigits(minutes) == 1) {
            _minutes = "0" + minutes;
        }
        if (getCountsOfDigits(seconds) == 1) {
            _seconds = "0" + seconds;
        }
        return _hours + ":" + _minutes + ":" + _seconds;
    }
}