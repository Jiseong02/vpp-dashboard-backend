package com.dsl.vpp.generation;

import com.dsl.vpp.der.DerEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "generation")
@Entity
@Data
@Builder
public class GenerationEntity {
    @Id
    String id;
    Double amount;
    LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name="derId")
    DerEntity der;
}
