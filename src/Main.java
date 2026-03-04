public class Main {
    public static void main(String[] args) {

        System.out.println("\u001B[34m"+"Main Thread"); // NON STANDARD
        Thread AnotherThread = new AnotherThread();
        AnotherThread.setName("*AnotherThread*");
        AnotherThread.start(); // if you use run it will piggyback - start is independent
        new Thread(){ // anon because it doesnt have an object assigned but created new instance
            public void run(){
                System.out.println(ThreadColor.ANSI_RED+"Hello from anon Thread run");
            }
        }.start();

        Thread OurRunnableThread = new Thread(new OurRunnable(){
            @Override
            public void run() {
                super.run();
                System.out.println(ThreadColor.ANSI_GREEN +
                        "Hello from anon implementation of the runnable");
                try {
                    AnotherThread.join(5000);
                    System.out.println(ThreadColor.ANSI_GREEN+"Thread join timed out and I am running again and my name is" +
                            Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    System.out.println(ThreadColor.ANSI_RED + "Got Interrupted");
                }
            };
        });

        OurRunnableThread.start();
        //AnotherThread.interrupt();


        System.out.println(ThreadColor.ANSI_BLUE+"Hello again from Main Thread");
    }
    }
