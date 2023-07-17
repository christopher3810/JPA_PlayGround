package com.Jpa_playground.smy.cacheDemo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@NamedQuery(name ="ITCompany.findByTheCompanyName", query = "from ITCompany c where c.companyname = ?1")
public class ITCompany extends AbstractPersistable<Long> {

    private static final long serialVersionUID = -2952735933715107252L;

    @Getter
    @Setter
    @Column(unique = true)
    private String companyname;

    @Getter
    @Setter
    private String companyStockTicker;
    @Getter
    @Setter
    private String companyEPS;

    public ITCompany() {
        this(null);
    }

    /**
     * Creates a new ITCompany instance.
     */
    private ITCompany(Long id) {
        this.setId(id);
    }

}
