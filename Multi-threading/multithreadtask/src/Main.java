import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer>records = new ArrayList<>();
        for(int  i = 1;i<=1000;i++){
            records.add(i);
        }
        int numoProcessor = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numoProcessor);

        int chunksize = records.size()/numoProcessor;
        for(int  i = 0;i<numoProcessor;i++){
            int start = i*chunksize;
            int end  = (i==numoProcessor-1)? records.size()-1: start + chunksize;
           List<Integer> chunks = records.subList(start, end);
           executorService.submit(()-> processchunk(chunks));
        }

    }

    private static void processchunk(List<Integer> chunks) {
        System.out.println(Thread.currentThread().getName() + " printing thread name");
        try{
            for(Integer val: chunks){
                System.out.println(val);
            }

        }catch (Exception ex){
            Thread.currentThread().interrupt();
        }
    }
}