package async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author flaty
 * @date 2020-5-5
 */
public class CompleteFutureRunAsync {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        String json = Stream.of("a:1", "b:2", "c:3")
                .reduce("{", (a, b) -> a + b + ",") + "}";
        System.out.println(json);

        long count = Stream.of("a", "b", "a")
                .reduce(0L,
                        (acc, s) -> acc + 1, // 每个元素计数
                        Long::sum);
        System.out.println(count);


        CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> {
            return "f1";
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            return "f2";
        });
        CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> {
            return "f3";
        });
        var futureList = List.of(f1, f2, f3);
        List<String> result = new ArrayList<>();
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).thenApply(unused -> {
            return futureList.stream().reduce(CompletableFuture.completedFuture(""),(t1, t2) -> {
                return t1.thenCombine(t2, (s1, s2) -> {
                    return s1 + "," + s2;
                });
            });
        }).thenAccept(str->{
            System.out.println(str);
        });

//
//        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).thenApply(unused -> {
//            return futureList.stream().map(f -> f.join()).collect(Collectors.toList());
//        }).thenAccept(l -> {
//            for (String s : l) {
//                System.out.println("result:" + s);
//            }
//        });

    }
}

