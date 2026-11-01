package dev.kaeliton.Bit_a_Bit.Artigo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @GeneratedValue
    private int id;

}
