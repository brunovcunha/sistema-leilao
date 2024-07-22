package iftm.edu.leilao.repository;

import iftm.edu.leilao.model.ItemDeLeilao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemLeilaoRepository extends JpaRepository<ItemDeLeilao, Integer> {
}
