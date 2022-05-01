package com.playCog.playcog.models;

import javax.persistence.*;

@Entity
@Table(name = "progreso")
public class Progress {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "progreso_seq_generator")
    @SequenceGenerator(
            name = "progreso_seq_generator",
            sequenceName = "progreso_id_seq",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_usuario",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "progreso_usuario_fkey",
                    foreignKeyDefinition = "FOREIGN KEY (id_usuario)\r\n" +
                            "REFERENCES public.\"usuario\" (id) MATCH SIMPLE\r\n" +
                            "ON UPDATE CASCADE\r\n" +
                            "ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private User idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_videojuego",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "progreso_videojuego_fkey",
                    foreignKeyDefinition = "FOREIGN KEY (id_videojuego)\r\n" +
                            "REFERENCES public.\"videojuego\" (id) MATCH SIMPLE\r\n" +
                            "ON UPDATE CASCADE\r\n" +
                            "ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Videogame idVideogame;

    @Column(name = "informacion")
    private String informacion;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public User getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(User idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Videogame getIdVideogame() {
        return idVideogame;
    }
    public void setIdVideogame(Videogame idVideogame) {
        this.idVideogame = idVideogame;
    }

    public String getInformacion() {
        return informacion;
    }
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
