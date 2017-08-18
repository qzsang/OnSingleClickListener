# OnSingleClickListener
Android中 一个点击仿抖动的ClickListener

无需求不开发。
  需求： 防止重复点击。

需求很简单，就是点击的时候防止重复点击，造成事件重复调用。
我再网上看了一直解决方式  使用自定义的 [NoDoubleClickListener](http://www.barryzhang.com/archives/410),
代码如下
```java
 public abstract class NoDoubleClickListener implements OnClickListener {

            public static final int MIN_CLICK_DELAY_TIME = 1000;
            private long lastClickTime = 0;

            @Override
            public void onClick(View v) {
                long currentTime = Calendar.getInstance().getTimeInMillis();
                if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
                    lastClickTime = currentTime;
                    onNoDoubleClick(v);
                } 
            }   
        }
```

但是实际测试的时候会出现问题，即当click中执行的耗时超过 MIN_CLICK_DELAY_TIME时， 防点击遍不再有效，原因是两个点击事件的调用是走同步，
所以在此给出自己的解决方案,代码如下 很简单，就不解释了，使用中可以根据自己的需求修改MIN_CLICK_DELAY_TIME参数
```java

public abstract class OnSingleClickListener implements View.OnClickListener {
    public static final int MIN_CLICK_DELAY_TIME = 100;//在点击事件处理结束后 的100毫秒的时间内不处理点击事件
    private long endClickTime = 0;

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (Math.abs(currentTime - endClickTime) > MIN_CLICK_DELAY_TIME) {
            singleClick(v);
            endClickTime = System.currentTimeMillis();

        }
    }

    protected abstract void singleClick(View v);

}
```

