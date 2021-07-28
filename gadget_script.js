'use strict';
 
console.log("Waiting for Java..");
 
Java.perform(function () {
   var Log = Java.use("android.util.Log");
   Log.v("frida-lief", "Have fun!");
   var hook_class_mac = Java.use("com.demo.fridahook.HookCla2");
   hook_class_mac.showadd.implementation = function(){
     Log.v("Frida","获取showadd方法调用");//只能调用一次，调用第二次就崩溃
     return this.showadd();
   }
//   hook_class_mac.add.implementation = function(a,b){
//               Log.v("Frida","获取add方法调用 a="+a);
//               return this.add(a,b);
//   }
   Log.v("frida", "脚本执行完!");
});