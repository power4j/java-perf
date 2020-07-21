package com.power4j.kit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author CJ (jclazz@outlook.com)
 * @date 2019/8/14
 * @since 1.0
 */
@State(Scope.Benchmark)
@Fork(value = 1,
        jvmArgsAppend = {"-server", "-Xms4g", "-Xmx4g", "-Xmn1536m", "-XX:CMSInitiatingOccupancyFraction=82", "-Xss256k",
                "-XX:+DisableExplicitGC", "-XX:+UseConcMarkSweepGC", "-XX:+CMSParallelRemarkEnabled",
                "-XX:LargePageSizeInBytes=128m", "-XX:+UseFastAccessorMethods",
                "-XX:+UseCMSInitiatingOccupancyOnly", "-XX:+CMSClassUnloadingEnabled"})
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 3, time = 5)
@Threads(Threads.MAX)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class GetTimeOfDayBench {

    @Benchmark
    public void testCurrentTimeMillis(Blackhole bh) {
        bh.consume(System.currentTimeMillis());
    }

    @Benchmark
    public void testSystemClock(Blackhole bh) {
        bh.consume(SystemClock.now());
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(GetTimeOfDayBench.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
