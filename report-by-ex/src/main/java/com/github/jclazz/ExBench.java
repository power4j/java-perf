package com.github.jclazz;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author CJ (jclazz@outlook.com)
 * @date 2020/6/14
 * @since 1.0
 */
@State(Scope.Benchmark)
@Fork(value = 1,
        jvmArgsAppend = {"-server", "-Xms4g", "-Xmx4g", "-Xmn1536m", "-XX:CMSInitiatingOccupancyFraction=82",
                "-Xss256k","-XX:LargePageSizeInBytes=128m"})
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 3)
@Measurement(iterations = 3, time = 5)
@Threads(16)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ExBench {
    private final static int LOOPS = 1000;

    @Benchmark
    public void successNoThrown() {
        for (int i = 0; i < LOOPS; i++) {
            DemoService.successNoThrown();
        }
    }

    @Benchmark
    public void success() {
        for (int i = 0; i < LOOPS; i++) {
            DemoService.success();
        }
    }

    @Benchmark
    public void failByCatch() {
        for (int i = 0; i < LOOPS; i++) {
            DemoService.failByCatch();
        }
    }

    @Benchmark
    public void fail() {
        for (int i = 0; i < LOOPS; i++) {
            DemoService.fail();
        }
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ExBench.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
