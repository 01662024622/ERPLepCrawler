package com.fastwok.crawler.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Products")
public class Product {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Long ERPId; /// ERP ID
    private String ERPCode; /// ERP ID
    private String ERPName; /// ERP ID
    private Long ERPParentId; /// ERP ID
    private Long NId;  /// nhanh ID
    private String NCode; /// ERP ID
    private String NName; /// ERP ID
}
