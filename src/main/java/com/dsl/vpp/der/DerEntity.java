package com.dsl.vpp.der;

import com.dsl.vpp.vpp.core.VppEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Table(name="der")
@Entity
@Data
@Builder
public class DerEntity {
    @Id
    @GeneratedValue
    String id;
    Double capacity;
    @ManyToOne
    @JoinColumn(name="vppId")
    VppEntity vpp;

    public void register(VppEntity vpp) {
        this.vpp = vpp;
    }
    public void unregister() {
        if(this.vpp == null) throw new IllegalStateException("해당 DER은 소속된 VPP가 없습니다.");
        this.vpp = null;
    }
}
