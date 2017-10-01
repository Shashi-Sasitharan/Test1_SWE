package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {
    String string;
    @Override
    public String getString() {
        return string;
    }

    @Override
    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int countNumbers()
    {
        if(string == null)
            throw new NullPointerException("String is empty");
        int digitCount = 0;
        for(int x = 0; x < string.length(); x++)
        {
            if(Character.isDigit(string.charAt(x)))     //Finds the first instance of a number in string
            {
                digitCount++;
                x++;                                    //initial increment
                while( x < string.length() && Character.isDigit(string.charAt(x)))    //Increase x until not a number
                {
                   x++;
                }
            }

        }

        return digitCount;
    }

    @Override
    public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd)
    {
        String nChar = "";
        if(n <= 0)
            throw new  IllegalArgumentException();
        if(n > 0 && string == null)
            throw new  NullPointerException();
        if(!startFromEnd)
        {
            for (int i = n-1; i < string.length(); i+=n)
            {
                nChar += string.charAt(i);
            }
        }
        else
        {
            for (int i = string.length() - n; i > 0 ; i-=n)
            {
                nChar = string.charAt(i) + nChar;           //Reversed
            }
        }
        return nChar;
    }

    @Override
    public void convertDigitsToNamesInSubstring(int startPosition, int endPosition)
    {
        
    }


    public static void main(String [] args)
    {
        MyCustomString mcs = new MyCustomString();      // To call the non static methods
        mcs.setString(args[0]);                     //Sets string from command line

        System.out.print(mcs.getEveryNthCharacterFromBeginningOrEnd(2,true));

    }

}
