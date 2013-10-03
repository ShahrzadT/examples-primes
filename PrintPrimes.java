public class PrintPrimes 
{
  int numberOfPrimes;
  int rowsPerPage;
  int columnsPerPage;
  int ORDMAX;
  int listOfPrimes[];
//hfsdjdfhjdfkhsd
  public PrintPrimes(int numberOfPrimes, int rows, int columns, int ORDMAX) 
  {
    this.numberOfPrimes   = numberOfPrimes;
    this.rowsPerPage  = rows;
    this.columnsPerPage  = columns;
    this.ORDMAX = ORDMAX;
    this.listOfPrimes = new int[numberOfPrimes + 1];
  }


  public static void main(String[] args) 
  {
      PrintPrimes printPrimes = new PrintPrimes(300, 50, 4, 30);
      printPrimes.calculatePrimes();
      printPrimes.printPrimes();
  }

  public void calculatePrimes() 
  {
      /* Two is the only even prime. All other prime numbers are odd.
       * To simplify the code, we simply add 2 as a prime number, and
       * delegate the task of finding all odd prime numbers to a helper
       * function.
       */
      listOfPrimes[1] = 2;
      calculateOddPrimes();
  }

  private void calculateOddPrimes() 
  {
      boolean isPrime;
      int N;
      int multiples[] = new int[ORDMAX + 1];

      int currentNumber = 1;
      int ORD = 2;
      int SQUARE = 9;
//primesFoundSoFar=1
      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) 
      {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == SQUARE) 
          {
            multiples[ORD] = currentNumber;
            ORD++;
            SQUARE = listOfPrimes[ORD] * listOfPrimes[ORD];
            
          }
          N = 2;
          isPrime = true;
          while (N < ORD && isPrime) 
          {
            while (multiples[N] < currentNumber)
              multiples[N] = multiples[N] + listOfPrimes[N] + listOfPrimes[N];
            if (multiples[N] == currentNumber)
              isPrime = false;
            N = N + 1;
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = currentNumber;
      }
    }

    public void printPrimes() 
    {
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= numberOfPrimes) 
        {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + PAGENUMBER);
          System.out.println("");
          for (int ROWOFFSET = PAGEOFFSET; ROWOFFSET < PAGEOFFSET + rowsPerPage; ROWOFFSET++){
            for (int columnCounter = 0; columnCounter < columnsPerPage;columnCounter++)
              if (ROWOFFSET + columnCounter * rowsPerPage <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[ROWOFFSET + columnCounter * rowsPerPage]);
            System.out.println("");
          }
          System.out.println("\f");
          PAGENUMBER = PAGENUMBER + 1;
          PAGEOFFSET = PAGEOFFSET + rowsPerPage * columnsPerPage;
        }
    }
}

					 
