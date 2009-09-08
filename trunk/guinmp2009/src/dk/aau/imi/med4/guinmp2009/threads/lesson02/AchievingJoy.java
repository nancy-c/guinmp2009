package dk.aau.imi.med4.guinmp2009.threads.lesson02;

public class AchievingJoy {
	public static Joy JOY = new Joy();
	public static Joy MORE_JOY = new Joy();

	public static void main(String[] args) {
		try {

			/*
			 * Create a new Thread and an anonymous Runnable object which calls
			 * the guardedJoy method on the static, shared JOY object.
			 */
			new Thread(new Runnable() {
				public void run() {
					JOY.guardedJoy();
				}
			}, "Thread JOY 1").start();

			// Thread JOY 1 will now wait until JOY.notifyAll() is called after
			// JOY
			// has been set to TRUE. This happens when JOY.goodNews() is called.

			new Thread(new Runnable() {
				public void run() {
					JOY.guardedJoy();
				}
			}, "Thread JOY 2").start();

			/*
			 * Thread JOY 2 is now suspended, waiting for JOY.notifyAll() to be
			 * called. When notifyAll has been called, Thread JOY 2 will regain
			 * the lock on JOY and check if the local joy variable within JOY
			 * has been set to TRUE.
			 */

			new Thread(new Runnable() {
				public void run() {
					MORE_JOY.guardedJoy();
				}
			}, "Thread MORE_JOY").start();

			Thread.sleep(3000);

			new Thread(new Runnable() {
				public void run() {
					JOY.badNews();
				}
			}, "Thread JOY badNews").start();

			Thread.sleep(3000);

			new Thread(new Runnable() {
				public void run() {
					JOY.goodNews();
				}
			}, "Thread JOY goodNews").start();

			Thread.sleep(3000);

			new Thread(new Runnable() {
				public void run() {
					MORE_JOY.badNews();
				}
			}, "Thread MORE_JOY badNews").start();

			Thread.sleep(3000);

			new Thread(new Runnable() {
				public void run() {
					MORE_JOY.goodNews();
				}
			}, "Thread MORE_JOY goodNews").start();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
