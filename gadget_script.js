'use strict';
console.log("Waiting for Java..");
//将该脚本push到手机中 adb push gadget_script.js  data/local/tmp
setImmediate(function() {
    Java.perform(function () {
        var Log = Java.use("android.util.Log");
        Log.v("Frida", "脚本开始执行!");
        var MainActivity = Java.use("com.demo.fridahook.MainActivity");
        MainActivity.add.implementation = function(a,b){
               Log.v("Frida","MainActivity add方法调用 a="+a+" b="+b);
               return this.add(a,b);
        }
        Log.v("Frida", "脚本执行完!");
    });
});