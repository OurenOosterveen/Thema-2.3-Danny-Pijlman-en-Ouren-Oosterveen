/**
 * Created by ouren on 12-2-2016.
 */
public class AddArray
{
    public AddArray() {
    }

    public static void main(String[] args)
    {
        int[] firstNumbers = new int[3];
        int[] secondNumbers = new int[3];
        int[] addedNumbers = new int[3];
        firstNumbers[0] = 1;
        firstNumbers[1] = 2;
        firstNumbers[2] = 3;

        secondNumbers[0] = 4;
        secondNumbers[1] = 5;
        secondNumbers[2] = 6;

        try
        {
            int firstNumbersCounter = 0;
            int secondNumbersCounter = 0;
            for(int i = 0; i<firstNumbers.length; i++)
            {
                if (firstNumbers[i] != 0) {
                    firstNumbersCounter++;
                }
            }

            for(int i = 0; i<secondNumbers.length; i++)
            {
                if (secondNumbers[i] != 0) {
                    secondNumbersCounter++;
                }
            }

            if (firstNumbersCounter != secondNumbersCounter)
            {
                throw new ArrayLengthException();
            }

            for(int i = 0; i<firstNumbers.length; i++){
                addedNumbers[i] = firstNumbers[i] + secondNumbers[i];
                System.out.println(addedNumbers[i]);
            }
        }
        catch(ArrayLengthException e)
        {
            System.out.println("The arrays don't have the same length");
        }

    }
}
