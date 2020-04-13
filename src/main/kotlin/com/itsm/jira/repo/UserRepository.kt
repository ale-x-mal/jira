package com.itsm.jira.repo

import com.itsm.jira.entity.User
import org.springframework.data.repository.*

interface UserRepository : CrudRepository<User, Long> // Дает нашему слою работы с данными весь набор CRUD операций