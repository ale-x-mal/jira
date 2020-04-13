package com.itsm.jira.entity.enum

import javax.persistence.AttributeConverter
import javax.persistence.Converter


enum class Priority(val code: String) {
    CRITICAL("C"),
    HIGH("H"),
    MEDIUM("M"),
    LOW("L")
}

/**
 * Конвертер для сохранения в БД краткого значения поля
 */
@Converter(autoApply = true)
class PriorityConverter : AttributeConverter<Priority?, String?> {
    override fun convertToDatabaseColumn(priority: Priority?): String? {
        return priority?.code
    }

    override fun convertToEntityAttribute(code: String?): Priority? {
        return if (code == null) {
            null
        } else Priority.values().firstOrNull { c -> c.code == code } ?: throw IllegalArgumentException()
    }
}