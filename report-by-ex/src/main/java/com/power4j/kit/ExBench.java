package com.power4j.kit;

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
@Threads(Threads.MAX)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ExBench {
    @Benchmark
    public void successNoThrown() {
        DemoService.successNoThrown();
    }

    @Benchmark
    public void success() {
        DemoService.success();
    }

    @Benchmark
    public void failByCatch() {
        DemoService.failByCatch();
    }

    @Benchmark
    public void fail() {
        DemoService.fail();
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                .include(ExBench.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }
}
