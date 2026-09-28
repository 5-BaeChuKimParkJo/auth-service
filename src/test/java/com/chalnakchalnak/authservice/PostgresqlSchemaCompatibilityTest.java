package com.chalnakchalnak.authservice;

import com.chalnakchalnak.authservice.adapter.out.persistence.mysql.common.BaseEntity;
import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PostgresqlSchemaCompatibilityTest {

    @Test
    void baseEntityDoesNotDeclareMysqlOnlyColumnTypes() {
        Arrays.stream(BaseEntity.class.getDeclaredFields())
                .map(field -> field.getAnnotation(Column.class))
                .filter(annotation -> annotation != null)
                .map(Column::columnDefinition)
                .forEach(definition -> assertTrue(
                        !definition.toUpperCase().contains("DATETIME")
                                && !definition.toUpperCase().contains("LONGTEXT"),
                        () -> "MySQL-only column definition: " + definition));
    }
}
