/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Crear la plataforma bancaria
            EntidadaBancaria plataforma = new EntidadBancaria();

        // Registrar un usuario
        Usuario usuario1 = new Usuario("Juan", "Calle 123", "123456789", "juan@example.com", "123456");
        plataforma.registrarUsuario(usuario1);

        // Crear una cuenta de ahorro para el usuario
        plataforma.crearCuentaDeAhorro(usuario1);

        // Realizar una transferencia
        String numeroCuentaEmisor = "1234567890"; // Número de cuenta del emisor (usuario1)
        String numeroCuentaDestinatario = "0987654321"; // Número de cuenta del destinatario
        double cantidadTransferencia = 1000.0; // Cantidad a transferir
        String contrasenaEmisor = "123456"; // Contraseña del emisor (usuario1)
        plataforma.realizarTransferencia(numeroCuentaEmisor, numeroCuentaDestinatario, cantidadTransferencia, contrasenaEmisor);

        // Consultar saldo
        String numeroCuentaConsulta = "1234567890"; // Número de cuenta a consultar
        String contrasenaConsulta = "123456"; // Contraseña para la consulta
        double saldo = plataforma.consultarSaldo(numeroCuentaConsulta, contrasenaConsulta);
        System.out.println("Saldo de la cuenta " + numeroCuentaConsulta + ": $" + saldo);

        // Consultar transacciones
        System.out.println("Transacciones de la cuenta " + numeroCuentaConsulta + ":");
        for (Transaccion transaccion : plataforma.consultarTransacciones(numeroCuentaConsulta, contrasenaConsulta)) {
            System.out.println(transaccion.getFecha() + " - " + transaccion.getTipo() + " - $" + transaccion.getCantidad());
        }
    }
}

