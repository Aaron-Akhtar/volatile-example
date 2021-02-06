public class Main {

    /*
    ESSENTIALLY: WITHOUT VOLATILE THREADS OTHER THAN MAIN WON'T BE ABLE
    TO FETCH THE MOST UPDATED VALUE FOR THIS VARIABLE AS IT IS FETCHING FROM
    CPU CATCH, THEREFORE, TO SURPASS THIS, WE USE VOLATILE AS IT WILL FORCE
    THE SYSTEM TO FETCH THE TARGET VARIABLE DIRECTLY FROM MAIN MEMORY.
     */


    private static /*volatile*/ boolean x = false;

    private static Thread thread(){
        final Runnable runnable = new Runnable(){
            @Override
            public void run() {

                /*
                waits until X = TRUE then finishes
                 */

                while(!x);
                System.out.println("DONE! " + Thread.currentThread().getName());
            }
        };
        return new Thread(runnable);
    }

    public static void main(String[] args) throws Exception{
        thread().start();
        thread().start();
        thread().start();
        Thread.sleep(1000);
        x = true;
        System.out.println("CHANGED! " + Thread.currentThread().getName());
    }

}
