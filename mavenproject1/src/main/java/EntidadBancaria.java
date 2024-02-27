/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan
 */
import com.mycompany.mavenproject1.CuentaDeAhorro;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EntidadBancaria {
    private List<Usuario> usuarios;
    private List<CuentaDeAhorro> cuentasDeAhorro;
    private List<Transaccion> transacciones;

    public EntidadBancaria() {
        usuarios = new ArrayList<>();
        cuentasDeAhorro = new ArrayList<>();
        transacciones = new ArrayList<>();
    }

    
    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

   
    public void crearCuentaDeAhorro(Usuario usuario) {
        
        String numeroCuenta = generarNumeroCuenta();
        CuentaDeAhorro cuentaDeAhorro = new CuentaDeAhorro(numeroCuenta, 0.0);
        cuentasDeAhorro.add(cuentaDeAhorro);
    }

    
    public boolean realizarTransferencia(String numeroCuentaEmisor, String numeroCuentaDestinatario, double cantidad, Usuario usuarioEmisor) {
           // Buscar las cuentas involucradas en la transferencia
        CuentaDeAhorro cuentaEmisor = buscarCuenta(numeroCuentaEmisor);
        CuentaDeAhorro cuentaDestinatario = buscarCuenta(numeroCuentaDestinatario);

        // Verificar que las cuentas existen y que hay saldo suficiente en la cuenta emisora
        if (cuentaEmisor != null && cuentaDestinatario != null && cuentaEmisor.getSaldo() >= cantidad && cuentaEmisor.getUsuario().getContrasena().equals(contrasenaEmisor)) {
            // Actualizar los saldos de las cuentas
            cuentaEmisor.setSaldo(cuentaEmisor.getSaldo() - cantidad);
            cuentaDestinatario.setSaldo(cuentaDestinatario.getSaldo() + cantidad);

            // Registrar la transacción
            Transaccion transaccion = new Transaccion(Transaccion.Tipo.SALIDA, cantidad, new Date(), "Transferencia", cuentaDestinatario.getUsuario(), cuentaEmisor.getUsuario());
            transacciones.add(transaccion);

            return true; // Transferencia exitosa
        }

        return false; // Transferencia fallida
    }

    
    public double consultarSaldo(String numeroCuenta, String contrasena) {
        CuentaDeAhorro cuenta = buscarCuenta(numeroCuenta);
        
        // Verificar que la cuenta existe y la contraseña es correcta
        if (cuenta != null && cuenta.getUsuario().getContrasena().equals(contrasena)) {
            return cuenta.getSaldo(); // Devolver el saldo de la cuenta
        }

        return -1;
        
    }

    
    public List<Transaccion> consultarTransacciones(String numeroCuenta, String contrasena) {
    List<Transaccion> transaccionesCuenta = new ArrayList<>();
    CuentaDeAhorro cuenta = buscarCuenta(numeroCuenta);
    
    // Verificar que la cuenta existe y la contraseña es correcta
    if (cuenta != null && cuenta.getUsuario().getcontrasena().equals(contrasena)) {
        for (Transaccion transaccion : transacciones) {
            // Verificar si la transacción pertenece a la cuenta especificada
            if (transaccion.getUsuarioEmisor().equals(cuenta.getUsuario()) ||
                transaccion.getUsuarioDestinatario().equals(cuenta.getUsuario())) {
                transaccionesCuenta.add(transaccion);
            }
        }
    }
    return transaccionesCuenta;
}

    
    private CuentaDeAhorro buscarCuenta(String numeroCuenta) {
        for (CuentaDeAhorro cuenta : cuentasDeAhorro) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return cuenta;
            }
        }
        return null; // La cuenta no fue encontrada
    }
   
    private String generarNumeroCuenta() {
        String numeroCuenta;
        do {
            numeroCuenta = String.valueOf(new Random().nextInt(900000000) + 100000000); // Genera un número aleatorio de 10 dígitos
        } while (existeCuenta(numeroCuenta)); 
        return numeroCuenta;
    }

    
    private boolean existeCuenta(String numeroCuenta) {
        for (CuentaDeAhorro cuenta : cuentasDeAhorro) {
            if (cuenta.getNumeroCuenta().equals(numeroCuenta)) {
                return true;
            }
        }
        return false;
    }
}
