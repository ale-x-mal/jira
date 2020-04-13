package com.itsm.jira.service

import com.itsm.jira.entity.User
import com.itsm.jira.repo.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service // Позволяем IoC контейнеру внедрять класс
class UserService(private val userRepository: UserRepository) { // Внедряем репозиторий в качестве зависимости

    fun all(): Iterable<User> = userRepository.findAll() // Возвращаем коллекцию сушьностей, Функциональная запись с указанием типа

    fun get(id: Long): User? = userRepository.findByIdOrNull(id)

    fun add(user: User): User = userRepository.save(user)

    fun edit(id: Long, user: User): User = userRepository.save(user.copy(id = id)) // Сохраняем копию объекта с указанным id в БД

    fun remove(id: Long) = userRepository.deleteById(id)
}