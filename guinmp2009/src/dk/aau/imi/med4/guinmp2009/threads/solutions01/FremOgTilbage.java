package dk.aau.imi.med4.guinmp2009.threads.solutions01;

public class FremOgTilbage {
	static public int[] ARRAY = {0,0,0,0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		Frem fr = new Frem();
		Tilbage ti = new Tilbage();
		Thread frem = new Thread(fr);
		Thread tilbage = new Thread(ti);
		frem.start();
		tilbage.start();
		try {
			frem.join();
			tilbage.join();
			for (int i = 0; i < 10; i++)
				System.out.print(ARRAY[i]+" ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
