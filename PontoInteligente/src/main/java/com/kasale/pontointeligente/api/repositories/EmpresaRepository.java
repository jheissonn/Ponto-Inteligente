package com.kasale.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kasale.pontointeligente.api.entities.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	
	/* Gera query, e será apenas para leitura readOnly não precisa de transação*/
	@Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}
