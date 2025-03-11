### ISSUE with configuring writeConcern other than MAJORITY for MONGOCK

### Spring boot 2.7.18
1. spring-data-mongodb 3.X.X
2. BOM io.mongock -> 5.4.4
3. mongock-springboot
4. mongodb-springdata-v3-driver

```yaml
mongock:
  enabled: true
  migration-scan-package:
    - mongock.writeConcern.w1.changeLog
  lock-repository-name: mongock.changeLog.lock
  migration-repository-name: mongock.changeLog.history
  transaction-enabled: false
  #runner-type: InitializingBean

  mongo-db:
    read-concern: local
    read-preference: primary
    write-concern:
      w: 1
```

Application startup failes on exception

```
2025-03-11 11:18:14.114 ERROR 17912 --- [           main] o.s.boot.SpringApplication               : Application run failed

java.lang.IllegalStateException: Failed to execute ApplicationRunner
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:759) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.lambda$callRunners$2(SpringApplication.java:746) ~[spring-boot-2.7.18.jar:2.7.18]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184) ~[na:na]
	at java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151) ~[na:na]
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) ~[na:na]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:744) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1300) ~[spring-boot-2.7.18.jar:2.7.18]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1289) ~[spring-boot-2.7.18.jar:2.7.18]
	at mongock.writeConcern.w1.W1Application.main(W1Application.java:13) ~[classes/:na]
Caused by: io.mongock.api.exception.MongockException: com.mongodb.MongoWriteConcernException: No write concern mode named '1' found in replica set configuration
	at io.mongock.runner.core.executor.MongockRunnerImpl.execute(MongockRunnerImpl.java:81) ~[mongock-runner-core-5.4.4.jar:na]
	at io.mongock.runner.springboot.base.MongockApplicationRunner.run(MongockApplicationRunner.java:18) ~[mongock-springboot-base-5.4.4.jar:na]
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:756) ~[spring-boot-2.7.18.jar:2.7.18]
	... 14 common frames omitted
Caused by: com.mongodb.MongoWriteConcernException: No write concern mode named '1' found in replica set configuration
	at com.mongodb.client.internal.MongoCollectionImpl.executeSingleWriteRequest(MongoCollectionImpl.java:1016) ~[mongodb-driver-sync-4.6.1.jar:na]
	at com.mongodb.client.internal.MongoCollectionImpl.executeUpdate(MongoCollectionImpl.java:994) ~[mongodb-driver-sync-4.6.1.jar:na]
	at com.mongodb.client.internal.MongoCollectionImpl.updateMany(MongoCollectionImpl.java:625) ~[mongodb-driver-sync-4.6.1.jar:na]
	at io.mongock.driver.mongodb.sync.v4.repository.MongoSync4LockRepository.insertUpdate(MongoSync4LockRepository.java:101) ~[mongodb-sync-v4-driver-5.4.4.jar:na]
	at io.mongock.driver.mongodb.sync.v4.repository.MongoSync4LockRepository.insertUpdate(MongoSync4LockRepository.java:48) ~[mongodb-sync-v4-driver-5.4.4.jar:na]
	at io.mongock.driver.core.lock.LockManagerDefault.acquireLockDefault(LockManagerDefault.java:151) ~[mongock-driver-core-5.4.4.jar:na]
	at io.mongock.runner.core.executor.operation.migrate.MigrateExecutorBase.executeMigration(MigrateExecutorBase.java:61) ~[mongock-runner-core-5.4.4.jar:na]
	at io.mongock.runner.core.executor.operation.migrate.MigrateExecutorBase.executeMigration(MigrateExecutorBase.java:18) ~[mongock-runner-core-5.4.4.jar:na]
	at io.mongock.runner.core.executor.MongockRunnerImpl.execute(MongockRunnerImpl.java:58) ~[mongock-runner-core-5.4.4.jar:na]
	... 16 common frames omitted
```



### Spring boot 3.2.10
1. spring-data-mongodb 4.X.X
2. BOM io.mongock -> 5.4.4
3. mongock-springboot
4. mongodb-springdata-v4-driver (undocumented driver)

Configuration is exactly the same, and the exception is also the same. Exception is thrown No write concern mode named '1' found in replica set configuration

