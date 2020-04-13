package com.itsm.jira.entity.enum

import javax.persistence.AttributeConverter
import javax.persistence.Converter

enum class Status(val code: String) {
    NEW("N"),
    IN_WORK("IN"),
    TESTING("T"),
    COMPLETED("CO"),
    DUPLICATE("D"),
    CANCELLED("CA")
}

/**
 * Конвертер для сохранения в БД краткого значения поля
 */
@Converter(autoApply = true)
class StatusConverter : AttributeConverter<Status?, String?> {
    override fun convertToDatabaseColumn(status: Status?): String? {
        return status?.code
    }

    override fun convertToEntityAttribute(code: String?): Status? {
        return if (code == null) {
            null
        } else Status.values().firstOrNull { c -> c.code == code } ?: throw IllegalArgumentException()
    }
}