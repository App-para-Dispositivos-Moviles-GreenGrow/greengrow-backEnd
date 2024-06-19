package com.greengrow.backend.repository;

import com.greengrow.backend.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for managing Article entities in the GreenGrow application.
 * @author GrowGenius
 * @version 1.0 19/11/2023
 */
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Boolean existsByImagenAndTituloAndFechaAndDescripcion(String imagen, String titulo, String fecha, String descripcion);
}
