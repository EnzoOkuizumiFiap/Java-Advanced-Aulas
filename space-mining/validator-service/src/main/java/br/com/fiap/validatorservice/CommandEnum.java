package br.com.fiap.validatorservice;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(with = JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_VALUES)
public enum CommandEnum {
    FRONT,
    BACK,
    RIGHT,
    LEFT,
    OPEN,
    CLOSE
}
