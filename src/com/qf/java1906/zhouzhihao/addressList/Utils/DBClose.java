package com.qf.java1906.zhouzhihao.addressList.Utils;

public class DBClose {
    public static void closeAll(AutoCloseable ... close){
        for (AutoCloseable a:close
             ) {
            try {
                a.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
