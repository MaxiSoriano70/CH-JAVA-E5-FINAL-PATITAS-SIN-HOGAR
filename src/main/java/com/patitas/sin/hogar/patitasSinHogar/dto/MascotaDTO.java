package com.patitas.sin.hogar.patitasSinHogar.dto;

import com.patitas.sin.hogar.patitasSinHogar.utils.EEspecie;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEstadoMascota;
import com.patitas.sin.hogar.patitasSinHogar.utils.EEsterilizado;
import com.patitas.sin.hogar.patitasSinHogar.utils.ESexo;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MascotaDTO {
    @NotNull(message = "El nombre no puede ser nulo")
    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,}$", message = "El nombre debe tener al menos 2 letras y no contener números")
    private String nombre;

    @NotNull(message = "La fecha de nacimiento no puede ser nula")
    private LocalDate fechaDeNacimiento;
    private Integer edad;

    @NotNull(message = "El sexo no puede ser nulo")
    private ESexo sexo;

    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,}$", message = "El color de pelo debe tener al menos 2 letras y no contener números")
    private String colorDePelo;

    @NotNull(message = "La dirección no puede ser nula")
    @Size(min = 3, message = "La dirección debe tener al menos 3 caracteres")
    private String direccion;

    @NotNull(message = "La especie no puede ser nula")
    private EEspecie especie;

    @Pattern(regexp = "^[A-Za-zÁÉÍÓÚáéíóúñÑ ]{2,}$", message = "La raza debe tener al menos 2 letras y no contener números")
    private String raza;

    private EEsterilizado esterilizado;

    @NotNull(message = "El peso no puede ser nulo")
    @Positive(message = "El peso debe ser mayor a 0")
    private Double pesoKg;

    @Size(min = 3, message = "La descripción debe tener al menos 3 caracteres")
    private String descripcion;

    @NotNull(message = "La URL de la imagen no puede ser nula")
    @Pattern(regexp = "^(https?://.*\\.(jpg|png))$", message = "La URL debe ser una imagen en formato .jpg o .png")
    private String urlImagen;

    @NotNull(message = "La fecha de publicación no puede ser nula")
    private LocalDate fechaPublicacion;

    @NotNull(message = "El estado de la mascota no puede ser nulo")
    private EEstadoMascota estadoMascota;

    @NotNull(message = "El ID del usuario no puede ser nulo")
    private Integer idUsuario;

    public MascotaDTO(String nombre, LocalDate fechaDeNacimiento, ESexo sexo, String colorDePelo,
                      String direccion, EEspecie especie, String raza, EEsterilizado esterilizado,
                      Double pesoKg, String descripcion, String urlImagen, LocalDate fechaPublicacion,
                      EEstadoMascota estadoMascota, Integer idUsuario) {
        this.nombre = nombre;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.edad = calcularEdad(fechaDeNacimiento);
        this.sexo = sexo;
        this.colorDePelo = colorDePelo;
        this.direccion = direccion;
        this.especie = especie;
        this.raza = raza;
        this.esterilizado = esterilizado;
        this.pesoKg = pesoKg;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.fechaPublicacion = fechaPublicacion;
        this.estadoMascota = estadoMascota;
        this.idUsuario = idUsuario;
    }

    private Integer calcularEdad(LocalDate fechaDeNacimiento) {
        if (fechaDeNacimiento == null) {
            return null;
        }
        return Period.between(fechaDeNacimiento, LocalDate.now()).getYears();
    }
}
