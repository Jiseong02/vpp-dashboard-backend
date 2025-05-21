package com.dsl.vpp.vpp.core;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Table(name="vpp")
@Entity
@Data
@Builder
public class VppEntity {
    @Id
    String id;
}
