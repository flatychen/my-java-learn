package async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @author flaty
 * @date 2020-5-5
 */
public class CompleteFutureRunAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> result = CompletableFuture.runAsync(() -> {
            System.out.println("runAsync test");
        }, Executors.newFixedThreadPool(5));
//        System.out.println(result.get());
        System.out.println("result");
    }
}

