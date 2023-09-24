package com.api.musicplayer.specifications;

import com.api.musicplayer.entities.Musica;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class SpecificationTemplate {


    public static Specification<Musica> musicaPorNomeAutor(String nomeAutor) {
        return (Root<Musica> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            if (nomeAutor == null || nomeAutor.isEmpty()) {
                return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
            } else {
                return criteriaBuilder.like(root.get("autor").get("nome"), "%" + nomeAutor + "%");
            }
        };
    }
}