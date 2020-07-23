## 原子自增性能比较

性能测试用于比较`LongAdder`和`AtomicLong`在单线程和多线程环境下的性能表现。



### 测试结果

> 环境一
>
> CPU: [`AMD3700U`](https://www.amd.com/en/products/apu/amd-ryzen-7-3700u)
>
> OS: `windows 10`
> JDK: `corretto-11`


```shell
Benchmark                    Mode  Cnt       Score        Error   Units
IncBench.atomicIncMt        thrpt    3   68756.406 ±   9302.626  ops/ms
IncBench.atomicIncSt        thrpt    3   95428.635 ± 285657.563  ops/ms
IncBench.longAdderIncGetMt  thrpt    3   54696.233 ±  20468.987  ops/ms
IncBench.longAdderIncGetSt  thrpt    3   91624.215 ± 214473.016  ops/ms
IncBench.longAdderIncMt     thrpt    3  939921.453 ± 106789.970  ops/ms
IncBench.longAdderIncSt     thrpt    3  108198.606 ± 235151.796  ops/ms
```

`LongAdder`在多核环境下,进行自增操作几乎没有因为线程竞争而损失性能，但是`LongAdder`的自增和取值是两个独立方法，没有线程安全保障。
`AtomicLong`在多核环境下,线程竞争激烈导致明显性能损失，但是`AtomicLong`的自增和取值是原子操作。


### 日志

```shell
# Detecting actual CPU count: 8 detected
# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.atomicIncMt

# Run progress: 0.00% complete, ETA 00:01:48
# Fork: 1 of 1
# Warmup Iteration   1: 69292.159 ops/ms
Iteration   1: 69344.483 ops/ms
Iteration   2: 68487.484 ops/ms
Iteration   3: 68437.251 ops/ms


Result "com.power4j.kit.IncBench.atomicIncMt":
  68756.406 ±(99.9%) 9302.626 ops/ms [Average]
  (min, avg, max) = (68437.251, 68756.406, 69344.483), stdev = 509.908
  CI (99.9%): [59453.780, 78059.032] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.atomicIncSt

# Run progress: 16.67% complete, ETA 00:01:37
# Fork: 1 of 1
# Warmup Iteration   1: 91307.851 ops/ms
Iteration   1: 82707.581 ops/ms
Iteration   2: 90662.639 ops/ms
Iteration   3: 112915.685 ops/ms


Result "com.power4j.kit.IncBench.atomicIncSt":
  95428.635 ±(99.9%) 285657.563 ops/ms [Average]
  (min, avg, max) = (82707.581, 95428.635, 112915.685), stdev = 15657.855
  CI (99.9%): [≈ 0, 381086.198] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.longAdderIncGetMt

# Run progress: 33.33% complete, ETA 00:01:18
# Fork: 1 of 1
# Warmup Iteration   1: 51901.004 ops/ms
Iteration   1: 53732.336 ops/ms
Iteration   2: 55927.850 ops/ms
Iteration   3: 54428.513 ops/ms


Result "com.power4j.kit.IncBench.longAdderIncGetMt":
  54696.233 ±(99.9%) 20468.987 ops/ms [Average]
  (min, avg, max) = (53732.336, 54696.233, 55927.850), stdev = 1121.974
  CI (99.9%): [34227.246, 75165.221] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.longAdderIncGetSt

# Run progress: 50.00% complete, ETA 00:00:58
# Fork: 1 of 1
# Warmup Iteration   1: 88113.000 ops/ms
Iteration   1: 103243.347 ops/ms
Iteration   2: 79735.987 ops/ms
Iteration   3: 91893.311 ops/ms


Result "com.power4j.kit.IncBench.longAdderIncGetSt":
  91624.215 ±(99.9%) 214473.016 ops/ms [Average]
  (min, avg, max) = (79735.987, 91624.215, 103243.347), stdev = 11755.990
  CI (99.9%): [≈ 0, 306097.232] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.longAdderIncMt

# Run progress: 66.67% complete, ETA 00:00:38
# Fork: 1 of 1
# Warmup Iteration   1: 860324.238 ops/ms
Iteration   1: 934621.373 ops/ms
Iteration   2: 938938.926 ops/ms
Iteration   3: 946204.060 ops/ms


Result "com.power4j.kit.IncBench.longAdderIncMt":
  939921.453 ±(99.9%) 106789.970 ops/ms [Average]
  (min, avg, max) = (934621.373, 939921.453, 946204.060), stdev = 5853.519
  CI (99.9%): [833131.483, 1046711.424] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\lib\idea_rt.jar=51221:C:\Program Files\JetBrains\IntelliJ IDEA 2019.2.4\bin -Dfile.encoding=UTF-8 -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.IncBench.longAdderIncSt

# Run progress: 83.33% complete, ETA 00:00:19
# Fork: 1 of 1
# Warmup Iteration   1: 95764.899 ops/ms
Iteration   1: 117078.535 ops/ms
Iteration   2: 93414.638 ops/ms
Iteration   3: 114102.646 ops/ms


Result "com.power4j.kit.IncBench.longAdderIncSt":
  108198.606 ±(99.9%) 235151.796 ops/ms [Average]
  (min, avg, max) = (93414.638, 108198.606, 117078.535), stdev = 12889.463
  CI (99.9%): [≈ 0, 343350.402] (assumes normal distribution)


# Run complete. Total time: 00:01:56

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                    Mode  Cnt       Score        Error   Units
IncBench.atomicIncMt        thrpt    3   68756.406 ±   9302.626  ops/ms
IncBench.atomicIncSt        thrpt    3   95428.635 ± 285657.563  ops/ms
IncBench.longAdderIncGetMt  thrpt    3   54696.233 ±  20468.987  ops/ms
IncBench.longAdderIncGetSt  thrpt    3   91624.215 ± 214473.016  ops/ms
IncBench.longAdderIncMt     thrpt    3  939921.453 ± 106789.970  ops/ms
IncBench.longAdderIncSt     thrpt    3  108198.606 ± 235151.796  ops/ms

Process finished with exit code 0


```

