package com.example.individual_5_modulo_5

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    print("Ingrese la cantidad de usuarios a registrar: ")
    val cantidadUsuarios = scanner.nextInt()
    scanner.nextLine()

    val usuarios = mutableListOf<Usuario>()

    for (i in 1..cantidadUsuarios) {
        println("\nIngrese los datos del usuario $i")

        val nombre = solicitarNombre(scanner)
        val apellido = solicitarApellido(scanner)
        val edad = solicitarEdad(scanner)
        val correo = solicitarCorreo(scanner)
        val sistemaSalud = solicitarSistemaSalud(scanner)

        val usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }

    val usuariosOrdenadosPorEdad = usuarios.sortedBy { it.edad }

    println("\nUsuarios registrados ordenados por edad de menor a mayor:")
    for (usuario in usuariosOrdenadosPorEdad) {
        println(usuario)
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int,
    val correo: String,
    val sistemaSalud: String
) {
    override fun toString(): String {
        return "Nombre: $nombre, Apellido: $apellido, Edad: $edad, Correo: $correo, Sistema de Salud: $sistemaSalud"
    }
}

fun solicitarNombre(scanner: Scanner): String {
    while (true) {
        print("Nombre (1-20 caracteres): ")
        val nombre = scanner.nextLine()
        if (nombre.length in 1..20) {
            return nombre
        } else {
            println("Error: El nombre debe tener entre 1 y 20 caracteres.")
        }
    }
}

fun solicitarApellido(scanner: Scanner): String {
    while (true) {
        print("Apellido (solo letras): ")
        val apellido = scanner.nextLine()
        if (apellido.all { it.isLetter() }) {
            return apellido
        } else {
            println("Error: El apellido solo debe contener letras.")
        }
    }
}

fun solicitarEdad(scanner: Scanner): Int {
    while (true) {
        print("Edad (solo números): ")
        val edad = scanner.nextLine()
        if (edad.toIntOrNull() != null) {
            return edad.toInt()
        } else {
            println("Error: La edad debe ser un número válido.")
        }
    }
}

fun solicitarCorreo(scanner: Scanner): String {
    while (true) {
        print("Correo (formato válido): ")
        val correo = scanner.nextLine()
        if (correo.matches(Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"))) {
            return correo
        } else {
            println("Error: El correo debe tener un formato válido.")
        }
    }
}

fun solicitarSistemaSalud(scanner: Scanner): String {
    while (true) {
        println("Sistema de Salud (1. Fonasa, 2. Isapre, 3. Particular): ")
        val opcion = scanner.nextLine()
        when (opcion) {
            "1" -> return "Fonasa"
            "2" -> return "Isapre"
            "3" -> return "Particular"
            else -> println("Error: Debe seleccionar una opción válida (1, 2 o 3).")
        }
    }
}
