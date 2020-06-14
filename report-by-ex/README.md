# 异常捕获的开销



## 测试数据

```shell
# Run complete. Total time: 00:01:19

Benchmark                 Mode  Cnt         Score         Error   Units
ExBench.fail             thrpt    3  15916982.238 ± 9900570.642  ops/ms
ExBench.failByCatch      thrpt    3         5.489 ±       4.158  ops/ms
ExBench.success          thrpt    3  17354222.761 ±  932506.514  ops/ms
ExBench.successNoThrown  thrpt    3  17398840.848 ± 2424639.607  ops/ms
```



### 测试方法说明

`fail`：业务处理失败，通过返回值的方式返回错误信息

`failByCatch`：业务处理失败，通过异常捕获的方式转换为错误信息

`success`：业务处理成功

`successNoThrown`：业务处理成功



### 结论

- 异常捕获(`try-catch`)的开销巨大，上面的测试结果显示性能相差`2,899,796`倍
- 不能将异常抛出作为错误传播的常规手段，能不用则不用。





