public class OurRunnable implements Runnable{ // need thread for runnable
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_PURPLE+"Hola desde runnable thread");
    }
}
