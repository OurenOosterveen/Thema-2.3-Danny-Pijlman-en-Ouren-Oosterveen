
public class SnelheidOefening {

	/**
	 * @param args
	 */
	public static void main( String[] args){
		GetalRij gr = new GetalRij( 200000, 400000);
		compareAlgorithms(gr);
	}

	// Hulpmethode voor tijdsbepaling
	private static long tijd(){
		return System.nanoTime();
	}

	private static void compareAlgorithms(GetalRij gr)
	{
		long startTijd = tijd();

		boolean test = gr.zitErinA(30000);
		long zitErinATijd = tijd() - startTijd;

		boolean test2 = gr.zitErinB(30000);
		long zitErinBTijd = tijd() - zitErinATijd - startTijd;

		boolean test3 = gr.zitErinC(30000);
		long zitErinCTijd = tijd() - zitErinATijd - zitErinBTijd - startTijd;

		boolean test4 = gr.zitErinD(30000);
		long zitErInDTijd = tijd() - zitErinATijd - zitErinBTijd - zitErinCTijd - startTijd;


		System.out.println(test + "|" + test2 + "|" + test3 + "|" + test4);
		System.out.println(zitErinATijd + "|" + zitErinBTijd + "|" + zitErinCTijd + "|" + zitErInDTijd);
	}

}
