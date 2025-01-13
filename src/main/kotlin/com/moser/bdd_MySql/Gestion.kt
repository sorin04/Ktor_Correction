package com.serveur.bdd_MySql

import com.example.retrofit.models.Etudiant
import com.moser.models.User


class Gestion() {
    //var laConnexion = Connexion("jdbc:mysql://localhost/etudiants", "root", "root")
    //pour docker
    var laConnexion = Connexion("jdbc:mysql://mysql/etudiants", "root", "root")


    fun lireLesEtudiants(): ArrayList<Etudiant> {
        var arLesEtudiants = ArrayList<Etudiant>()
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("SELECT * from info")
        var rs = prepStatement.executeQuery()
        while (rs.next()) {
            arLesEtudiants.add(Etudiant(rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("age"),
                rs.getString("image"),
            ))
        }
        return arLesEtudiants
    }

    fun ajoutEtudiant(etudiant: Etudiant): Int {
         var prepStatement = laConnexion.getConnexion()
            .prepareStatement("insert into etudiants.info(firstname, lastname, age, image) VALUES (?, ?, ?, ?) ")
        prepStatement.setString(1,etudiant.firstname)
        prepStatement.setString(2,etudiant.lastname)
        prepStatement.setString(3,etudiant.age)
        prepStatement.setString(4,etudiant.image)
        return prepStatement.executeUpdate()
    }

    fun supprimerUnEtudiant(id:Int):Int{
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("delete from etudiants.info where id=?")
        prepStatement.setInt(1,id)
        return prepStatement.executeUpdate()
    }

    fun lireUnEtudiant(id: String): Etudiant {
        var etudiant = Etudiant()
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("select * from etudiants.info where id=?")
        prepStatement.setString(1,id)
        var rs = prepStatement.executeQuery()
        while (rs.next()) {
            etudiant=(Etudiant(rs.getInt("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("age"),
                rs.getString("image"),
            ))
        }
        return etudiant
    }

    fun userExist(username: String): User? {
        var prepStatement = laConnexion.getConnexion()
            .prepareStatement("SELECT * from etudiants.user WHERE username=?")
        prepStatement.setString(1, username)
        var rs = prepStatement.executeQuery()
        var user: User? = null
        while (rs.next()) {
            user = User(
                rs.getInt("id_user"),
                rs.getString("role"),
                rs.getString("username"),
                rs.getString("password")
            )
        }
        return user
    }
}