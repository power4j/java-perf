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
@Fork(value = 1, jvmArgsAppend = { "-server", "-Xms2g", "-Xmx2g", "-XX:MetaspaceSize=256m" })
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
