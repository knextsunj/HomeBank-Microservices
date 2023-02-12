package com.github.knextsunj.homebank.colorcardmaster.domain

import javax.persistence.*

@Entity
@Table(name = "color_card")
@NamedQuery(name = "ColorCard.findAllColorCardOrderByName",query="select colorcard from ColorCard colorcard where colorcard.deleted='N' order by colorcard.name")
open class ColorCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = 0;

    @Column(name = "name")
    open var name: String? = null;

    @Column(name = "is_deleted",insertable = false)
    open var deleted: String? = null
}