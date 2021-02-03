#### Thread





lambda_app  create -f deployment.yaml

lambda_app get pod

lambda_app delete pod kuai-netdisk-b77c7b8b-9g4zv

lambda_app logs -f --tail=200 kuai-model-6f689797df-xncdb 



Environment.js

kuai-model-6f689797df-mmlpx









1.答案a

运行时在执行类型转换时调用了Integer.intValue方法报空指针异常，反编译代码可以查看到。

2.答案b

不管随机返回true或false，toBe || !toBe 都是返回true，所以返回值是3

3.答案a

IdentityHashMap 判断key是否相等是根据key1==key2进行判断，比较的是地址。 map key 是int值时，在低于等于127时，是从缓存常量池取值，地址不变，所以不会重复添加。当大于128时就会创创建新的对象及地址，地址不一样，可以添加重复的key。

在取值的是也是同样的情况，是因为新的地址，所以取出为null ,如果在put的时候就将变量保存，在get的时候直接使用，就返回正确的值了。