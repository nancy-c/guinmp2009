package dk.aau.imi.med4.guinmp2009.threads.lesson02;

/**
 * Adapted from http://java.sun.com/docs/books/tutorial/essential/concurrency/simple.html
 */
public class SimpleThreads {

    //Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        System.out.println(Thread.currentThread().getName()+": "+message);
    }

    private static class MessageLoop implements Runnable {
    	
        public void run() {
        
        	String importantInfo[] = {
                "Mary had a little lamb",
                "She ate it with mint sauce",
                "And everywhere that Mary went",
                "The lamb went too, of course",
                "The cormorant or common shag",
                "Lays eggs inside a paper bag",
                "The reason, you will know, no doubt",
                "Is to keep the lightning out",
                "But what these unobservant birds",
                "Have failed to notice is that herds",
                "Of wandering bears might come with buns",
                "And use the bags to hold their crumbs"
            };
            
        	try {
                for (int i = 0; i < importantInfo.length; i++) {
                    //Pause for 4 seconds
                    Thread.sleep(4000);
                    //Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("But I wasn't finished :(");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {


        //Delay, in milliseconds before we interrupt MessageLoop
        //thread (default one hour).
        long patience = 1000 * 20;

        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        //loop until MessageLoop thread exits
        while (t.isAlive()) {
        	//Wait 1 second for MessageLoop thread to exit
        	t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) &&
                    t.isAlive()) {
                threadMessage("Fed up of listening to this boring poem - going to kill the thread.");
                t.interrupt();
                //Now wait for interrupt to take effect and stop thread t
                t.join();
                //t should no longer be alive
            }

        }
        threadMessage("The Thread is dead!");
    }
}

