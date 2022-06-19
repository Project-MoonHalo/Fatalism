package MoonHalo.FlameApi.Event;

public class Event {
    private static boolean isCanceled =false;
    public Event(){
        isCanceled = false;
    }
    public static void Cancel(){
        isCanceled = true;
    }
}
