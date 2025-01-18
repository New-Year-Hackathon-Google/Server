package com.server.backyaserver.domain.patient.domain;

import com.server.backyaserver.global.error.exception.ErrorCode;
import com.server.backyaserver.global.error.exception.NotFoundException;

public enum BloodType {
    A_plus("A+"),
    A_minus("A-"),
    B_plus("B+"),
    B_minus("B-"),
    AB_plus("AB+"),
    AB_minus("AB-"),
    O_plus("O+"),
    O_minus("O-");


    private final String value;

    BloodType(String value) {
        this.value = value;
    }

    public static BloodType findByKey(String value) {
        for (BloodType bloodType : BloodType.values()) {
            if (bloodType.value.equals(value)) {
                return bloodType;
            }
        }
        throw new NotFoundException(ErrorCode.BLOOD_TYPE_NOT_FOUND);
    }
}
