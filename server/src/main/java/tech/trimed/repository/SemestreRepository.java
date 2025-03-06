package tech.trimed.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import tech.trimed.entity.SemestreEntity;

@ApplicationScoped
public class SemestreRepository implements PanacheRepositoryBase<SemestreEntity, Integer> {
}
