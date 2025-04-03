public class Time1 {
    private int hour;
    private int minutes;
    private int seconds;

    public void setTime(int hour, int minutes, int seconds){
        if(hour < 0 || hour > 24 || minutes < 0 || minutes > 60 || seconds < 0 || seconds > 60){
            throw new IllegalArgumentException("hour, minutes, or seconds was out of range");
        }
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public String convertUniversal(){
        return String.format("%02d:%02d:%02d", hour, minutes,seconds);
    }
}
