
public class SnelheidOefening {

	/**
	 * @param args
	 */
	public static void main( String[] args){
		GetalRij gr = new GetalRij( 100000, 200000);
		compareAlgorithms(gr);
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.currentTimeMillis();
	}

	private static void compareAlgorithms(GetalRij gr)
	{
		long startTijd = tijd();

		gr.zitErinA(30000);
		long zitErinATijd = tijd() - startTijd;

		boolean test = gr.zitErinB(30000);
		long zitErinBTijd = tijd() - zitErinATijd - startTijd;

		boolean test2 = gr.zitErinC(30000);
		long zitErinCTijd = tijd() - zitErinATijd - zitErinBTijd - startTijd;
		System.out.println(test + " " + test2);


		System.out.println(zitErinATijd + "|" + zitErinBTijd + "|" + zitErinCTijd);
	}

}
