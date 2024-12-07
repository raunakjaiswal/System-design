//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class SharedResorce{
   public int counter = 0;
   public final int max = 20;
}


class Print{

    public synchronized  void  printOdd(SharedResorce sharedResorce) throws InterruptedException {
        while (sharedResorce.counter<=sharedResorce.max){
            if(sharedResorce.counter%2==0){
                wait();
            }
            else{
                System.out.println("printing odd: "+ sharedResorce.counter);
                sharedResorce.counter++;
                notify();
            }
        }
    }
    public  synchronized  void printEven(SharedResorce sharedResorce) throws InterruptedException {
        while (sharedResorce.counter<=sharedResorce.max){

            if(sharedResorce.counter%2==1){
                wait();
            }
            else{
                System.out.println("printing even: "+ sharedResorce.counter);
                sharedResorce.counter++;
                notify();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
          SharedResorce sharedResorce = new SharedResorce();

          Print print = new Print();

          Thread thread1 = new Thread(()->{

              try {
                  print.printOdd(sharedResorce);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

          });

          Thread thread2 = new Thread(()->{

              try {
                  print.printEven(sharedResorce);
              } catch (InterruptedException e) {
                  throw new RuntimeException(e);
              }

          });

          thread2.start();
          thread1.start();
    }
}