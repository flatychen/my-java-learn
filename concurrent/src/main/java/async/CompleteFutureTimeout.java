package async;

import java.io.IOException;
import java.util.concurrent.*;

/**
 * @author flaty
 * @date 2020-5-5
 */
public class CompleteFutureTimeout {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "future finished!";
        });

        result.orTimeout(1, TimeUnit.SECONDS).whenComplete((s, throwable) -> {
            if (throwable instanceof TimeoutException) {
                System.out.println("TimeoutException");
            }else{
                System.out.println(s);
            }
        });
        System.in.read();

    }
}

