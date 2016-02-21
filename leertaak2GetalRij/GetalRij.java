import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class GetalRij {
	private int[] getallen;
	
	public GetalRij( int aantal, int max ){
		// Belangrijke aanname: aantal < max, anders kunnen de getallen niet uniek zijn.
		getallen = new int[aantal];
		vulArrayMetUniekeWaarden( aantal, max );
        sorteer();
	}

	private void vulArrayMetUniekeWaarden(int aantal, int max) {
		// Vul een hulplijst met getallen 0, ..., max
		ArrayList hulpLijst = new ArrayList( max );
		for ( int i=0; i<max; i++){
			hulpLijst.add( i );
		}
		
		// Stop 'aantal' random waarden in getallen
		Random r = new Random();
		for ( int i=0; i<aantal; i++){
			// Het omzetten van Integer naar int gaat sinds Java 1.5 automatisch (unboxing).
			int getal = (Integer) (hulpLijst.remove( r.nextInt( hulpLijst.size())));
			getallen[i] = getal;
		}
	}
	
	public boolean zitErinA( int zoekWaarde )
    {
		int counter = 0;
        boolean found = false;
        while (counter < getallen.length)
        {
            if (getallen[counter] == zoekWaarde)
                found = true;
            counter++;
        }
		return found;
	}

	public boolean zitErinB( int zoekWaarde )
    {
        int counter = 0;
        while (counter < getallen.length)
        {
            if (getallen[counter] == zoekWaarde)
                return true;
            counter++;
        }
        return false;
	}

	public boolean zitErinC( int zoekWaarde ){
        int counter = 0;
        while (counter < getallen.length)
        {
            if (getallen[counter] == zoekWaarde) {
                return true;
            }
            else if (getallen[counter] > zoekWaarde) {
                break;
            }
            counter++;
        }
        System.out.println("FUCK YOU" + counter);
        return false;
	}

	public boolean zitErinD( int zoekWaarde ){
		return false;
	}
	
	public void sorteer(){
		Arrays.sort( getallen);
	}
	
	public void print(){
		for( int i=0; i<getallen.length; i++)
			System.out.println(getallen[i]);
	}

}
