package com.dsl.vpp.vpp.core;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VppRepository extends JpaRepository<VppEntity, String> {
}
