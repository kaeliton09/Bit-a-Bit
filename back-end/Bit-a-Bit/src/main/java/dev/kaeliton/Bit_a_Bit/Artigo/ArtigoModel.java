package dev.kaeliton.Bit_a_Bit.Artigo;

import java.time.LocalDateTime;

import dev.kaeliton.Bit_a_Bit.Usuario.UsuarioModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artigo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArtigoModel {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private LocalDateTime dataPublicacao;

    @Column(columnDefinition = "TEXT")
    private String texto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

}
