//32336186:ID
// Gashaw ambaw

/**
 * **Input(n>4 ^ evenNumber)**           // we use this "n" for all the program
 *
 * TASK 1:
 *
 *  In this algorithm, we get a natural number "n" greater than 4 and even,
 *  then look for two prime numbers that make up it, p1 and p2. They are
 *  dependent on each other. We find them using loops that run up to n.
 *
 *    Start
 *    Use n
 * For (p1=3;p1<n;p1+2){
 *    for(i<p1){
 *        if(p1 not prime){
 *          break
 *        }//if
 *        else continue
 *    }//for
 *    p2=n-p1
 *    boolean=true
 *    for(i<p2){
 *        if(p2 not prime){
 *            boolean=false
 *
 *        }//if
 *        else continue
 *    }//for
 *    if(boolean){
 *        output{ p1 p2}
 *        break
 *    }//if
 *    }//For
 *End
 *
 *
 *TASK 2:
 *
 * This algorithm uses (n) we search for the smallest prime numbers
 *  that are equal to p4-p3=n (n).
 *  We use a loop to find the prime number p3 , using it we find p4=p3+n
 *  Using another loop we verify that p4 is also a prime number and output.
 *
 * Start
 *
 * Use n
 * for(p3=3;p3<n;p3+2){
 *     for(i<p3){
 *     if(p3 not prime){
 *         break
 *     }//if
 *     else continue
 * }//for
 * p4=n+p3
 * boolean=true
 * for(i<p4){
 *     if(p4 not prime){
 *         boolean=false
 *     }//if
 *     else continue
 * }//for
 * if(boolean=true){
 *     output(n=p3+p4)
 *     break
 * }//if
 * }//for
 * END
 *
 *     TASK 3:
 *
 * In this algorithm we use (n) to find the number of prime numbers up to (n).
 * Here I use the Sieve of Eratosthenes algorithm to quickly filter out all non-prime numbers.
 * It is divided into three loops
 * 1. A loop that filters out all even numbers
 * 2. A second loop that filters out all non-prime numbers
 * 3. A third loop that counts all prime numbers.
 *
 *     START
 *     Use n
 *     boolean[] array= new boolean[n]
 *     for(i=3;i<n;i+2){
 *         array[i]=true
 *     }//for
 *
 *     for(i=3;i<n;i+2){
 *         if(array[i]=prime){
 *          for(k=i*i;k<n;k+=i){
 *          every product of prime numbers
 *          boolean[k]=false
 *          }//for
 *          }//if
 *          }//for
 *
 *          count=1
 *          for(i=3;i<n; i+2){        //run over all the odd numbers
 *          if(boolean[i]){           //if its true its prime num
 *          count++
 *              }//if
 *          }//for
 *           output(count)
 *
 *           End
 *
 *
 *           TASK 4:
 *
 *           In this algorithm we use (n) to find the multiples of the first numbers that make up (n).
 *           We use a loop that runs until n and inside it another loop that checks if (i) divides (n)
 *           Over and over in the loop, each time we find a divisor we print it until the end of the first loop.
 *
 *           Start
 *           Use n
 *
 *           original=n             //keep n unchanged
 *           i=2
 *           boolean=false
 *           output(original)         // all the print need to be in the same line
 *
 *           while(n>=i){
 *               while(n%i==0){       //he will keep running until he finishes to divine
 *                   n=(n/i)
 *                   if(boolean){
 *                       output(*)
 *                   }//if
 *                   output(i)
 *                   boolean=true
 *               }//while
 *               i++
 *               else continue to next i
 *           }//while
 *           END

*/



import java.util.Scanner;


public class Ex0 {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a even number and bigger then 4 :");
        int n = scanner.nextInt();

        //Time runner
        long StartTime = System.currentTimeMillis();

        if (n <= 4 || n % 2 != 0) {
            System.out.println("Error you choose the wrong number; ");
            System.out.println();
            return;
        }



                //TASK NUMBER 1:


                for (int p1 = 3; p1 < n; p1 += 2) {


                    for (int i = 3; i * i <= p1; i += 2) {
                        if (p1 % i == 0) {

                            break;        // here if its not prime num he will will back to for again

                        }
                    }

                    int p2 = n - p1;
                    boolean p2prime = true;

                    for (int i = 3; i * i <= p2; i += 2) {
                        if(p2 % i == 0) {

                            p2prime = false;

                        }

                    }

                    if (p2prime) {
                        System.out.println("a) " + n + " = " + p1 + " + " + p2);

                        break;   //skip to the next task after we finish
                    }

                }


                //TASK NUMBER 2:


                for (int p3 = 3; p3 < n; p3 += 2) {     // I skipped on number 2 because  p3>=3.

                    for (int i = 3; i * i <= p3; i += 2) {
                        if (p3 % i == 0) {

                            break;                   //skip if its not prime num.
                        }
                    }

                    int p4 = n + p3;                    //Now after I find p3 and n I can find p4.
                    boolean p4prime = true;

                    for (int i = 3; i * i <= p4; i += 2) {      //Make sure that p4 it's  prime number.
                        if (p4 % i == 0) {

                            p4prime = false;
                        }
                    }
                    if (p4prime) {                            //after i find p4  we print
                        System.out.println("b) " + n + " = " + p4 + " - " + p3);


                        break;

                    }

                }


                //TASK NUMBER 3:


                // I algorithm Sieve of Eratosthenes

                // use a array
                boolean[] is2prime = new boolean[n];

                // change every odd number from false to true
                 for (int i = 3; i < n; i += 2) {
                    is2prime[i] = true;
                }

                // chalking if num is prime number if not we throw it/
                for (int i = 3; i * i < n; i += 2) {
                    if (is2prime[i]) {
                        for (int k = i * i; k < n; k += i) {
                            is2prime[k] = false;

                        }
                    }
                }

                //Here we count all the first numbers with the algorithm we already counted 2 as a prime number
                int count2 = 1;
                for (int i = 3; i < n; i += 2) {
                    if (is2prime[i]) {

                        count2++;
                    }

                }

                System.out.println("c) There are " + count2 + " prime numbers between: [2, " + n + ").");


                //TASK NUMBER 4:

                int RealN = n;     //we save the original n/
                int i = 2;

                boolean multiplication = false;
                 System.out.print("d) The prime decomposition of: " + RealN + " = ");

                while (n >= i) {


                    while (n % i == 0) {
                        n = (n / i);


                        if (multiplication) {      // To prevent the first duplication in printing
                            System.out.print("*");

                        }
                        System.out.print(i);
                        multiplication = true;           //Here its restart
                    }
                    i++;

                }
                 System.out.println();


                //Task 5:

                 long   endTime  = System.currentTimeMillis();
                System.out.println("e) The run time in seconds: " + (endTime - StartTime) / 1000.0);

                //Task 6:

                System.out.println("f) My ID:323361386  ");
                System.out.println();

            }

        }



