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
		int counter = 0;							// 1 stap
		boolean found = false;						// 1 stap
		while (counter < getallen.length)			// n stappen
		{
			if (getallen[counter] == zoekWaarde)	// 1 stap
				found = true;						// 1 stap
			counter++;								// 1 stap
		}
		return found;								// 1 stap
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
		int low = 0;
		int high = getallen.length - 1;

		while (high >= low)
		{
			int mid = (high + low) / 2;
			if (zoekWaarde < getallen[mid])
			{
				high = mid - 1;
			}
			else if (zoekWaarde == getallen[mid])
			{
				return true;
			}
			else
			{
				low = mid + 1;
			}
		}
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
