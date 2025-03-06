package tech.trimed.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.DisciplinaEntity;

@ApplicationScoped
public class DisciplinaRepository implements PanacheRepositoryBase<DisciplinaEntity, Integer> {
}
