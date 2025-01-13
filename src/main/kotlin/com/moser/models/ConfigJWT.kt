package com.moser.models

import com.auth0.jwt.algorithms.Algorithm

var mySecret = "secretAstier"
var myIssuer = "http://0.0.0.0:8080/"
var myAudience = "http://0.0.0.0:8080/hello"
var myRealm = "Accés user admin"
var validityInMs = 60*1000 // 1min
var algorithme = Algorithm.HMAC256(mySecret)
