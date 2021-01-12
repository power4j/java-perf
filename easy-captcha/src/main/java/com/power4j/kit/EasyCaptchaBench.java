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

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.ByteArrayOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * @author CJ (power4j@outlook.com)
 * @date 2020/1/12
 * @since 1.0
 */
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgsAppend = { "-server", "-Xms2g", "-Xmx2g", "-XX:MetaspaceSize=256m -Dnashorn.args=--no-deprecation-warning" })
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 1, time = 5)
@Measurement(iterations = 3, time = 10)
@OutputTimeUnit(TimeUnit.SECONDS)
public class EasyCaptchaBench {

    @Param({"130", "200"})
    private int width;

    @Param({"48", "60"})
    private int height;

	@Benchmark
    @Threads(1)
	public void specCaptchaSt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.specCaptcha(width,height).out(os);
        blackhole.consume(os);
	}

    @Benchmark
    @Threads(Threads.MAX)
    public void specCaptchaMt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.specCaptcha(width,height).out(os);
        blackhole.consume(os);
    }


    @Benchmark
    @Threads(1)
    public void gifCaptchaSt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.gifCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void gifCaptchaMt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.gifCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(1)
    public void chineseCaptchaSt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.chineseCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void chineseCaptchaMt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.chineseCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(1)
    public void chineseGifCaptchaSt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.chineseGifCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void chineseGifCaptchaMt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.chineseGifCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(1)
    public void arithmeticCaptchaSt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.arithmeticCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    @Benchmark
    @Threads(Threads.MAX)
    public void arithmeticCaptchaMt(Blackhole blackhole) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        CaptchaHelper.arithmeticCaptcha(width,height).out(os);
        blackhole.consume(os);
    }

    public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder().include(EasyCaptchaBench.class.getSimpleName()).build();
		new Runner(opt).run();
	}
}
