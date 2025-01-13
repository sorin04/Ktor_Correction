package com.moser.plugins

import com.moser.models.SendToken
import com.moser.models.User
import com.moser.utils.TokenManager
import com.serveur.bdd_MySql.Gestion
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.freemarker.FreeMarkerContent
import io.ktor.server.request.receive
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    var maGestion = Gestion()

        routing {
            get("/") {
                call.respond("")
            }
            post("/login") {
                val tokenManager = TokenManager()
                val userCredentials = call.receive<User>()
                val username = userCredentials.username
                val password = userCredentials.password

                //test de l'existance du username dans la bdd
                val user = maGestion.userExist(username)
                if (user == null) {
                    call.respond(HttpStatusCode.BadRequest, "Username ou password invalide.")
                    return@post
                }

//                 //pour generer hach pour le loging de la bdd
//                    val passwordMatch =BCrypt.hashpw("michael",BCrypt.gensalt())
//                    println(passwordMatch)
//
//                //si username existe on teste l'égalité du hash du password
//                val passwordMatch = BCrypt.checkpw(password, user.password)
//                if (!passwordMatch) {
//                    call.respond(HttpStatusCode.BadRequest, "Username ou password invalide.")
//                    return@post
//                }
                if (password != user.password) {
                    call.respond(HttpStatusCode.BadRequest, "Username ou password invalide.")
                    return@post
                }
                val token = SendToken(user.id_user, user.username, user.role, tokenManager.generateJWTToken(user))
                call.respond(HttpStatusCode.OK, token)
            }

            authenticate("auth-jwt") {
                get("/") {
                    println(maGestion.lireLesEtudiants())
                    call.respond(FreeMarkerContent("index.ftl", mapOf("etudiants" to maGestion.lireLesEtudiants())))
                }

                get("/all"){
                    var allEtudiants = maGestion.lireLesEtudiants()
                    println("dans /etu/all-> $allEtudiants ")
                    when (allEtudiants.size>0) {
                        true->{
                            call.respond(HttpStatusCode.OK, allEtudiants)
                        }
                        false->{
                            call.respond(HttpStatusCode.NoContent)
                        }
                    }
                }

                get("/info/{etudiantId}"){
                    var etudiant=maGestion.lireUnEtudiant(call.parameters["etudiantId"]!!)
                    call.respond(FreeMarkerContent("info.ftl", mapOf("etudiant" to etudiant )))
                }

                get("/{id}") {
                    val id = call.parameters["id"]
                    if (id != null) {
                        val etudiant = maGestion.lireUnEtudiant(id)
                        if (etudiant != null) {
                            call.respond(HttpStatusCode.OK, etudiant)
                            println("dans /etu/$id -> $etudiant")
                        } else {
                            call.respond(HttpStatusCode.NotFound, "Etudiant not found")
                        }
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Missing or malformed id")
                    }
                }
            }

            }

}
