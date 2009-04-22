package dk.aau.imi.med4.guinmp2009.threads.lesson02;

public class Joy {

	public static boolean joy = false;

	public synchronized void guardedJoy() {
		while (!joy) {
			try {
				/*
				 * wait() is inherited from Object, so every object has a wait()
				 * method.
				 * 
				 * wait() suspends the current thread and releases the lock on
				 * this object.
				 * 
				 * wait() reacquires the lock on this object and returns when
				 * the notifyAll method is called on this object. This causes
				 * the while condition to be checked.
				 * 
				 * Note that there is no busy waiting.
				 * 
				 * wait() should always occur within a while loop that tests for
				 * the condition being waited for.
				 * 
				 * Suppose d is the object on which we invoke wait() (i.e.,
				 * d.wait()). The Thread in which d.wait() is called must own
				 * the lock on d otherwise an error is thrown. If wait() is
				 * called from within a synchronized method, then the current
				 * thread has a lock on this object.
				 */
				wait();
			} catch (InterruptedException e) {
				System.out.println(threadName()
						+ "guardedJoy() method was interrupted.");
				e.printStackTrace();
			}
			if (!joy)
				System.out.println(threadName() + "Sorry - still no joy :(");
		}
		System.out.println(threadName() + "Joy has been achieved :)");
	}

	public synchronized void goodNews() {
		joy = true;
		/*
		 * notifyAll() sends a message to all threads waiting on the lock for
		 * this object, telling them to return from wait().
		 */
		notifyAll();
		System.out.println(threadName() + "goodNews just received");
	}

	public synchronized void badNews() {
		joy = false;
		notifyAll();
		System.out.println(threadName() + "badNews just received");
	}

	public static String threadName() {
		return Thread.currentThread().getName() + ": ";
	}
}
