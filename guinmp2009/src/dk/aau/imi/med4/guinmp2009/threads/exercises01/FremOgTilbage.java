package dk.aau.imi.med4.guinmp2009.threads.exercises01;

public class FremOgTilbage {
	static public int[] ARRAY = {0,0,0,0,0,0,0,0,0,0};
	
	public static void main(String[] args) {
		Frem fr = new Frem();
		Tilbage ti = new Tilbage();
		Thread frem = new Thread(XXXXXX);
		Thread tilbage = new Thread(XXXXXX);
		frem.XXXXXX();
		tilbage.XXXXXX();
		try {
			frem.XXXXXX();
			tilbage.XXXXXX();
			for (int i = 0; i < 10; i++)
				System.out.print(ARRAY[i]+" ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
