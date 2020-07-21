## 原子自增性能比较

性能测试用于比较`LongAdder`和`AtomicLong`在单线程和多线程环境下的性能表现。



### 测试结果

> 环境一
>
> CPU: [`AMD3700U`](https://www.amd.com/en/products/apu/amd-ryzen-7-3700u)
>
> OS: `windows 10`



```shell
Benchmark                     Mode  Cnt         Score           Error  Units
LongIncBenchMt.atomicInc     thrpt    3  64833369.910 ±   5162469.555  ops/s
LongIncBenchMt.longAdderInc  thrpt    3  35619400.007 ±  15531782.099  ops/s
LongIncBenchSt.atomicInc     thrpt    3  81252486.848 ± 217025980.825  ops/s
LongIncBenchSt.longAdderInc  thrpt    3  81521787.208 ± 213988225.650  ops/s
```



- 单线程
  - `AtomicLong`: 8100万
  - `LongAdder`:   8100万

- 多线程
  - `AtomicLong`: 640万
  - `LongAdder`:   350万



### 日志

```shell
# Detecting actual CPU count: 8 detected
# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.LongIncBenchMt.atomicInc

# Run progress: 0.00% complete, ETA 00:02:12
# Fork: 1 of 1
# Warmup Iteration   1: 63770712.459 ops/s
Iteration   1: 64519506.876 ops/s
Iteration   2: 65068983.463 ops/s
Iteration   3: 64911619.391 ops/s


Result "com.power4j.kit.LongIncBenchMt.atomicInc":
  64833369.910 ±(99.9%) 5162469.555 ops/s [Average]
  (min, avg, max) = (64519506.876, 64833369.910, 65068983.463), stdev = 282972.376
  CI (99.9%): [59670900.355, 69995839.465] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 8 threads, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.LongIncBenchMt.longAdderInc

# Run progress: 25.00% complete, ETA 00:01:41
# Fork: 1 of 1
# Warmup Iteration   1: 35149884.766 ops/s
Iteration   1: 34941420.712 ops/s
Iteration   2: 35341904.590 ops/s
Iteration   3: 36574874.719 ops/s


Result "com.power4j.kit.LongIncBenchMt.longAdderInc":
  35619400.007 ±(99.9%) 15531782.099 ops/s [Average]
  (min, avg, max) = (34941420.712, 35619400.007, 36574874.719), stdev = 851349.386
  CI (99.9%): [20087617.908, 51151182.106] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.LongIncBenchSt.atomicInc

# Run progress: 50.00% complete, ETA 00:01:07
# Fork: 1 of 1
# Warmup Iteration   1: 70011646.474 ops/s
Iteration   1: 67548371.487 ops/s
Iteration   2: 87291537.839 ops/s
Iteration   3: 88917551.219 ops/s


Result "com.power4j.kit.LongIncBenchSt.atomicInc":
  81252486.848 ±(99.9%) 217025980.825 ops/s [Average]
  (min, avg, max) = (67548371.487, 81252486.848, 88917551.219), stdev = 11895926.330
  CI (99.9%): [≈ 0, 298278467.673] (assumes normal distribution)


# JMH version: 1.23
# VM version: JDK 11.0.7, OpenJDK 64-Bit Server VM, 11.0.7+10-LTS
# VM invoker: C:\extra_bin\jdk-corretto-11.0.7\bin\java.exe
# VM options: -server -Xms32m -Xmx128m -Xmn64m -XX:CMSInitiatingOccupancyFraction=82 -Xss256k -XX:LargePageSizeInBytes=64m
# Warmup: 1 iterations, 3 s each
# Measurement: 3 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.power4j.kit.LongIncBenchSt.longAdderInc

# Run progress: 75.00% complete, ETA 00:00:33
# Fork: 1 of 1
# Warmup Iteration   1: 72606617.012 ops/s
Iteration   1: 67977899.096 ops/s
Iteration   2: 88254518.023 ops/s
Iteration   3: 88332944.505 ops/s


Result "com.power4j.kit.LongIncBenchSt.longAdderInc":
  81521787.208 ±(99.9%) 213988225.650 ops/s [Average]
  (min, avg, max) = (67977899.096, 81521787.208, 88332944.505), stdev = 11729416.719
  CI (99.9%): [≈ 0, 295510012.858] (assumes normal distribution)


# Run complete. Total time: 00:02:14

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                     Mode  Cnt         Score           Error  Units
LongIncBenchMt.atomicInc     thrpt    3  64833369.910 ±   5162469.555  ops/s
LongIncBenchMt.longAdderInc  thrpt    3  35619400.007 ±  15531782.099  ops/s
LongIncBenchSt.atomicInc     thrpt    3  81252486.848 ± 217025980.825  ops/s
LongIncBenchSt.longAdderInc  thrpt    3  81521787.208 ± 213988225.650  ops/s

```

