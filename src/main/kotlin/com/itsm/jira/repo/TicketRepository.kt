package com.itsm.jira.repo

import com.itsm.jira.entity.Ticket
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.*

interface TicketRepository : CrudRepository<Ticket, Long> // Дает нашему слою работы с данными весь набор CRUD операций