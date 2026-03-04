public class AnotherThread extends Thread {
    @Override
    public void run() {
        System.out.println(ThreadColor.ANSI_YELLOW + "Hello from " +
                currentThread().getName()); //  STANDARD - non standard by adding "\u001bB[33m"

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println(ThreadColor.ANSI_CYAN + "Interrupted");
        }
        System.out.println(ThreadColor.ANSI_CYAN +
                "Waking up after sleep after 10 seconds and my name is"+
                currentThread().getName());
    }
}
