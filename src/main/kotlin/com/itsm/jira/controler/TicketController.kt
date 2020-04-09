package com.itsm.jira.controler

import com.itsm.jira.entity.Ticket
import com.itsm.jira.service.TicketService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController // Сообщаем как обрабатывать http запросы и в каком виде отправлять ответы (сериализация в JSON и обратно)
@RequestMapping("/tickets") // Указываем перфик маршруета для всех экшенов
@Api(value = "value Ticket Controller", description = "description for Ticket Controller") //Swagger
class TicketController(private val ticketService: TicketService) { // Внедряем наш сервис в качестве зависимости

    @GetMapping // Говорим что экшен принемает GET запрос без параметров в url
    @ApiOperation(value = "Returns all tickets", notes = "note for tickets", response = Ticket::class) //Swagger
    @ApiResponses(value = [ApiResponse(code = 200, message = "ОК, Successful request"),
                            ApiResponse(code = 401, message = "Unauthorized"),
                            ApiResponse(code = 403, message = "Forbidden"),
                            ApiResponse(code = 404, message = "Not Found")]) //Swagger, пример как можно описывать ошибки
    fun index() = ticketService.all() // И возвращает результат метода all нашего сервиса. Функциональная запись с выводом типа

    @PostMapping // Экшен принемает POST запрос без параметров в url
    @ResponseStatus(HttpStatus.CREATED) // Указываем специфический HttpStatus при успешном ответе
    @ApiOperation(value = "Create ticket", notes = "note for ticket", response = Ticket::class) //Swagger
    fun create(@RequestBody ticket: Ticket) = ticketService.add(ticket) // Принемаем объект Ticket из тела запроса и передаем его в метод add нашего сервиса

    @GetMapping("{id}") // Тут мы говорим что при PUT запросе url должен содержать id (http://localhost/tickets/{id})
    @ResponseStatus(HttpStatus.FOUND)
    @ApiOperation(value = "Find ticket", notes = "note for ticket", response = Ticket::class) //Swagger
    fun read(@PathVariable id: Long) = ticketService.get(id) // Сообщаем что наш id типа Long и передаем его в метод get сервиса

    @PutMapping("{id}")
    @ApiOperation(value = "Update ticket", notes = "note for ticket", response = Ticket::class) //Swagger
    fun update(@PathVariable id: Long, @RequestBody ticket: Ticket) = ticketService.edit(id, ticket) // Здесь мы принемаем один параметр из url, второй из тела PUT запроса и отдаем их методу edit

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete ticket", notes = "note for ticket") //Swagger
    fun delete(@PathVariable id: Long) = ticketService.remove(id)
}