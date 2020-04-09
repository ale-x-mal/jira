package com.itsm.jira.service

import com.itsm.jira.entity.Ticket
import com.itsm.jira.repo.TicketRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service // Позволяем IoC контейнеру внедрять класс
class TicketService(private val ticketRepository: TicketRepository) { // Внедряем репозиторий в качестве зависимости

    fun all(): Iterable<Ticket> = ticketRepository.findAll() // Возвращаем коллекцию сушьностей, Функциональная запись с указанием типа

    fun get(id: Long): Ticket? = ticketRepository.findByIdOrNull(id)

    fun add(ticket: Ticket): Ticket = ticketRepository.save(ticket)

    fun edit(id: Long, ticket: Ticket): Ticket = ticketRepository.save(ticket.copy(id = id)) // Сохраняем копию объекта с указанным id в БД

    fun remove(id: Long) = ticketRepository.deleteById(id)
}