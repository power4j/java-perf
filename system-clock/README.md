## 优化原理

在可以接受的精度范围内，尽量减少系统调用系统调用。因为系统调用访问的是内核资源（内核地址空间），需要做一次内核态<->用户态的切换。currentTimeMillis在linux下调用的是`gettimeofday`这是一个系统调用。



## 测试结果（windows）



```shell
# JMH 1.14.1 (released 1058 days ago, please consider updating!)
# VM version: JDK 1.8.0_191, VM 25.191-b12
# VM invoker: C:\app64\Java\jdk1.8.0_191\jre\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar=11012:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\bin -Dfile.encoding=UTF-8 -server -Xms4g -Xmx4g -Xmn1536m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:+CMSClassUnloadingEnabled
# Warmup: 3 iterations, 1 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 16 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: GettimeofdayBench.testCurrentTimeMillis

# Run progress: 0.00% complete, ETA 00:00:36
# Fork: 1 of 1
# Warmup Iteration   1: 1308.357 ops/ms
# Warmup Iteration   2: 1684.478 ops/ms
# Warmup Iteration   3: 1764.310 ops/ms
Iteration   1: 1626.686 ops/ms
Iteration   2: 1741.474 ops/ms
Iteration   3: 1697.363 ops/ms


Result "testCurrentTimeMillis":
  1688.508 ±(99.9%) 1056.391 ops/ms [Average]
  (min, avg, max) = (1626.686, 1688.508, 1741.474), stdev = 57.904
  CI (99.9%): [632.117, 2744.899] (assumes normal distribution)


# JMH 1.14.1 (released 1058 days ago, please consider updating!)
# VM version: JDK 1.8.0_191, VM 25.191-b12
# VM invoker: C:\app64\Java\jdk1.8.0_191\jre\bin\java.exe
# VM options: -javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\lib\idea_rt.jar=11012:C:\Program Files\JetBrains\IntelliJ IDEA 2019.1.3\bin -Dfile.encoding=UTF-8 -server -Xms4g -Xmx4g -Xmn1536m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:+CMSClassUnloadingEnabled
# Warmup: 3 iterations, 1 s each
# Measurement: 3 iterations, 5 s each
# Timeout: 10 min per iteration
# Threads: 16 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: GettimeofdayBench.testSystemClock

# Run progress: 50.00% complete, ETA 00:00:19
# Fork: 1 of 1
# Warmup Iteration   1: 99581.606 ops/ms
# Warmup Iteration   2: 106646.255 ops/ms
# Warmup Iteration   3: 105786.247 ops/ms
Iteration   1: 107219.420 ops/ms
Iteration   2: 102029.400 ops/ms
Iteration   3: 106492.293 ops/ms


Result "testSystemClock":
  105247.038 ±(99.9%) 51268.019 ops/ms [Average]
  (min, avg, max) = (102029.400, 105247.038, 107219.420), stdev = 2810.173
  CI (99.9%): [53979.019, 156515.056] (assumes normal distribution)


# Run complete. Total time: 00:00:39

Benchmark                                 Mode  Cnt       Score       Error   Units
GettimeofdayBench.testCurrentTimeMillis  thrpt    3    1688.508 ±  1056.391  ops/ms
GettimeofdayBench.testSystemClock        thrpt    3  105247.038 ± 51268.019  ops/ms
```

