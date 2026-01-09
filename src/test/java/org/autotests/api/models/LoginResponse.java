package org.autotests.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data // Генерирует геттеры, сеттеры и toString автоматически
@JsonIgnoreProperties(ignoreUnknown = true) // Игнорирует поля типа _meta, которых нет в этом классе
public class LoginResponse {
    private String token;
}