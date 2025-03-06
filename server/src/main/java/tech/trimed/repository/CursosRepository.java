package tech.trimed.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.CursoEntity;

@ApplicationScoped
public class CursosRepository implements PanacheRepositoryBase<CursoEntity, Integer> {
}
