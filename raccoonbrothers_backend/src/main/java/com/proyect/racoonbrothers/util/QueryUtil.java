package com.proyect.racoonbrothers.util;

public class QueryUtil {

    private String plantilla = "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "" +
            "";

    public static String SELECT_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT " +
            "ac.id as idAccount, " +
            "ac.id as idPerson, " +
            "ac.status, " +
            "ac.username, " +
            "pe.name, " +
            "pe.lastname, " +
            "pe.mother_lastname, " +
            "rol.id as idRole, " +
            "rol.name as roleType " +
            "FROM people pe " +
            "LEFT JOIN accounts ac ON ac.id = pe.id_account " +
            "LEFT JOIN roles rol ON ac.id_role = rol.id " +
            "WHERE ac.username = (?) AND ac.password = (?)";



}
