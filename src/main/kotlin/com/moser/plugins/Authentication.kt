package com.moser.plugins


import com.moser.models.myRealm
import com.moser.utils.TokenManager
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.Authentication
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*


fun Application.configureAuthentication() {
    val tokenManager = TokenManager()
    install(Authentication)  {
        jwt("auth-jwt") {
            //définir le domaine à transmettre dans l' WWW-Authenticateen-tête lors de l'accès à une route protégée
            realm = myRealm
            //La verifierfonction permet de vérifier un format de token et sa signature :
            //Pour HS256, vous devez transmettre une instance de JWTVerifier pour vérifier un jeton.
            verifier(tokenManager.verifyJWTToken())
            //La validate fonction vous permet d'effectuer des validations supplémentaires sur la charge utile JWT
            validate { jwtCredential ->
                if (jwtCredential.payload.getClaim("username").asString().isNotEmpty()) {
                    JWTPrincipal(jwtCredential.payload)
                } else {
                    null
                }
            }
            //La challengefonction vous permet de configurer une réponse à envoyer en cas d'échec de l'authentification
            challenge { defaultScheme, realm ->
                call.respond(
                    HttpStatusCode.Unauthorized,
                    "Token ${HttpHeaders.WWWAuthenticate} $defaultScheme realm=\"$realm\" invalide ou expiré"
                )
            }
        }
    }

}
