## EasyCaptcha验证码性能测试

EasyCaptcha: https://github.com/whvcse/EasyCaptcha


### 测试结果

> 环境一
>
> CPU: [`i7-8550U`](https://ark.intel.com/content/www/cn/zh/ark/products/122589/intel-core-i7-8550u-processor-8m-cache-up-to-4-00-ghz.html)
>
> OS: `Manjaro 20`
> JDK: `openjdk version "11.0.8"`


```shell
Benchmark                             (height)  (width)   Mode  Cnt     Score      Error  Units
EasyCaptchaBench.arithmeticCaptchaMt        48      130  thrpt    3  1015.148 ± 3924.382  ops/s
EasyCaptchaBench.arithmeticCaptchaMt        48      200  thrpt    3   868.053 ± 4922.976  ops/s
EasyCaptchaBench.arithmeticCaptchaMt        60      130  thrpt    3   816.660 ± 5303.511  ops/s
EasyCaptchaBench.arithmeticCaptchaMt        60      200  thrpt    3   793.647 ± 4842.127  ops/s
EasyCaptchaBench.arithmeticCaptchaSt        48      130  thrpt    3   294.627 ±  268.235  ops/s
EasyCaptchaBench.arithmeticCaptchaSt        48      200  thrpt    3   280.429 ±  107.524  ops/s
EasyCaptchaBench.arithmeticCaptchaSt        60      130  thrpt    3   281.364 ±  156.551  ops/s
EasyCaptchaBench.arithmeticCaptchaSt        60      200  thrpt    3   271.798 ±  154.871  ops/s
EasyCaptchaBench.chineseCaptchaMt           48      130  thrpt    3  6360.214 ±  256.687  ops/s
EasyCaptchaBench.chineseCaptchaMt           48      200  thrpt    3  5236.657 ±  535.171  ops/s
EasyCaptchaBench.chineseCaptchaMt           60      130  thrpt    3  5731.599 ±  365.142  ops/s
EasyCaptchaBench.chineseCaptchaMt           60      200  thrpt    3  4558.626 ±  853.683  ops/s
EasyCaptchaBench.chineseCaptchaSt           48      130  thrpt    3  2091.725 ± 1158.456  ops/s
EasyCaptchaBench.chineseCaptchaSt           48      200  thrpt    3  1752.910 ±  542.747  ops/s
EasyCaptchaBench.chineseCaptchaSt           60      130  thrpt    3  1889.989 ±  656.820  ops/s
EasyCaptchaBench.chineseCaptchaSt           60      200  thrpt    3  1567.616 ±  559.151  ops/s
EasyCaptchaBench.chineseGifCaptchaMt        48      130  thrpt    3  1404.875 ±  222.738  ops/s
EasyCaptchaBench.chineseGifCaptchaMt        48      200  thrpt    3  1070.232 ±  122.111  ops/s
EasyCaptchaBench.chineseGifCaptchaMt        60      130  thrpt    3  1106.242 ±  181.969  ops/s
EasyCaptchaBench.chineseGifCaptchaMt        60      200  thrpt    3   916.152 ±  206.941  ops/s
EasyCaptchaBench.chineseGifCaptchaSt        48      130  thrpt    3   504.950 ±  206.202  ops/s
EasyCaptchaBench.chineseGifCaptchaSt        48      200  thrpt    3   380.179 ±  121.524  ops/s
EasyCaptchaBench.chineseGifCaptchaSt        60      130  thrpt    3   390.404 ±  152.139  ops/s
EasyCaptchaBench.chineseGifCaptchaSt        60      200  thrpt    3   343.713 ±  171.170  ops/s
EasyCaptchaBench.gifCaptchaMt               48      130  thrpt    3   784.455 ±  380.476  ops/s
EasyCaptchaBench.gifCaptchaMt               48      200  thrpt    3   752.327 ±  380.223  ops/s
EasyCaptchaBench.gifCaptchaMt               60      130  thrpt    3   731.610 ±  402.998  ops/s
EasyCaptchaBench.gifCaptchaMt               60      200  thrpt    3   646.019 ±  284.856  ops/s
EasyCaptchaBench.gifCaptchaSt               48      130  thrpt    3   259.477 ±  100.155  ops/s
EasyCaptchaBench.gifCaptchaSt               48      200  thrpt    3   228.505 ±  159.565  ops/s
EasyCaptchaBench.gifCaptchaSt               60      130  thrpt    3   225.556 ±   97.376  ops/s
EasyCaptchaBench.gifCaptchaSt               60      200  thrpt    3   197.091 ±   98.028  ops/s
EasyCaptchaBench.specCaptchaMt              48      130  thrpt    3  2386.506 ± 2945.711  ops/s
EasyCaptchaBench.specCaptchaMt              48      200  thrpt    3  2656.330 ±  904.840  ops/s
EasyCaptchaBench.specCaptchaMt              60      130  thrpt    3  2463.798 ± 4462.446  ops/s
EasyCaptchaBench.specCaptchaMt              60      200  thrpt    3  2446.484 ± 1411.322  ops/s
EasyCaptchaBench.specCaptchaSt              48      130  thrpt    3   944.303 ±  860.177  ops/s
EasyCaptchaBench.specCaptchaSt              48      200  thrpt    3   858.292 ±  705.251  ops/s
EasyCaptchaBench.specCaptchaSt              60      130  thrpt    3   889.298 ±  832.749  ops/s
EasyCaptchaBench.specCaptchaSt              60      200  thrpt    3   804.189 ±  486.221  ops/s
```

