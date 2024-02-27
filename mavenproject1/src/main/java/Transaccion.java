/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan
 */
import com.mycompany.mavenproject1.Usuario;
import java.util.Date;

public class Transaccion {
    public enum Tipo { ENTRADA, SALIDA }

    private Tipo tipo;
    private double cantidad;
    private Date fecha;
    private String categoria;
    private Usuario usuarioDestinatario;
    private Usuario usuarioEmisor;

    public Transaccion(Tipo tipo, double cantidad, Date fecha, String categoria, Usuario usuarioDestinatario, Usuario usuarioEmisor) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.categoria = categoria;
        this.usuarioDestinatario = usuarioDestinatario;
        this.usuarioEmisor = usuarioEmisor;
    }

    // Getters y setters
    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Usuario getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    public void setUsuarioDestinatario(Usuario usuarioDestinatario) {
        this.usuarioDestinatario = usuarioDestinatario;
    }

    public Usuario getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(Usuario usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }
}
