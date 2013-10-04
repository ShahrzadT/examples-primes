public class PrintPrimes 
{
  int numberOfPrimes;
  int rowsPerPage;
  int columnsPerPage;
  int ORDMAX;
  int listOfPrimes[];
//hfsdjdfhjdfkhsd
  //WTF
  //i hope this works
  //so it works?
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
      int index;
      int multiples[] = new int[ORDMAX + 1];

      int currentNumber = 1;
      int currentPrimeIndex = 2;
      int firstOddSquare = 9;

      for(int primesFoundSoFar = 2; primesFoundSoFar <= numberOfPrimes; primesFoundSoFar++) 
      {
        do {
          currentNumber = currentNumber + 2;
          if (currentNumber == firstOddSquare) 
          {
            multiples[currentPrimeIndex] = currentNumber;
            currentPrimeIndex++;
            firstOddSquare = listOfPrimes[currentPrimeIndex] * listOfPrimes[currentPrimeIndex];
            
          }
          index = 2;
          isPrime = true;
          while (index < currentPrimeIndex && isPrime) 
          {
            while (multiples[index] < currentNumber)
              multiples[index] = multiples[index] + listOfPrimes[index] + listOfPrimes[index];
            if (multiples[index] == currentNumber)
              isPrime = false;
            index = index + 1;
          }
        } while (!isPrime);
        listOfPrimes[primesFoundSoFar] = currentNumber;
      }
    }

    public void printPrimes() 
    {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= numberOfPrimes) 
        {
          System.out.println("The First " + numberOfPrimes +
                               " Prime Numbers --- Page " + pageNumber);
          System.out.println("");
          for (int rowOffset = pageOffset; rowOffset < pageOffset + rowsPerPage; rowOffset++){
            for (int columnCounter = 0; columnCounter < columnsPerPage;columnCounter++)
              if (rowOffset + columnCounter * rowsPerPage <= numberOfPrimes)
                System.out.format("%10d", listOfPrimes[rowOffset + columnCounter * rowsPerPage]);
            System.out.println("");
          }
          System.out.println("\f");
          pageNumber = pageNumber + 1;
          pageOffset = pageOffset + rowsPerPage * columnsPerPage;
        }
    }
}

					 
