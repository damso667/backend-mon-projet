package com.example.ProjetApiBts.dto;

public record ApiResponse<T>(//cette classe permet de standardiser les reponses de l'api cet a dire de definir un format commun pour toutes les reponses envoyees par l'api
        boolean success,
        String message,
        T data
) {
    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, null, data);
    }
    public static <T> ApiResponse<T> created(T data) {
        return new ApiResponse<>(true, "created", data);
    }
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, message, null);
    }
}
