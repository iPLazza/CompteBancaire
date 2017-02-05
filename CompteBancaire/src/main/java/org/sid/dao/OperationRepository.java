package org.sid.dao;

import org.sid.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface OperationRepository extends JpaRepository<Operation, Long> {

	@Query("SELECT o FROM Operation o, Compte c WHERE c.codeCompte=:x order by o.dateOperation desc")
	public Page<Operation> listOperation(@Param("x")String codeCpte, Pageable pageable);
}
