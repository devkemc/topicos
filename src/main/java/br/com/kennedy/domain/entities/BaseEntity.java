package br.com.kennedy.domain.entities;

import java.io.Serializable;
import java.util.Objects;

public class BaseEntity implements Serializable {

        private static final long serialVersionUID = 1L;

        private Long id;

        public BaseEntity() {
        }

        public BaseEntity(Long id) {
            this.id = id;
        }

        public Long getId() {
            return this.id;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }
}
