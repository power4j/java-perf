/*
 * Copyright 2020 ChenJun (power4j@outlook.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.power4j.kit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author CJ (power4j@outlook.com)
 * @date 2020/7/21
 * @since 1.0
 */
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgsAppend = { "-server", "-Xms32m", "-Xmx128m", "-Xmn64m", "-XX:CMSInitiatingOccupancyFraction=82",
		"-Xss256k", "-XX:LargePageSizeInBytes=64m" })
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 3)
@Measurement(iterations = 3, time = 5)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class IncBench {
	private LongAdder longAdder = new LongAdder();
	private AtomicLong atomicLong = new AtomicLong();


	@Benchmark
    @Threads(1)
	public void longAdderIncSt() {
		longAdder.increment();
	}

    @Benchmark
    @Threads(Threads.MAX)
    public void atomicIncMt() {
        atomicLong.incrementAndGet();
    }

	@Benchmark
    @Threads(1)
	public void atomicIncSt() {
        atomicLong.incrementAndGet();
	}

    @Benchmark
    @Threads(Threads.MAX)
    public void longAdderIncMt() {
        longAdder.increment();
    }

    @Benchmark
    @Threads(1)
    public void longAdderIncGetSt() {
        longAdder.increment();
        longAdder.longValue();
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void longAdderIncGetMt() {
        longAdder.increment();
        longAdder.longValue();
    }

	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder().include(IncBench.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}
