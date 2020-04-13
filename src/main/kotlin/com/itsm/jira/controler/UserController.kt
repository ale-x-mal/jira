package com.itsm.jira.controler

import com.itsm.jira.entity.User
import com.itsm.jira.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
@RequestMapping("/users") // Указываем перфик маршруета для всех экшенов
@Api(value = "value User Controller", description = "description for User Controller") //Swagger
class UserController(private val userService: UserService) { // Внедряем наш сервис в качестве зависимости

    @GetMapping // Говорим что экшен принемает GET запрос без параметров в url
    @ApiOperation(value = "Returns all users", notes = "note for users", response = User::class) //Swagger
    fun index() = userService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

    @PostMapping // Экшен принемает POST запрос без параметров в url
    @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
    @ApiOperation(value = "Create user", notes = "note for user", response = User::class) //Swagger
    fun create(@RequestBody user: User) = userService.add(user) // Принемаем объект User из тела запроса и передаем его в метод add нашего сервиса

    @GetMapping("{id}") // Тут мы говорим что при PUT запросе url должен содержать id (http://localhost/users/{id})
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(value = "Find user", notes = "note for user", response = User::class) //Swagger
    fun read(@PathVariable id: Long) = userService.get(id) // Сообщаем что наш id типа Long и передаем его в метод get сервиса

    @PutMapping("{id}")
    @ApiOperation(value = "Update user", notes = "note for user", response = User::class) //Swagger
    fun update(@PathVariable id: Long, @RequestBody user: User) = userService.edit(id, user) // Здесь мы принемаем один параметр из url, второй из тела PUT запроса и отдаем их методу edit

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete user", notes = "note for user") //Swagger
    fun delete(@PathVariable id: Long) = userService.remove(id)
}