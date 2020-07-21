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
import org.openjdk.jmh.infra.Blackhole;
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
@Threads(1)
@Fork(value = 1, jvmArgsAppend = { "-server", "-Xms32m", "-Xmx128m", "-Xmn64m", "-XX:CMSInitiatingOccupancyFraction=82",
		"-Xss256k", "-XX:LargePageSizeInBytes=64m" })
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 3)
@Measurement(iterations = 3, time = 10)
@OutputTimeUnit(TimeUnit.SECONDS)
public class LongIncBenchSt {
	private LongAdder longAdder = new LongAdder();
	private AtomicLong atomicLong = new AtomicLong();


	@Benchmark
	public void longAdderInc(Blackhole bh) {
		longAdder.increment();
		bh.consume(longAdder.longValue());
	}
	@Benchmark
	public void atomicInc(Blackhole bh) {
		bh.consume(atomicLong.incrementAndGet());
	}

	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder().include(LongIncBenchSt.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}
