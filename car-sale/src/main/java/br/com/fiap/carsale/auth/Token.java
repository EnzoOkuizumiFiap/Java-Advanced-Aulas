package br.com.fiap.carsale.auth;

public record Token (String token, String name, String id, String role) {}