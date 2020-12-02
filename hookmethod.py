import frida,sys

jscode = """
Java.perform(function(){
    var hook_cls = Java.use('com.demo.fridahook.MainActivity')
    hook_cls.add.implementation = function(a,b){
        console.log("Hook Start...");
        send("var1= "+a+" var2= "+b);
        send("Success!");
        return this.add(a,b);
    }
}
);
"""

def message(message,data):
    if message["type"] == 'send':
        print("[*] {0}".format(message["payload"]))
    else:
        print(message)


print(frida.__version__)
process = frida.get_remote_device().attach('com.demo.fridahook')
script = process.create_script(jscode)
script.on("message",message)
script.load()
sys.stdin.read()