package com.itsm.jira.entity

import com.fasterxml.jackson.annotation.JsonProperty
import com.itsm.jira.entity.enum.Priority
import com.itsm.jira.entity.enum.Status
import io.swagger.annotations.ApiModelProperty
import javax.persistence.*

@Entity // Указывает на то что этот класс описывает модель данных
@Table(name = "ticket") // Говорим как назвать таблицу в БД
data class Ticket(// Дата класс нам сгенерирует методы equals и hashCode и даст метод copy

        @Id // Сообщяем ORM что это поле - Primary Key
        @JsonProperty("id")
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @ApiModelProperty(notes = "Id of the Ticket")
        val id: Long = 0L,

        @JsonProperty("title") // Говорим как будет называться свойство в json объекте
        @Column(name = "title", length = 200) // Говорим как будет называться поле в БД и задаем его длинну
        @ApiModelProperty(notes = "Title of the Ticket")
        val title: String = "", // Объявляем неизменяемое свойство (геттер, а также поле для него будут сгенерированны автоматически), с пустой строкой в качестве значения по умолчанию

        @JsonProperty("priority")
        @Column(name = "priority", length = 10)
        @ApiModelProperty(notes = "Priority of the Ticket")
//        @Enumerated(EnumType.STRING)
        val priority: Priority = Priority.MEDIUM,

        @JsonProperty("status")
        @Column(name = "status", length = 10)
        @ApiModelProperty(notes = "Status of the Ticket")
//        @Enumerated(EnumType.STRING)
        val status: Status = Status.NEW,

        @JsonProperty("description")
        @Column(name = "description", length = 1000)
        @ApiModelProperty(notes = "Description of the Ticket")
        val description: String = "",

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn (name="creator_id")
//        @Column(nullable = false)
        @ApiModelProperty(notes = "Creator of the Ticket")
        var creator: User
) {


//        constructor(title: String, creator: User) : this(title = title) {
//                this.creator = creator
//        }
}