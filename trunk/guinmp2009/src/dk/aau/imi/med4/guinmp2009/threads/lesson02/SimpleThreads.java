package dk.aau.imi.med4.guinmp2009.threads.lesson02;

/**
 * Adapted from http://java.sun.com/docs/books/tutorial/essential/concurrency/simple.html
 */
public class SimpleThreads {

    //Delay, in milliseconds before we interrupt MessageLoop
    //thread (default one hour).
    private static long patience = 1000 * 20;

    //Display a message, preceded by the name of the current thread
    static void threadMessage(String message) {
        System.out.println(Thread.currentThread().getName()+": "+message);
    }

    private static class MessageLoop implements Runnable {
    	
    	private static int delay = 2000;
    	
        public void run() {
        
        	String importantInfo[] = {
        		"I will now tell you a poem",
                "Mary had a little lamb",
                "She ate it with mint sauce",
                "And everywhere that Mary went",
                "The lamb went too, of course",
                "I will now tell you another poem",
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
                    //Pause for delay seconds
                    Thread.sleep(delay);
                    //Print a message
                    threadMessage(importantInfo[i]);
                }
            } catch (InterruptedException e) {
                threadMessage("But I wasn't finished :(");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {



        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.setName("MessageLoop Thread");
        t.start();

        threadMessage("Waiting for MessageLoop thread to finish");
        //loop until MessageLoop thread exits
        while (t.isAlive()) {
        	//Wait at most 1 second for MessageLoop thread to exit
        	t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience) &&
                    t.isAlive()) {
                threadMessage("Fed up of listening to these stupid poems - going to kill MessageLoop thread.");
                t.interrupt();
                //Now wait for interrupt to take effect and stop thread t
                t.join();
                //t should no longer be alive
            }

        }
        threadMessage("The MessageLoop thread is dead!");
    }
}

