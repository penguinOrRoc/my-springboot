#1.count(*)慢如何解决？count(1)、count(*)、count(字段)、count(主键)的查询效率？
    MyISAM引擎把一个表的总行数存在了磁盘上，因此执行count(*)的时候会直接返回这个数，效率很高，但是不支持事务；
    InnoDB引擎，执行count(*)的时候，需要把数据一行一行地从引擎里面读出来，然后累积计数，虽然结果准确，但会导致性能问题。
    show table status命令虽然返回很快，但是不准确；

    count(*)、count(主键id)和count(1) 都表示返回满足条件的结果集的总行数；
    对于count(主键id)来说，InnoDB引擎会遍历整张表，把每一行的id值都取出来，返回给server层。server层拿到id后，判断是不可能为空的，就按行累加。
    对于count(1)来说，InnoDB引擎遍历整张表，但不取值。server层对于返回的每一行，放一个数字“1”进去，判断是不可能为空的，按行累加。
    但是count(*)是例外，并不会把全部字段取出来，而是专门做了优化，不取值。
    按照效率排序的话，count(字段)<count(主键id)<count(1)≈count(*)
    
    count(*)缓存到Redis（并持久化）、持久化到数据库，利用binlog日志对指定表的insert  + 1



#2.join和多次select？