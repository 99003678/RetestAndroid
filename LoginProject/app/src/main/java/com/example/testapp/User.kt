package com.example.testapp

class User(var username : String,  var pass : String) {

    var ename : String = ""
    var epass : String = ""
   init {
       var ename = username
       var epass = pass
   }
}