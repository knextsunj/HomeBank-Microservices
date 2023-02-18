package com.github.knextsunj.homebank.cardtypemaster.domain

import javax.persistence.*

@Entity
@Table(name = "card_type")
@NamedQuery(name = "CardType.findAllCardTypeOrderByName",query="select cardtype from CardType cardtype where cardtype.deleted='N' order by cardtype.name")
open class CardType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = 0;

    @Column(name = "name")
    open var name: String? = null;

    @Column(name = "is_deleted",insertable = false)
    open var deleted: String? = null
}