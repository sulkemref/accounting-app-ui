package com.cydeo.accounting_app.entity;

import com.cydeo.accounting_app.enums.ClientVendorType;

import lombok.*;
import org.hibernate.annotations.Where;


import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "clients_vendors")
@Where(clause = "is_deleted = false")
public class ClientVendor extends BaseEntity {
    private String clientVendorName;
    private String phone;
    private String website;
    @Enumerated(EnumType.STRING)
    private ClientVendorType clientVendorType;
    @JoinColumn(name = "address_id")
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;
    @JoinColumn(name = "company_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Company company;

}
