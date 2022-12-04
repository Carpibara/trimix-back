package com.cristian.demo.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
public class Persona {
    @Id
    @GeneratedValue
    private Long perId;
    @NotNull
    @NotEmpty
    private String perApellido;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date perFechaNacimiento;
    @NotNull
    @NotEmpty
    private String perNombre;
    @NotNull
    private Long perNumeroDocumento;
    @NotNull
    private TipoDocumento perTipoDocumento;

    //Se Debería crear una clase para los tipos de documentos. Creo que para este ejemplo un "enum" es suficiente.
    public enum TipoDocumento {
        DNI,
        PASAPORTE,
        CEDULA
    }

    public Long getPerId() {
        return perId;
    }

    public void setPerId(Long perId) {
        this.perId = perId;
    }

    public String getPerApellido() {
        return perApellido;
    }

    public void setPerApellido(String perApellido) {
        this.perApellido = perApellido;
    }

    public Date getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    public void setPerFechaNacimiento(Date perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public Long getPerNumeroDocumento() {
        return perNumeroDocumento;
    }

    public void setPerNumeroDocumento(Long perNumeroDocumento) {
        this.perNumeroDocumento = perNumeroDocumento;
    }

    public TipoDocumento getPerTipoDocumento() {
        return perTipoDocumento;
    }

    public void setPerTipoDocumento(TipoDocumento perTipoDocumento) {
        this.perTipoDocumento = perTipoDocumento;
    }
}
